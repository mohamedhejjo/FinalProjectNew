package com.example.finalprojectnew.user.Categories;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalprojectnew.Class.PriceClas;
import com.example.finalprojectnew.Class.Product;
import com.example.finalprojectnew.Finish;
import com.example.finalprojectnew.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import javax.xml.parsers.FactoryConfigurationError;

public class Pricefinal extends AppCompatActivity {
    EditText namepr;
    EditText passpr;
    TextView price1,Product1;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pricefinal);
       namepr=findViewById(R.id.acol12);
        passpr=findViewById(R.id.acol3);
        btn=findViewById(R.id.addcreate);
        price1=findViewById(R.id.priceprice);
        Product1=findViewById(R.id.pricepro);
        Intent intent=getIntent();
        String id=intent.getStringExtra("id");
String price=intent.getStringExtra("price");
String Product=intent.getStringExtra("product");
price1.setText(price);
Product1.setText(Product);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namepr1=namepr.getText().toString();
                String passpr1=passpr.getText().toString();
                if (namepr1.isEmpty()) {
                    namepr.setError("namePayer not be empty");
                } else if (passpr1.isEmpty()) {
                    passpr.setError("passPayer not be empty");
                }
                else {
                    FirebaseDatabase db = FirebaseDatabase.getInstance();
                    DatabaseReference dr = db.getReference("Payer");
                    String id1 = dr.push().getKey();
                    PriceClas product = new PriceClas(id1, namepr1, passpr1, Product,  price);
                    dr.child(id1).setValue(product).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                              Intent intent1=new Intent(getBaseContext(), Finish.class);
                                startActivity(intent1);
                                FirebaseDatabase db=FirebaseDatabase.getInstance();
                DatabaseReference dr = db.getReference("addcolthes");
                dr.child(id).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){

                            Toast.makeText(getApplicationContext(), "sold", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "not sold", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                            } else {
                                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                            }
                            namepr.setText("");
                            passpr.setText("");

                        }
                    });
                }
        }});
    }
}