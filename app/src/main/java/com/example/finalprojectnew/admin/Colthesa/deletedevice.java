package com.example.finalprojectnew.admin.Colthesa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.finalprojectnew.R;
import com.example.finalprojectnew.RecykelViewUserConterg.Adapterdelete;
import com.example.finalprojectnew.RecykelViewUserConterg.ClassShowPrice;

import java.util.ArrayList;

public class deletedevice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dalatedevice);
        ArrayList<ClassShowPrice> data=new ArrayList<>();
        data.add(new ClassShowPrice("male!",R.drawable.male,"77","ee"));
        data.add(new ClassShowPrice("female!",R.drawable.female,"88","ee"));
        data.add(new ClassShowPrice("male!",R.drawable.male,"99","ee"));
        data.add(new ClassShowPrice("female!",R.drawable.female,"55","ee"));
        RecyclerView rv=findViewById(R.id.rec11);
        Adapterdelete ad=new Adapterdelete(data);
        rv.setAdapter(ad);
        rv.hasFixedSize();
        RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(lm);
    }
}