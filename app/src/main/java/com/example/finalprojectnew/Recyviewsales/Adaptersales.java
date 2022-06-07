package com.example.finalprojectnew.Recyviewsales;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.finalprojectnew.Class.PriceClas;
import com.example.finalprojectnew.R;
import com.example.finalprojectnew.admin.Categories.Salesfinal;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class Adaptersales extends RecyclerView.Adapter<holdersales> {
    ArrayList<PriceClas> data;
    Context context;

    public Adaptersales(ArrayList<PriceClas> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public holdersales onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.salesitem,parent,false);
        return new holdersales(view);    }

    @Override
    public void onBindViewHolder(@NonNull holdersales holder, int position) {
        PriceClas csp=data.get(position);
        FirebaseStorage fs=FirebaseStorage.getInstance();
        StorageReference sr=fs.getReference().child(csp.getImage());
        int Mohamed=1024*1024;
        sr.getBytes(Mohamed).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                holder.imageView.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });

        holder.price.setText(csp.getPrice());
        holder.name.setText(csp.getName());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, Salesfinal.class);
                intent.putExtra("price",csp);
                context.startActivity(intent);
            }   });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
