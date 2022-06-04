package com.example.finalprojectnew.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.finalprojectnew.Class.Product;
import com.example.finalprojectnew.R;
import com.example.finalprojectnew.RecykelViewUserConterg.AdapterUbdate;
import com.example.finalprojectnew.RecykelViewUserConterg.Adapterfinaluser;
import com.example.finalprojectnew.RecykelViewUserConterg.ClassShowPrice;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class FragmentUpdatecolthesmale extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragmentupdatecolthesmale, container, false);
        ArrayList<Product> data=new ArrayList<Product>();

        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference ref=db.getReference("addcolthes");
        Task<DataSnapshot> task=ref.get();
        task.addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()){
                    Iterable<DataSnapshot>data1=task.getResult().getChildren();
                    for(DataSnapshot snap:data1) {
                        Product p = snap.getValue(Product.class);
                        String name=p.getSex();
                        String male=getString(R.string.male);
                        if (name.equals(male)){
                            data.add(p);
                        }
                    }                    RecyclerView rv=view.findViewById(R.id.rec8);

                    AdapterUbdate ad=new AdapterUbdate(data);
                    rv.setAdapter(ad);
                    RecyclerView.LayoutManager lm=new LinearLayoutManager(getContext());
                    rv.setLayoutManager(lm);
                }
                else{
                    String error=task.getException().getMessage();
                    Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}