package com.example.finalprojectnew.admin.Colthesa;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.finalprojectnew.Class.Product;
import com.example.finalprojectnew.R;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class Updateprofinalcolthes extends AppCompatActivity {
    Spinner spinner1;
    Spinner spinner2;
    TextView name,price;
    Button update;
    String selected1;
    String selected2;
    private ImageView addimage;
    static byte[] imageContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updateprofinalcolthes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        spinner1 = findViewById(R.id.spinner11);
        spinner2 = findViewById(R.id.spinner22);
        addimage=findViewById(R.id.updateimage);
        name=findViewById(R.id.ufco1);
        price=findViewById(R.id.ufco2);
        update=findViewById(R.id.Updatecreate);
        Intent intent=getIntent();
        Product csp=(Product)intent.getSerializableExtra("productupdate");

//        addimage.setImageURI(equals(csp.getImage()));
        name.setText(csp.getName());
        price.setText(""+csp.getPrice()+"$");
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1=name.getText().toString();
                String price1=price.getText().toString();
                if (name1.isEmpty()){
                    name.setError("name not be empty");  }
                else if (price1.isEmpty()){
                    price.setError("price not be empty");  }
                else{}
            }

        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> prent, View view, int i, long l) {
                selected1 = prent.getItemAtPosition(i).toString();
                String male=getString(R.string.male);
                String female=getString(R.string.female);
                if (selected1.equals(male)) {
                    ArrayList<String> male1 = new ArrayList<>();
                    String jacket=getString(R.string.jacket);
                    String shoe= getString(R.string.shoe);
                    String jeans= getString(R.string.jeans);
                    String hat= getString(R.string.hat);
                    male1.add(jacket);
                    male1.add(shoe);
                    male1.add(jeans);
                    male1.add(hat);
                    ArrayAdapter<String> adaptermale = new ArrayAdapter<String>(prent.getContext(), android.R.layout.simple_spinner_dropdown_item, male1);
                    spinner2.setAdapter(adaptermale);
                } else if (selected1.equals(female)) {
                    ArrayList<String> female1 = new ArrayList<>();
                    String fjacket=getString(R.string.fjacket);
                    String fshoe= getString(R.string.fshoe);
                    String fdress= getString(R.string.fdress);
                    String fhat= getString(R.string.fhat);
                    female1.add(fjacket);
                    female1.add(fshoe);
                    female1.add(fdress);
                    female1.add(fhat);
                    ArrayAdapter<String> adapterfemale = new ArrayAdapter<String>(prent.getContext(), android.R.layout.simple_spinner_dropdown_item, female1);
                    spinner2.setAdapter(adapterfemale);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selected2 = adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    public void Mohamed(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent,100);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100 && resultCode==RESULT_OK){
            Uri imageuri =data.getData();
            try {
                InputStream inputStream=getContentResolver().openInputStream(imageuri);
                Bitmap descorStream = BitmapFactory.decodeStream(inputStream);
                addimage.setImageBitmap(descorStream);
                imageContent=getBytes(descorStream);
            }catch (Exception ex){
                ex.printStackTrace();
            }

        }}
    private byte[] getBytes(Bitmap descorStream) {
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        descorStream.compress(Bitmap.CompressFormat.PNG,0,stream);
        return stream.toByteArray();
    }}
