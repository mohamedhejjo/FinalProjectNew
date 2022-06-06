package com.example.finalprojectnew.admin.Categories;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.finalprojectnew.R;
import com.example.finalprojectnew.admin.Colthesa.addcolthes;
import com.example.finalprojectnew.admin.adminCategories;

public class add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menuadd,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.home){
            Intent intent=new Intent(getApplicationContext(), adminCategories.class);
            startActivity(intent);
finish();
        }else if(id==R.id.addcoltes){
            Intent intent=new Intent(getApplicationContext(), addcolthes.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
}