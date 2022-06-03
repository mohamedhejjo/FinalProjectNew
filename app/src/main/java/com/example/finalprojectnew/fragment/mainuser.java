package com.example.finalprojectnew.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.finalprojectnew.R;
import com.example.finalprojectnew.user.user;


public class mainuser extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.mainuser, container, false);
        Button loginuser=view.findViewById(R.id.user);

        loginuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(), user.class);
                startActivity(intent);
            }
        });
        return view;
    }
}