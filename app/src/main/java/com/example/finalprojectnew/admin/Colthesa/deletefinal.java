package com.example.finalprojectnew.admin.Colthesa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.finalprojectnew.R;
import com.example.finalprojectnew.RecykelViewUserConterg.ClassShowPrice;
import com.example.finalprojectnew.admin.adminCategories;

public class deletefinal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deletefinal);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent=getIntent();
        ClassShowPrice csp=(ClassShowPrice)intent.getSerializableExtra("ClassShowPrice");
        ImageView imag=findViewById(R.id.imageuserdelete);
        TextView Name=findViewById(R.id.nameuserdelete);
        TextView price=findViewById(R.id.priceuserdelete);
        TextView pro=findViewById(R.id.prouserdelete);
        imag.setImageResource(csp.getImage());
        Name.setText(csp.getName());
        price.setText(""+csp.getPrice()+"$");
        pro.setText(csp.getPro());

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
            Intent intent = new Intent(getApplicationContext(), adminCategories.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
