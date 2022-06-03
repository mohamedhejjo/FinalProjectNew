package com.example.finalprojectnew.user.Clothes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.finalprojectnew.R;
import com.example.finalprojectnew.RecykelViewuser.AdapterCotr;
import com.example.finalprojectnew.RecykelViewuser.ClassCotr;

import java.util.ArrayList;

public class usermale extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usermale);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ArrayList<ClassCotr> data=new ArrayList<>();
        String jacket=getString(R.string.jacket);
        String shoe= getString(R.string.shoe);
        String jeans= getString(R.string.jeans);
        String hat= getString(R.string.hat);
        data.add(new ClassCotr(jacket,R.drawable.jacket));
        data.add(new ClassCotr(shoe,R.drawable.shoe1));
        data.add(new ClassCotr(jeans,R.drawable.jens));
        data.add(new ClassCotr(hat,R.drawable.hat));

        RecyclerView rv=findViewById(R.id.rec4);
        AdapterCotr ad=new AdapterCotr(data);
        rv.setAdapter(ad);
        rv.hasFixedSize();
        RecyclerView.LayoutManager lm=new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
    }
}