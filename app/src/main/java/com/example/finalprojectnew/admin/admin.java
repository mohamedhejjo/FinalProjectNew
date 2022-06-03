package com.example.finalprojectnew.admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.finalprojectnew.R;
import com.example.finalprojectnew.ViewPageradmin.Mytabadmin;
import com.example.finalprojectnew.ViewPageradmin.adapterpaferadmin;
import com.example.finalprojectnew.fragment.FragmentadminCreate;
import com.example.finalprojectnew.fragment.FragmentadminUpdate;
import com.example.finalprojectnew.fragment.Fragmentadminlogin;
import com.google.android.material.tabs.TabLayout;

public class admin extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tabLayout=findViewById(R.id.tabLayoutadmin);
        viewPager=findViewById(R.id.viewpageradmin);
        tabLayout.setupWithViewPager(viewPager);
        adapterpaferadmin adapter=new adapterpaferadmin(getSupportFragmentManager());
        String Login=getString(R.string.Login);
        String Create=getString(R.string.Create);
        String Update=getString(R.string.Update);
        adapter.addtaps(new Mytabadmin(new Fragmentadminlogin(),Login));
        adapter.addtaps(new Mytabadmin( new FragmentadminCreate(),Create));
        adapter.addtaps(new Mytabadmin(new FragmentadminUpdate(),Update));
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