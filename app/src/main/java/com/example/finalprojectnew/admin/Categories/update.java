package com.example.finalprojectnew.admin.Categories;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.finalprojectnew.R;
import com.example.finalprojectnew.admin.Colthesa.Updatecolthes;
import com.example.finalprojectnew.admin.Colthesa.Updatedevice;
import com.example.finalprojectnew.admin.adminCategories;
import com.google.android.material.tabs.TabLayout;

public class update extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.meunupdate,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.homeupdate){
            Intent intent=new Intent(getApplicationContext(), adminCategories.class);
            startActivity(intent);

        }else if(id==R.id.updatecoltes){
            Intent intent=new Intent(getApplicationContext(), Updatecolthes.class);
            startActivity(intent);
        }
        else if(id==R.id.updatedevices){
            Intent intent=new Intent(getApplicationContext(), Updatedevice.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}