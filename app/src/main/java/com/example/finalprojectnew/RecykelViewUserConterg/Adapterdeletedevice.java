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
import com.example.finalprojectnew.Class.Productdevice;
import com.example.finalprojectnew.R;
import com.example.finalprojectnew.admin.Colthesa.deletefinal;

import java.util.ArrayList;

public class Adapterdeletedevice extends RecyclerView.Adapter<Holderdelete> {
    ArrayList<Productdevice> data;
    Context context;

    public Adapterdeletedevice(ArrayList<Productdevice> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public Holderdelete onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemshowprice,parent,false);
        return new Holderdelete(view);    }

    @Override
    public void onBindViewHolder(@NonNull Holderdelete holder, int position) {
        Productdevice csp=data.get(position);
        holder.name.setText(csp.getName());
        Glide.with(holder.itemView).load(csp.getImage()).into(holder.image);
        holder.price.setText(csp.getPrice());
        holder.pro.setText(csp.getProduct());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String laptop= context.getString(R.string.laptop);
                String PlayStation= context.getString(R.string.playstation);
                String mouse= context.getString(R.string.mouse);
                String keyboard= context.getString(R.string.keyboard);
                if (csp.getProduct().equals(laptop)||csp.getProduct().equals(mouse)||
                        csp.getProduct().equals(keyboard)||csp.getProduct().equals(PlayStation)
                ){
                    Intent intent=new Intent(context, deletefinal.class);
                    intent.putExtra("productdelete",  csp);
                    context.startActivity(intent);
                } }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }}