package com.example.finalprojectnew.fragment;

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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class FragmentuserCreate extends Fragment {
    EditText name,email,pass;
    Button btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragmentuser_create, container, false);
        name=view.findViewById(R.id.ed1user);
        email=view.findViewById(R.id.ed2user);
        pass=view.findViewById(R.id.ed3user);
        btn=view.findViewById(R.id.usercreate);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email1=email.getText().toString();
                String pass1=pass.getText().toString();
                String name1=name.getText().toString();
                if (email1.isEmpty()){
                    email.setError("email not be empty");
                } else if(pass1.isEmpty()) {
                    pass.setError("pass not be empty");}
                else if(name1.isEmpty()) {
                    name.setError("name not be empty");}
                else{
                    FirebaseDatabase db= FirebaseDatabase.getInstance();
                    DatabaseReference dr=db.getReference("users");
                    String id=dr.push().getKey();
                    Users user=new Users(id,name1,email1,pass1);
                    dr.child(id).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
                            }
                            email.setText("");
                            name.setText("");
                            pass.setText("");
                        }
                    });
                } }  });
   return  view;
    }
}