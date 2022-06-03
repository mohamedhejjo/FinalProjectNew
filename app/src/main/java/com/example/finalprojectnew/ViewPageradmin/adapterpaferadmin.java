package com.example.finalprojectnew.ViewPageradmin;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class adapterpaferadmin extends FragmentStatePagerAdapter {


    ArrayList<Mytabadmin> tabs=new ArrayList<>();
    public adapterpaferadmin( FragmentManager fm) {
        super(fm);
    }
    public void addtaps(Mytabadmin tap){
        tabs.add(tap);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return tabs.get(position).getFr();
    }
    public CharSequence getPageTitle(int position){
        return  tabs.get(position).getTitle();
    }
    @Override
    public int getCount() {
        return tabs.size();
    }
}
