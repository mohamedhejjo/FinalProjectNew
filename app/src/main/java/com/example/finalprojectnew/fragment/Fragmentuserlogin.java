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
import com.example.finalprojectnew.user.userCategories;


public class Fragmentuserlogin extends Fragment {
    EditText email,password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragmentuserlogin, container, false);
        Button btnuser=view.findViewById(R.id.userlogin);
        email=view.findViewById(R.id.edt1);
        password=view.findViewById(R.id.edt2);
        btnuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email1=email.getText().toString();
                String pass1=password.getText().toString();
                if (email1.isEmpty()){
                    email.setError("can not be empty");
                }else if(pass1.isEmpty()) {
                    password.setError("can not be empty");  }

                else {}

                Intent intent = new Intent(getActivity().getBaseContext(), userCategories.class);
                startActivity(intent);
            }
        });
    return view;
    }
}