package com.example.finalprojectnew.RecykelViewUserConterg;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.finalprojectnew.Class.Product;
import com.example.finalprojectnew.R;
import com.example.finalprojectnew.admin.Colthesa.deletefinal;

import java.util.ArrayList;

public class Adapterdelete extends RecyclerView.Adapter<HolderShowPrice> {
    ArrayList<Product> data;
    Context context;

    public Adapterdelete(ArrayList<Product> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public HolderShowPrice onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemshowprice,parent,false);
        return new HolderShowPrice(view);    }

    @Override
    public void onBindViewHolder(@NonNull HolderShowPrice holder, int position) {
        Product csp=data.get(position);
        holder.name.setText(csp.getName());
        Glide.with(holder.itemView).load(csp.getImage()).into(holder.image);
        holder.price.setText(csp.getPrice());
        holder.pro.setText(csp.getProduct());
        holder.female.setText(csp.getSex());
        holder.itemw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (csp.getName().equals("female!")||csp.getName().equals("male!")){
                    Intent intent=new Intent(context, deletefinal.class);
                    intent.putExtra("product", (Parcelable) csp);
                    context.startActivity(intent);
                } }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
