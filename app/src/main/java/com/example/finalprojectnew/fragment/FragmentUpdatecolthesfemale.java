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
import com.example.finalprojectnew.RecykelViewUserConterg.ClassShowPrice;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class FragmentUpdatecolthesfemale extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.updatecolthesfemale, container, false);
        ArrayList<Product> data=new ArrayList<>();
        data.clear();
        FirebaseDatabase db2=FirebaseDatabase.getInstance();
        DatabaseReference ref2=db2.getReference("addcolthes");
        Task<DataSnapshot> task2=ref2.get();
        task2.addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
        if (task.isSuccessful()){
            Iterable<DataSnapshot>data3=task.getResult().getChildren();
            for(DataSnapshot snap:data3) {
                Product p = snap.getValue(Product.class);
                if (p.getProduct().equals("female")){
                    if (p.getProduct().equals("fjacket")){
                        data.add(p);
                    }else if(p.getProduct().equals("fshoe")){
                        data.add(p);
                    }else if(p.getProduct().equals("fdress")){
                        data.add(p);
                    }else if(p.getProduct().equals("fhat")){
                        data.add(p);
                    }}
            }
            RecyclerView rv=view.findViewById(R.id.rec7);
            AdapterUbdate ad=new AdapterUbdate(data);
            rv.setAdapter(ad);
            rv.hasFixedSize();
            RecyclerView.LayoutManager lm=new LinearLayoutManager(container.getContext());
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