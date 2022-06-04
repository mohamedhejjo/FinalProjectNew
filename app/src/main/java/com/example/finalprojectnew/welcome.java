package com.example.finalprojectnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.finalprojectnew.admin.admin;
import com.example.finalprojectnew.user.user;

import java.util.Locale;

public class welcome extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ImageButton next = findViewById(R.id.next);
        ImageButton next2 = findViewById(R.id.next2);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),user.class);
                startActivity(intent);
            }
        });
        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(), admin.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.lang,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.Arabic){
            setLocale("ar");

        }else if(id==R.id.Einglish){
            setLocale("en");
        }

        return super.onOptionsItemSelected(item);
    }
    @SuppressWarnings("deprecation")
    public  void setLocale(String lang){
        Locale mylocale=new Locale(lang);
        DisplayMetrics dm=getResources().getDisplayMetrics();
        Configuration conf=getResources().getConfiguration();
        conf.locale=mylocale;
        getResources().updateConfiguration(conf,dm);
        Intent intent=new Intent(getApplicationContext(), welcome.class);
        startActivity(intent);
        finish();

    }
}