package com.example.finalprojectnew.user.Categories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalprojectnew.Class.Product;
import com.example.finalprojectnew.Pricefinal;
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
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  intent1=new Intent(getApplicationContext(), Pricefinal.class);
                startActivity(intent1);
            }
        });
        ImageView image=findViewById(R.id.imageprice);
        Intent intent=getIntent();
        Product csp=(Product)intent.getSerializableExtra("finalu");
        name.setText(csp.getName());
        price.setText(csp.getPrice());
        pro.setText(csp.getProduct());
//        image.setImageResource(csp.getImage());
        female.setText(csp.getSex());


    }
}