package com.example.finalprojectnew.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.finalprojectnew.R;


public class FragmentuserUpdate extends Fragment {
    EditText nameold,passwordold,namenew,passwordnew;
    Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragmentuser_update, container, false);
        btn=view.findViewById(R.id.updateuser);
        nameold=view.findViewById(R.id.uuser1);
        passwordold=view.findViewById(R.id.uuser3);
        namenew=view.findViewById(R.id.uuser2);
        passwordnew=view.findViewById(R.id.uuser4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameold1=nameold.getText().toString();
                String passwordold1=passwordold.getText().toString();
                String namenew1=namenew.getText().toString();
                String passwordnew1=passwordnew.getText().toString();
                if (nameold1.isEmpty()){
                    nameold.setError("can not be empty");  }
                else if(passwordold1.isEmpty()){
                    passwordold.setError("can not be empty");  }
                else if(namenew1.isEmpty()){
                    namenew.setError("can not be empty");  }
                else if(passwordnew1.isEmpty()){
                    passwordnew.setError("can not be empty");  }
                else{}
            }


        });
        return view;
    }
}