package com.example.finalprojectnew.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.finalprojectnew.R;
import com.example.finalprojectnew.RecykelViewuser.AdapterCotr;
import com.example.finalprojectnew.RecykelViewuser.ClassCotr;

import java.util.ArrayList;

public class userCategories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_categories);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ArrayList<ClassCotr> data=new ArrayList<>();
        String clothes= getString(R.string.app_name4);
        String devices= getString(R.string.app_name5);
        data.add(new ClassCotr(clothes,R.drawable.clothes));
        data.add(new ClassCotr(devices,R.drawable.computer));

        RecyclerView rv=findViewById(R.id.rec);
        AdapterCotr ad=new AdapterCotr(data);
        rv.setAdapter(ad);
        rv.hasFixedSize();
        RecyclerView.LayoutManager lm=new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
    }
}