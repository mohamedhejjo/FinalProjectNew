package com.example.finalprojectnew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;

import com.example.finalprojectnew.ViewPageradmin.Mytabadmin;
import com.example.finalprojectnew.ViewPageradmin.adapterpaferadmin;
import com.example.finalprojectnew.fragment.mainadmin;
import com.example.finalprojectnew.fragment.mainuser;
import com.google.android.material.tabs.TabLayout;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=findViewById(R.id.tabLayouthome);
        viewPager=findViewById(R.id.viewpagerhome);
        tabLayout.setupWithViewPager(viewPager);
        String admin=getString(R.string.app_name1);
        String user=getString(R.string.app_name2);
        adapterpaferadmin adapter=new adapterpaferadmin(getSupportFragmentManager());
        adapter.addtaps(new Mytabadmin( new mainadmin(),admin));
        adapter.addtaps(new Mytabadmin(new mainuser(),user));
        viewPager.setAdapter(adapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

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
        Intent intent=new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();

    }
}