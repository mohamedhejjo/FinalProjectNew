package com.example.finalprojectnew.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.finalprojectnew.R;
import com.example.finalprojectnew.admin.adminCategories;


public class Fragmentadminlogin extends Fragment {
    EditText email,password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragmentadminlogin, container, false);
        Button btnlogin=view.findViewById(R.id.adminlogin);
        email=view.findViewById(R.id.eadmin1);
        password=view.findViewById(R.id.eadmin2);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email1=email.getText().toString();
                String password1=password.getText().toString();
                if (email1.isEmpty()){
                    email.setError("can not be empty");  }
                else if (password1.isEmpty()){
                    password.setError("can not be empty");  }
                else{}

                Intent intent = new Intent(getActivity().getBaseContext(), adminCategories.class);
                startActivity(intent);
            }
        });

        return view;
    }
}