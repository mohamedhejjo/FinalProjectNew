package com.example.finalprojectnew.admin.Colthesa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.finalprojectnew.Class.Product;
import com.example.finalprojectnew.Class.Productdevice;
import com.example.finalprojectnew.R;
import com.example.finalprojectnew.RecykelViewUserConterg.AdapterUbdate;
import com.example.finalprojectnew.RecykelViewUserConterg.Adapterdelete;
import com.example.finalprojectnew.RecykelViewUserConterg.Adapterdeletedevice;
import com.example.finalprojectnew.RecykelViewUserConterg.ClassShowPrice;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class deletedevice extends AppCompatActivity {
    public ArrayList<Productdevice> data2=new ArrayList<Productdevice>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dalatedevice);
        data2.clear();
        FirebaseDatabase db2=FirebaseDatabase.getInstance();
        DatabaseReference ref2=db2.getReference("adddevice");
        Task<DataSnapshot> task2=ref2.get();
        task2.addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()){
                    Iterable<DataSnapshot>data3=task.getResult().getChildren();
                    for(DataSnapshot snap:data3) {
                        Productdevice p = snap.getValue(Productdevice.class);
                            data2.add(p);

                    }
                    RecyclerView rv=findViewById(R.id.rec11);
                    Adapterdeletedevice ad=new Adapterdeletedevice(data2);
                    rv.setAdapter(ad);
                    RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
                    rv.setLayoutManager(lm);
                }
                else{
                    String error=task.getException().getMessage();
                    Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}