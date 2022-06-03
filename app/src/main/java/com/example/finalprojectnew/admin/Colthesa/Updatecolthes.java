package com.example.finalprojectnew.admin.Colthesa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.finalprojectnew.R;
import com.example.finalprojectnew.ViewPageradmin.Mytabadmin;
import com.example.finalprojectnew.ViewPageradmin.adapterpaferadmin;
import com.example.finalprojectnew.fragment.FragmentUpdatecolthesfemale;
import com.example.finalprojectnew.fragment.FragmentUpdatecolthesmale;
import com.google.android.material.tabs.TabLayout;

public class Updatecolthes extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.updatecolthes);
        tabLayout=findViewById(R.id.tabLayoutadminUpdate);
        viewPager=findViewById(R.id.viewpageradminUpdate);
        tabLayout.setupWithViewPager(viewPager);
        String Male=getString(R.string.male);
        String Female=getString(R.string.female);
        adapterpaferadmin adapter=new adapterpaferadmin(getSupportFragmentManager());
        adapter.addtaps(new Mytabadmin( new FragmentUpdatecolthesmale(),Male));
        adapter.addtaps(new Mytabadmin(new FragmentUpdatecolthesfemale(),Female));
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