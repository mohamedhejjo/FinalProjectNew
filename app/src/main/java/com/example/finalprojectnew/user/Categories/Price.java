package com.example.finalprojectnew.user.Categories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalprojectnew.R;
import com.example.finalprojectnew.RecykelViewUserConterg.ClassShowPrice;

public class Price extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.price);
        TextView name=findViewById(R.id.nameprice);
        TextView price=findViewById(R.id.priceprice);
        TextView pro=findViewById(R.id.pricepro);
        TextView female=findViewById(R.id.prfema);
        Button btn=findViewById(R.id.price);
        ImageView image=findViewById(R.id.imageprice);
        Intent intent=getIntent();
        ClassShowPrice csp=(ClassShowPrice)intent.getSerializableExtra("finalu");
        name.setText(csp.getName());
        price.setText(csp.getPrice());
        pro.setText(csp.getPro());
        image.setImageResource(csp.getImage());
        female.setText(csp.getFemal());

    }
}