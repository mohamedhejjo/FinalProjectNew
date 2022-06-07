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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class FragmentuserUpdate extends Fragment {
    EditText nameold,passwordold,namenew,passwordnew,email;
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
        email=view.findViewById(R.id.uuseremail);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String srt ="@gmail.com";
                String nameold1=nameold.getText().toString();
                String passwordold1=passwordold.getText().toString();
                String namenew1=namenew.getText().toString();
                String passwordnew1=passwordnew.getText().toString();
                String email1=email.getText().toString();
                if (nameold1.isEmpty()){
                    nameold.setError("nameold not be empty");  }
                else if(passwordold1.isEmpty()){
                    passwordold.setError("passwordold not be empty");  }
                else if(namenew1.isEmpty()){
                    namenew.setError("namenew not be empty");  }
                else if(passwordnew1.isEmpty()){
                    passwordnew.setError("passwordnew not be empty");  }
                else if(email1.isEmpty()){
                    email.setError("email not be empty");  }
                else if (!email1.endsWith(srt.toString())){
                    email.setError("cannot end with "+srt.toString());
                    Toast.makeText(getContext(), "cannot end with "+srt.toString(), Toast.LENGTH_SHORT).show();
                }else{
                    FirebaseDatabase db=FirebaseDatabase.getInstance();
                    DatabaseReference ref=db.getReference("users");
                    Task<DataSnapshot> task=ref.get();
                    task.addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            if (task.isSuccessful()){
                                Iterable<DataSnapshot>data=task.getResult().getChildren();
                                for(DataSnapshot snap:data) {
                                    Users p=snap.getValue(Users.class);
                                    if(p.getName().equals(nameold1)&&p.getPassword().equals(passwordold1)){
                                        Admin admins=new Admin(namenew1,passwordnew1,email1);
                                        admins.setId(p.getId());
                                        ref.child(p.getId()).setValue(admins);

                                        nameold.setText("");
                                        passwordold.setText("");
                                        namenew.setText("");
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