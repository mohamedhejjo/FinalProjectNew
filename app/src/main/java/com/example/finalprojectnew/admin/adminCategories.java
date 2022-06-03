package com.example.finalprojectnew.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.finalprojectnew.R;

public class adminCategories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_categories);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button add=findViewById(R.id.add);
        Button delete=findViewById(R.id.delete);
        Button update=findViewById(R.id.update);

        add.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(), com.example.finalprojectnew.admin.Categories.add.class);
            startActivity(intent);
        });
        delete.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(), com.example.finalprojectnew.admin.Categories.delete.class);
            startActivity(intent);
        });
        update.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(), com.example.finalprojectnew.admin.Categories.update.class);
            startActivity(intent);
        });

    }
}