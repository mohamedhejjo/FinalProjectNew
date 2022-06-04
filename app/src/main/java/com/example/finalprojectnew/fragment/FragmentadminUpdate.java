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
import com.example.finalprojectnew.R;
import com.example.finalprojectnew.admin.adminCategories;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class FragmentadminUpdate extends Fragment {
    EditText numberold,passwordold,numbernew,passwordnew,email;
    Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragmentadmin_update, container, false);
        btn=view.findViewById(R.id.adminUreate);
        numberold=view.findViewById(R.id.uadmin1);
        passwordold=view.findViewById(R.id.uadmin3);
        numbernew=view.findViewById(R.id.uadmin2);
        passwordnew=view.findViewById(R.id.uadmin4);
        email=view.findViewById(R.id.uadminemail);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numberold1=numberold.getText().toString();
                String passwordold1=passwordold.getText().toString();
                String numbernew1=numbernew.getText().toString();
                String passwordnew1=passwordnew.getText().toString();
                String email1=email.getText().toString();
                if (numberold1.isEmpty()){
                    numberold.setError("numberold not be empty"); }
                else if(passwordold1.isEmpty()){
                    passwordold.setError("passwordold not be empty");  }

                else if(numbernew1.isEmpty()){
                    numbernew.setError("numbernew not be empty");  }

                else if(passwordnew1.isEmpty()){
                    passwordnew.setError("passwordnew not be empty"); }
                else if(email1.isEmpty()){
                    passwordnew.setError("email not be empty"); }
                else {
                    FirebaseDatabase db=FirebaseDatabase.getInstance();
                    DatabaseReference ref=db.getReference("Admin");
                    Task<DataSnapshot> task=ref.get();
                    task.addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            if (task.isSuccessful()){
                                Iterable<DataSnapshot>data=task.getResult().getChildren();
                                for(DataSnapshot snap:data) {
                                    Admin p=snap.getValue(Admin.class);
                                    if(p.getNumber().equals(numberold1)&&p.getPassword().equals(passwordold1)){
                                        Admin admins=new Admin(numbernew1,passwordnew1,email1);
                                        admins.setId(p.getId());
                                 ref.child(p.getId()).setValue(admins);

                                    numberold.setText("");
                                        passwordold.setText("");
                                        numbernew.setText("");
                                        passwordnew.setText("");
                                        email.setText("");

                                    }
                                }
                            } else{
                                String error=task.getException().getMessage();
                                Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });


                }
            }});
        return view;
    }
}