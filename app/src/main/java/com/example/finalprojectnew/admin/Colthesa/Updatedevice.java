package com.example.finalprojectnew.admin.Colthesa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.finalprojectnew.Class.Product;
import com.example.finalprojectnew.R;
import com.example.finalprojectnew.RecykelViewUserConterg.AdapterShowPrice;
import com.example.finalprojectnew.RecykelViewUserConterg.AdapterUbdate;
import com.example.finalprojectnew.RecykelViewUserConterg.ClassShowPrice;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Updatedevice extends AppCompatActivity {
    public ArrayList<Product> data2=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatedevice);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference ref=db.getReference("adddevice");
        Task<DataSnapshot> task=ref.get();
        task.addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()){
                    Iterable<DataSnapshot>data1=task.getResult().getChildren();
                    for(DataSnapshot snap:data1) {
                        Product p = snap.getValue(Product.class);
                                data2.add(p);

                    }
                    RecyclerView rv=findViewById(R.id.rec6);
                    AdapterUbdate ad=new AdapterUbdate(data2);
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
