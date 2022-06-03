package com.example.finalprojectnew.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.finalprojectnew.R;
import com.example.finalprojectnew.admin.admin;


public class mainadmin extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.mainadmin, container, false);
        Button loginadmin=view.findViewById(R.id.admin);
        loginadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), admin.class);
                startActivity(intent);
            }
        });
   return  view;
    }
}