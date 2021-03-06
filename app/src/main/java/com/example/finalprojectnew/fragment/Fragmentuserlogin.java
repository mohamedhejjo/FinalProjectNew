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

import com.example.finalprojectnew.Class.Users;
import com.example.finalprojectnew.R;
import com.example.finalprojectnew.user.userCategories;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


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
                String srt ="@gmail.com";
                String email1=email.getText().toString();
                String pass1=password.getText().toString();
                if (email1.isEmpty()){
                    email.setError("can not be empty");
                }else if(pass1.isEmpty()) {
                    password.setError("can not be empty");  }

                else if (!email1.endsWith(srt.toString())){
                    email.setError("cannot end with "+srt.toString());
                    Toast.makeText(getContext(), "cannot end with "+srt.toString(), Toast.LENGTH_SHORT).show();
                }else{
                    {
                        FirebaseDatabase db = FirebaseDatabase.getInstance();
                        DatabaseReference ref = db.getReference("users");
                        Task<DataSnapshot> task = ref.get();
                        task.addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DataSnapshot> task) {
                                if (task.isSuccessful()) {
                                    Iterable<DataSnapshot> data = task.getResult().getChildren();
                                    for (DataSnapshot snap : data) {
                                        Users p = snap.getValue(Users.class);
                                        if (p.getEmail().equals(email1) && p.getPassword().equals(pass1)) {
                                            Intent intent = new Intent(getContext(), userCategories.class);
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
                } }});
    return view;
    }
}