package com.example.finalprojectnew.user.Clothes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.finalprojectnew.R;
import com.example.finalprojectnew.RecykelViewuser.AdapterCotr;
import com.example.finalprojectnew.RecykelViewuser.ClassCotr;

import java.util.ArrayList;

public class userfemale extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userfemale);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ArrayList<ClassCotr> data=new ArrayList<>();
        String fjacket=getString(R.string.fjacket);
        String fshoe= getString(R.string.fshoe);
        String fdress= getString(R.string.fdress);
        String fhat= getString(R.string.fhat);
        data.add(new ClassCotr(fjacket,R.drawable.jacuetfemale));
        data.add(new ClassCotr(fshoe,R.drawable.shosefemale));
        data.add(new ClassCotr(fdress,R.drawable.fastun));
        data.add(new ClassCotr(fhat,R.drawable.hatfemale));

        RecyclerView rv=findViewById(R.id.rec3);
        AdapterCotr ad=new AdapterCotr(data);
        rv.setAdapter(ad);
        rv.hasFixedSize();
        RecyclerView.LayoutManager lm=new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
    }
}

