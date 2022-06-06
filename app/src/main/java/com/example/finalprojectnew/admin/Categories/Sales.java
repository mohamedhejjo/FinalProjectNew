package com.example.finalprojectnew.admin.Categories;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.finalprojectnew.Class.PriceClas;
import com.example.finalprojectnew.Class.Product;
import com.example.finalprojectnew.R;
import com.example.finalprojectnew.RecykelViewUserConterg.Adapterdelete;
import com.example.finalprojectnew.Recyviewsales.Adaptersales;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Sales extends AppCompatActivity {
    public ArrayList<PriceClas> data1=new ArrayList<PriceClas>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference ref=db.getReference("Payer");
        Task<DataSnapshot> task=ref.get();
        task.addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()){
                    Iterable<DataSnapshot>data=task.getResult().getChildren();
                    for(DataSnapshot snap:data) {
                        PriceClas p = snap.getValue(PriceClas.class);
                        data1.add(p);
                        RecyclerView rv=findViewById(R.id.rec20);
                        Adaptersales ad=new Adaptersales(data1);
                    rv.setAdapter(ad);
                    RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());
                    rv.setLayoutManager(lm);
                }}
                else{
                    String error=task.getException().getMessage();
                    Toast.makeText(getBaseContext(), error, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}