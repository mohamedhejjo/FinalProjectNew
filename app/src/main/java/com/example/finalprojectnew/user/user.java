package com.example.finalprojectnew.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.finalprojectnew.R;
import com.example.finalprojectnew.ViewPageradmin.Mytabadmin;
import com.example.finalprojectnew.ViewPageradmin.adapterpaferadmin;
import com.example.finalprojectnew.fragment.FragmentuserCreate;
import com.example.finalprojectnew.fragment.FragmentuserUpdate;
import com.example.finalprojectnew.fragment.Fragmentuserlogin;
import com.google.android.material.tabs.TabLayout;

public class user extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tabLayout=findViewById(R.id.tabLayoutuser);
        viewPager=findViewById(R.id.viewpageruser);
        tabLayout.setupWithViewPager(viewPager);
        String Login=getString(R.string.Login);
        String Create=getString(R.string.Create);
        String Update=getString(R.string.Update);
        adapterpaferadmin adapter=new adapterpaferadmin(getSupportFragmentManager());
        adapter.addtaps(new Mytabadmin( new Fragmentuserlogin(),Login));
        adapter.addtaps(new Mytabadmin(new FragmentuserCreate(),Create));
        adapter.addtaps(new Mytabadmin(new FragmentuserUpdate(),Update));
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
}