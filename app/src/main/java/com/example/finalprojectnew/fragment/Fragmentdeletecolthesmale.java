package com.example.finalprojectnew.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalprojectnew.R;
import com.example.finalprojectnew.RecykelViewUserConterg.Adapterdelete;
import com.example.finalprojectnew.RecykelViewUserConterg.ClassShowPrice;

import java.util.ArrayList;

public class Fragmentdeletecolthesmale extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragmentdeletecolthesmale, container, false);
        ArrayList<ClassShowPrice> data=new ArrayList<>();
        String male= getString(R.string.male);
        String jacket=getString(R.string.jacket);
        String shoe= getString(R.string.shoe);
        String jeans= getString(R.string.jeans);
        String hat= getString(R.string.hat);
        data.add(new ClassShowPrice("male!",R.drawable.male,"50",jacket,male));
        data.add(new ClassShowPrice("male!",R.drawable.female,"80",shoe,male));
        data.add(new ClassShowPrice("male!",R.drawable.male,"100",jeans,male));
        data.add(new ClassShowPrice("male!",R.drawable.female,"200",hat,male));
        RecyclerView rv=view.findViewById(R.id.rec9);
        Adapterdelete ad=new Adapterdelete(data);
        rv.setAdapter(ad);
        rv.hasFixedSize();
        RecyclerView.LayoutManager lm=new LinearLayoutManager(container.getContext());
        rv.setLayoutManager(lm);
        return view;
    }
}