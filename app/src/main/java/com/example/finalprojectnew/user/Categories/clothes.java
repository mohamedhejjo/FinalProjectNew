package com.example.finalprojectnew.user.Categories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.finalprojectnew.R;
import com.example.finalprojectnew.RecykelViewuser.AdapterCotr;
import com.example.finalprojectnew.RecykelViewuser.ClassCotr;

import java.util.ArrayList;

public class clothes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clothes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String male= getString(R.string.male);
        String female= getString(R.string.female);
        ArrayList<ClassCotr> data=new ArrayList<>();
        data.add(new ClassCotr(male,R.drawable.male));
        data.add(new ClassCotr(female,R.drawable.female));
        RecyclerView rv=findViewById(R.id.rec22);
        AdapterCotr ad=new AdapterCotr(data);
        rv.setAdapter(ad);
        rv.hasFixedSize();
        RecyclerView.LayoutManager lm=new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
    }
}