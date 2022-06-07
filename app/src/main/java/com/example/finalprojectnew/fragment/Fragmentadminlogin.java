package com.example.finalprojectnew.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalprojectnew.Class.Admin;
import com.example.finalprojectnew.Class.Product;
import com.example.finalprojectnew.Class.Users;
import com.example.finalprojectnew.R;
import com.example.finalprojectnew.admin.adminCategories;
import com.example.finalprojectnew.user.userCategories;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


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
                String srt ="@gmail.com";
                String email1=email.getText().toString();
                String password1=password.getText().toString();
                if (email1.isEmpty()){
                    email.setError("can not be empty");  }
                else if (password1.isEmpty()){
                    password.setError("can not be empty");  }
else if (!email1.endsWith(srt.toString())){
                    email.setError("cannot end with "+srt.toString());
                    Toast.makeText(getContext(), "cannot end with "+srt.toString(), Toast.LENGTH_SHORT).show();
                }else{

                        FirebaseDatabase db = FirebaseDatabase.getInstance();
                        DatabaseReference ref = db.getReference("Admin");
                        Task<DataSnapshot> task = ref.get();
                        task.addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DataSnapshot> task) {
                                if (task.isSuccessful()) {
                                    Iterable<DataSnapshot> data = task.getResult().getChildren();
                                    for (DataSnapshot snap : data) {
                                        Admin p = snap.getValue(Admin.class);
                                        if (p.getEmail().equals(email1) && p.getPassword().equals(password1)) {
                                            Intent intent = new Intent(getContext(), adminCategories.class);
                                            startActivity(intent);
                                            email.setText("");
                                            password.setText("");
                                        }
                                    }
                                } else {
                                    String error = task.getException().getMessage();
                                    Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });




                }
            }});

        return view;
    }
}