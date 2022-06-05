package com.example.finalprojectnew.admin.Colthesa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalprojectnew.Class.Product;
import com.example.finalprojectnew.R;
import com.example.finalprojectnew.admin.adminCategories;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class deletefinal extends AppCompatActivity {
    private String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deletefinal);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        View view;
        Intent intent=getIntent();
        Product csp=(Product)intent.getSerializableExtra("productdelete");
        ImageView imag=findViewById(R.id.imageuserdelete);
        TextView Name=findViewById(R.id.nameuserdelete);
        TextView price=findViewById(R.id.priceuserdelete);
        TextView pro=findViewById(R.id.prouserdelete);
//        imag.setImageURI(csp.getImage());
        Name.setText(csp.getName());
        price.setText(""+csp.getPrice()+"$");
        pro.setText(csp.getProduct());
         id=csp.getId();

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
            FirebaseDatabase db=FirebaseDatabase.getInstance();
            DatabaseReference dr = db.getReference("addcolthes");
            dr.child(String.valueOf(id));
            dr.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Intent intent = new Intent(getApplicationContext(), adminCategories.class);
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
