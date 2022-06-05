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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.finalprojectnew.Class.Product;
import com.example.finalprojectnew.R;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class Updateprofinaldevice extends AppCompatActivity {
    private ImageView addimage;
        TextView name,price;
        Button update;
        String selected;
        Spinner spinner;
        static byte[] imageContentdevicesUpdate;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.updateprofinaldevice);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            addimage = findViewById(R.id.updateimage);
            name = findViewById(R.id.ufina1);
            price = findViewById(R.id.ufina2);
            update = findViewById(R.id.Updatecreatedivaec);
             spinner= findViewById(R.id.spinner4);
            Intent intent=getIntent();
            Product csp=(Product)intent.getSerializableExtra("productupdate");

//        addimage.setImageURI(equals(csp.getImage()));
            name.setText(csp.getName());
            price.setText(""+csp.getPrice()+"$");

            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String name1 = name.getText().toString();
                    String price1 = price.getText().toString();
                    if (name1.isEmpty()) {
                        name.setError("name not be empty");
                    } else if (price1.isEmpty()) {
                        price.setError("price not be empty");
                    } else {
                    }
                }

            });
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    selected = adapterView.getItemAtPosition(i).toString();

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
                    imageContentdevicesUpdate=getBytes(descorStream);
                }catch (Exception ex){
                    ex.printStackTrace();
                }

            }}
        private byte[] getBytes(Bitmap descorStream) {
            ByteArrayOutputStream stream=new ByteArrayOutputStream();
            descorStream.compress(Bitmap.CompressFormat.PNG,0,stream);
            return stream.toByteArray();
        }

    }
