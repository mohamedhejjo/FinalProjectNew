package com.example.finalprojectnew.user.Categories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.finalprojectnew.R;
import com.example.finalprojectnew.RecykelViewUserConterg.Adapterfinaluser;
import com.example.finalprojectnew.RecykelViewUserConterg.ClassShowPrice;

import java.util.ArrayList;

public class activityuserfinal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityuserfinal);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent=getIntent();
        String pro=intent.getStringExtra("finaluser");
        String female=getString(R.string.female);
        String male=getString(R.string.male);
        String laptop=getString(R.string.laptop);
        String mouse=getString(R.string.mouse);
        String keyboard= getString(R.string.keyboard);
        String playstation= getString(R.string.playstation);
        String fjacket=getString(R.string.fjacket);
        String fshoe= getString(R.string.fshoe);
        String fdress= getString(R.string.fdress);
        String fhat= getString(R.string.fhat);
        String jacket=getString(R.string.fjacket);
        String shoe= getString(R.string.fshoe);
        String jeans= getString(R.string.jeans);
        String hat= getString(R.string.hat);
        if (pro.equals(jacket)){
            ArrayList<ClassShowPrice> data=new ArrayList<>();
            data.add(new ClassShowPrice("male1",R.drawable.male,"300",jacket,male));
            data.add(new ClassShowPrice("female",R.drawable.female,"400",jacket,male));
            data.add(new ClassShowPrice("male",R.drawable.male,"500",jacket,male));
            data.add(new ClassShowPrice("female",R.drawable.female,"600",jacket,male));
            RecyclerView rv=findViewById(R.id.recy1);
            Adapterfinaluser ad=new Adapterfinaluser(data);
            rv.setAdapter(ad);
            rv.hasFixedSize();
            RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
            rv.setLayoutManager(lm);
        }else if(pro.equals(shoe)){
            ArrayList<ClassShowPrice> data=new ArrayList<>();
            data.add(new ClassShowPrice("male2",R.drawable.male,"300",shoe,male));
            data.add(new ClassShowPrice("female",R.drawable.female,"400",shoe,male));
            data.add(new ClassShowPrice("male",R.drawable.male,"500",shoe,male));
            data.add(new ClassShowPrice("female",R.drawable.female,"600",shoe,male));
            RecyclerView rv=findViewById(R.id.recy1);
            Adapterfinaluser ad=new Adapterfinaluser(data);
            rv.setAdapter(ad);
            rv.hasFixedSize();
            RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
            rv.setLayoutManager(lm);
        }else if(pro.equals(jeans)){
            ArrayList<ClassShowPrice> data=new ArrayList<>();
            data.add(new ClassShowPrice("male3",R.drawable.male,"300",jeans,male));
            data.add(new ClassShowPrice("female",R.drawable.female,"400",jeans,male));
            data.add(new ClassShowPrice("male",R.drawable.male,"500",jeans,male));
            data.add(new ClassShowPrice("female",R.drawable.female,"600",jeans,male));
            RecyclerView rv=findViewById(R.id.recy1);
            Adapterfinaluser ad=new Adapterfinaluser(data);
            rv.setAdapter(ad);
            rv.hasFixedSize();
            RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
            rv.setLayoutManager(lm);
        }else if(pro.equals(hat)){
            ArrayList<ClassShowPrice> data=new ArrayList<>();
            data.add(new ClassShowPrice("male4",R.drawable.male,"300",hat,male));
            data.add(new ClassShowPrice("female",R.drawable.female,"400",hat,male));
            data.add(new ClassShowPrice("male",R.drawable.male,"500",hat,male));
            data.add(new ClassShowPrice("female",R.drawable.female,"600",hat,male));
            RecyclerView rv=findViewById(R.id.recy1);
            Adapterfinaluser ad=new Adapterfinaluser(data);
            rv.setAdapter(ad);
            rv.hasFixedSize();
            RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
            rv.setLayoutManager(lm);
        }else if(pro.equals(fjacket)){
            ArrayList<ClassShowPrice> data=new ArrayList<>();
            data.add(new ClassShowPrice("male5",R.drawable.male,"300",fjacket,female));
            data.add(new ClassShowPrice("female",R.drawable.female,"400",fjacket,female));
            data.add(new ClassShowPrice("male",R.drawable.male,"500",fjacket,female));
            data.add(new ClassShowPrice("female",R.drawable.female,"600",fjacket,female));
            RecyclerView rv=findViewById(R.id.recy1);
            Adapterfinaluser ad=new Adapterfinaluser(data);
            rv.setAdapter(ad);
            rv.hasFixedSize();
            RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
            rv.setLayoutManager(lm);
        }else if(pro.equals(fshoe)){
            ArrayList<ClassShowPrice> data=new ArrayList<>();
            data.add(new ClassShowPrice("male6",R.drawable.male,"300",fshoe,female));
            data.add(new ClassShowPrice("female",R.drawable.female,"400",fshoe,female));
            data.add(new ClassShowPrice("male",R.drawable.male,"500",fshoe,female));
            data.add(new ClassShowPrice("female",R.drawable.female,"600",fshoe,female));
            RecyclerView rv=findViewById(R.id.recy1);
            Adapterfinaluser ad=new Adapterfinaluser(data);
            rv.setAdapter(ad);
            rv.hasFixedSize();
            RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
            rv.setLayoutManager(lm);
        }else if(pro.equals(fdress)){
            ArrayList<ClassShowPrice> data=new ArrayList<>();
            data.add(new ClassShowPrice("male7",R.drawable.male,"300",fdress,female));
            data.add(new ClassShowPrice("female",R.drawable.female,"400",fdress,female));
            data.add(new ClassShowPrice("male",R.drawable.male,"500",fdress,female));
            data.add(new ClassShowPrice("female",R.drawable.female,"600",fdress,female));
            RecyclerView rv=findViewById(R.id.recy1);
            Adapterfinaluser ad=new Adapterfinaluser(data);
            rv.setAdapter(ad);
            rv.hasFixedSize();
            RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
            rv.setLayoutManager(lm);
        }else if(pro.equals(fhat)){
            ArrayList<ClassShowPrice> data=new ArrayList<>();
            data.add(new ClassShowPrice("male8",R.drawable.male,"300",fhat,female));
            data.add(new ClassShowPrice("female",R.drawable.female,"400",fhat,female));
            data.add(new ClassShowPrice("male",R.drawable.male,"500",fhat,female));
            data.add(new ClassShowPrice("female",R.drawable.female,"600",fhat,female));
            RecyclerView rv=findViewById(R.id.recy1);
            Adapterfinaluser ad=new Adapterfinaluser(data);
            rv.setAdapter(ad);
            rv.hasFixedSize();
            RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
            rv.setLayoutManager(lm);
        }else if(pro.equals(laptop)){
            ArrayList<ClassShowPrice> data=new ArrayList<>();
            data.add(new ClassShowPrice("male9",R.drawable.male,"300",laptop));
            data.add(new ClassShowPrice("female",R.drawable.female,"400",laptop));
            data.add(new ClassShowPrice("male",R.drawable.male,"500",laptop));
            data.add(new ClassShowPrice("female",R.drawable.female,"600",laptop));
            RecyclerView rv=findViewById(R.id.recy1);
            Adapterfinaluser ad=new Adapterfinaluser(data);
            rv.setAdapter(ad);
            rv.hasFixedSize();
            RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
            rv.setLayoutManager(lm);
        }else if(pro.equals(mouse)){
            ArrayList<ClassShowPrice> data=new ArrayList<>();
            data.add(new ClassShowPrice("male10",R.drawable.male,"300",mouse));
            data.add(new ClassShowPrice("female",R.drawable.female,"400",mouse));
            data.add(new ClassShowPrice("male",R.drawable.male,"500",mouse));
            data.add(new ClassShowPrice("female",R.drawable.female,"600",mouse));
            RecyclerView rv=findViewById(R.id.recy1);
            Adapterfinaluser ad=new Adapterfinaluser(data);
            rv.setAdapter(ad);
            rv.hasFixedSize();
            RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
            rv.setLayoutManager(lm);
        }else if(pro.equals(keyboard)){
            ArrayList<ClassShowPrice> data=new ArrayList<>();
            data.add(new ClassShowPrice("male11",R.drawable.male,"300",keyboard));
            data.add(new ClassShowPrice("female",R.drawable.female,"400",keyboard));
            data.add(new ClassShowPrice("male",R.drawable.male,"500",keyboard));
            data.add(new ClassShowPrice("female",R.drawable.female,"600",keyboard));
            RecyclerView rv=findViewById(R.id.recy1);
            Adapterfinaluser ad=new Adapterfinaluser(data);
            rv.setAdapter(ad);
            rv.hasFixedSize();
            RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
            rv.setLayoutManager(lm);
        }else if(pro.equals(playstation)){
            ArrayList<ClassShowPrice> data=new ArrayList<>();
            data.add(new ClassShowPrice("male12",R.drawable.male,"300",playstation));
            data.add(new ClassShowPrice("female",R.drawable.female,"400",playstation));
            data.add(new ClassShowPrice("male",R.drawable.male,"500",playstation));
            data.add(new ClassShowPrice("female",R.drawable.female,"600",playstation));
            RecyclerView rv=findViewById(R.id.recy1);
            Adapterfinaluser ad=new Adapterfinaluser(data);
            rv.setAdapter(ad);
            rv.hasFixedSize();
            RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
            rv.setLayoutManager(lm);
        }
    }
}