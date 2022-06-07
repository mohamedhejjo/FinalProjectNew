package com.example.finalprojectnew.Recyviewsales;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.finalprojectnew.Class.PriceClas;
import com.example.finalprojectnew.R;

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
        if (!csp.getImage().isEmpty()) {
            Glide.with(holder.itemView).load(csp.getImage()).into(holder.imageView);
        }        holder.price.setText(csp.getPrice());
        holder.name.setText(csp.getName());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }   });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
