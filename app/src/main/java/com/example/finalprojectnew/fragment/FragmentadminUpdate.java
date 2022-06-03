package com.example.finalprojectnew.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.finalprojectnew.R;


public class FragmentadminUpdate extends Fragment {
    EditText numberold,passwordold,numbernew,passwordnew;
    Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragmentadmin_update, container, false);
        btn=view.findViewById(R.id.admincreate);
        numberold=view.findViewById(R.id.uadmin1);
        passwordold=view.findViewById(R.id.uadmin3);
        numbernew=view.findViewById(R.id.uadmin2);
        passwordnew=view.findViewById(R.id.uadmin4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberold1=numberold.getText().toString();
                String passwordold1=passwordold.getText().toString();
                String numbernew1=numbernew.getText().toString();
                String passwordnew1=passwordnew.getText().toString();
                if (numberold1.isEmpty()){
                    numberold.setError("can not be empty"); }
                else if(passwordold1.isEmpty()){
                    passwordold.setError("can not be empty");  }

                else if(numbernew1.isEmpty()){
                    numbernew.setError("can not be empty");  }

                else if(passwordnew1.isEmpty()){
                    passwordnew.setError("can not be empty"); }

                else{}
            }


        });
        return view;
    }
}