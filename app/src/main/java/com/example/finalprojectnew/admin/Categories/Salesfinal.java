package com.example.finalprojectnew.admin.Categories;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalprojectnew.Class.PriceClas;
import com.example.finalprojectnew.Class.Product;
import com.example.finalprojectnew.R;
import com.example.finalprojectnew.admin.Colthesa.deletecolthes;
import com.example.finalprojectnew.user.Categories.Pricefinal;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Salesfinal extends AppCompatActivity {
    ImageView imageView;
    TextView name,product,price;
    String id1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salesfinal);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageView=findViewById(R.id.image);
        name=findViewById(R.id.nameacco);
        product=findViewById(R.id.Producer);
        price=findViewById(R.id.priceprice);
        Intent intent=getIntent();
        PriceClas csp=(PriceClas)intent.getSerializableExtra("price");
        name.setText(csp.getNamepyar());
        price.setText(csp.getPrice());
        product.setText(csp.getName());
        id1=csp.getId();
        String nameeeee;
        FirebaseStorage fs=FirebaseStorage.getInstance();
        StorageReference sr=fs.getReference().child(csp.getImage());
        int Mohamed=1024*1024;
        sr.getBytes(Mohamed).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                imageView.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.deletefinal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.delete) {
            Intent intent=getIntent();
            PriceClas csp=(PriceClas)intent.getSerializableExtra("price");
            String  id1=csp.getId();
            FirebaseDatabase db=FirebaseDatabase.getInstance();
            DatabaseReference dr = db.getReference("Payer");

            dr.child(id1).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){

                        Intent intent = new Intent(getApplicationContext(), Sales.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "delete", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "not delete", Toast.LENGTH_SHORT).show();
                    }

                }
            });

        }
        return super.onOptionsItemSelected(item);
    }
}