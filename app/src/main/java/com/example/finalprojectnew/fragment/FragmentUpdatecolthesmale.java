package com.example.finalprojectnew.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalprojectnew.R;
import com.example.finalprojectnew.RecykelViewUserConterg.AdapterUbdate;
import com.example.finalprojectnew.RecykelViewUserConterg.ClassShowPrice;

import java.util.ArrayList;

public class FragmentUpdatecolthesmale extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragmentupdatecolthesmale, container, false);
        ArrayList<ClassShowPrice> data=new ArrayList<>();
        String male= getString(R.string.male);
        String jacket=getString(R.string.jacket);
        String shoe= getString(R.string.shoe);
        String jeans= getString(R.string.jeans);
        String hat= getString(R.string.hat);
        data.add(new ClassShowPrice("male",R.drawable.male,"100",jacket,male));
        data.add(new ClassShowPrice("female",R.drawable.female,"1000",shoe,male));
        data.add(new ClassShowPrice("male",R.drawable.male,"3000",jeans,male));
        data.add(new ClassShowPrice("female",R.drawable.female,"40000",hat,male));
        RecyclerView rv=view.findViewById(R.id.rec8);
        AdapterUbdate ad=new AdapterUbdate(data);
        rv.setAdapter(ad);
        rv.hasFixedSize();
        RecyclerView.LayoutManager lm=new LinearLayoutManager(container.getContext());
        rv.setLayoutManager(lm);
        return view;
    }
}