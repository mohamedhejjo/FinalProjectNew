package com.example.finalprojectnew.RecykelViewUserConterg;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.finalprojectnew.Class.Product;
import com.example.finalprojectnew.R;
import com.example.finalprojectnew.user.Categories.Price;

import java.util.ArrayList;

public class Adapterfinaluser  extends RecyclerView.Adapter<HolderShowPrice> {
    ArrayList<Product> data;
    Context context;

    public Adapterfinaluser(ArrayList<Product> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public HolderShowPrice onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemshowprice,parent,false);
        return new HolderShowPrice(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderShowPrice holder, int position) {
        Product finalu=data.get(position);
        holder.name.setText(finalu.getName());
        holder.price.setText(finalu.getPrice());
        holder.pro.setText(finalu.getProduct());
        holder.female.setText(finalu.getSex());
        Glide.with(holder.itemView).load(finalu.getImage()).into(holder.image);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, Price.class);
                intent.putExtra("finalu",finalu);
                context.startActivity(intent);
                }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
