package com.example.finalprojectnew.user.Categories;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalprojectnew.Class.Admin;
import com.example.finalprojectnew.Class.PriceClas;
import com.example.finalprojectnew.Class.Product;
import com.example.finalprojectnew.Finish;
import com.example.finalprojectnew.R;
import com.example.finalprojectnew.admin.Colthesa.deletecolthes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Price extends AppCompatActivity {
String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.price);
        TextView name=findViewById(R.id.nameprice);
        TextView price=findViewById(R.id.priceprice);
        TextView pro=findViewById(R.id.pricepro);
        TextView female=findViewById(R.id.prfema);
        Button btn=findViewById(R.id.buy);
        ImageView image=findViewById(R.id.imageprice);
        Intent intent=getIntent();
        Product csp=(Product)intent.getSerializableExtra("finalu");
        name.setText(csp.getName());
        id=csp.getId();
        price.setText(csp.getPrice());
        pro.setText(csp.getProduct());
        female.setText(csp.getSex());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getBaseContext(), Pricefinal.class);
                i.putExtra("price",csp.getPrice());
                i.putExtra("product",csp.getProduct());
                i.putExtra("name",csp.getName());
                i.putExtra("id",csp.getId());
                i.putExtra("image",csp.getImage());
                startActivity(i);
            }
        });


    }}
