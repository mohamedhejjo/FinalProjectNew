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

import com.example.finalprojectnew.Class.Admin;
import com.example.finalprojectnew.Class.Users;
import com.example.finalprojectnew.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class FragmentadminCreate extends Fragment {
    EditText number,password,email;
    Button btnlogin;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragmentadmin_create, container, false);
        btnlogin=view.findViewById(R.id.admincreate);
        email=view.findViewById(R.id.ed2useradmin);
        password=view.findViewById(R.id.ed3useradmin);
        number=view.findViewById(R.id.ed1useradmin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String srt ="@gmail.com";
                String number1=number.getText().toString();
                String email1=email.getText().toString();
                String password1=password.getText().toString();
                if (email1.isEmpty()){
                    email.setError("email not be empty"); }
                else if (number1.isEmpty()){
                    number.setError("number not be empty");  }
                else if (password1.isEmpty()){
                    password.setError("password not be empty");  }
                else if (!email1.endsWith(srt.toString())){
                    email.setError("cannot end with "+srt.toString());
                    Toast.makeText(getContext(), "cannot end with "+srt.toString(), Toast.LENGTH_SHORT).show();
                }else{  FirebaseDatabase db= FirebaseDatabase.getInstance();
                    DatabaseReference dr=db.getReference("Admin");
                    String id=dr.push().getKey();
                    Admin admin=new Admin(id,number1,email1,password1);
                    dr.child(id).setValue(admin).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(getContext(), "Success", Toast.LENGTH_SHORT).show();

                            }else{
                                Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
                            }
                            email.setText("");
                            number.setText("");
                            password.setText("");
                        }
                    });
                } }  });
        return  view;
    }
}