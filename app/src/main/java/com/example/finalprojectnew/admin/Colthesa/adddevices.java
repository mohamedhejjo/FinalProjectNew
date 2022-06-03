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

import com.example.finalprojectnew.R;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class adddevices extends AppCompatActivity {

    private ImageView adddevices;
    static byte[] imageContentdevices;
    TextView name, price;
    Spinner spinner;
    String selected;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adddevices);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        adddevices = findViewById(R.id.addimage);
        name = findViewById(R.id.adv1);
        price = findViewById(R.id.adv2);
        add = findViewById(R.id.addcreatedivaec);
        spinner = findViewById(R.id.spinner3);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1 = name.getText().toString();
                String price1 = price.getText().toString();
                if (name1.isEmpty()) {
                    name.setError("can not be empty");
                } else if (price1.isEmpty()) {
                    price.setError("can not be empty");
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
        startActivityForResult(intent, 100);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            Uri imageuri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(imageuri);
                Bitmap descorStream = BitmapFactory.decodeStream(inputStream);
                adddevices.setImageBitmap(descorStream);
                imageContentdevices = getBytes(descorStream);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }

    private byte[] getBytes(Bitmap descorStream) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        descorStream.compress(Bitmap.CompressFormat.PNG, 0, stream);
        return stream.toByteArray();
    }
}
