package com.example.finalprojectnew.admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.finalprojectnew.R;
import com.example.finalprojectnew.admin.Categories.Sales;
import com.example.finalprojectnew.admin.Colthesa.addcolthes;

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
            startActivity(intent);finish();
        });
        delete.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(), com.example.finalprojectnew.admin.Categories.delete.class);
            startActivity(intent);finish();
        });
        update.setOnClickListener(v -> {
            Intent intent=new Intent(getApplicationContext(), com.example.finalprojectnew.admin.Categories.update.class);
            startActivity(intent);finish();
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.price,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.sales) {
            Intent intent = new Intent(getApplicationContext(), Sales.class);
            startActivity(intent);finish();

        }

        return super.onOptionsItemSelected(item);
    }
}