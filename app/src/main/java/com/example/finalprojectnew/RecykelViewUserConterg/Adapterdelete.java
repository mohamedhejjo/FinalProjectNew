package com.example.finalprojectnew.RecykelViewUserConterg;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.finalprojectnew.R;
import com.example.finalprojectnew.admin.Colthesa.deletefinal;

import java.util.ArrayList;

public class Adapterdelete extends RecyclerView.Adapter<HolderShowPrice> {
    ArrayList<ClassShowPrice> data;
    Context context;

    public Adapterdelete(ArrayList<ClassShowPrice> data) {
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
        ClassShowPrice csp=data.get(position);
        holder.name.setText(csp.getName());
        holder.image.setImageResource(csp.getImage());
        holder.price.setText(csp.getPrice());
        holder.pro.setText(csp.getPro());
        holder.female.setText(csp.getFemal());
        holder.itemw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (csp.getName().equals("female!")||csp.getName().equals("male!")){
                    Intent intent=new Intent(context, deletefinal.class);
                    intent.putExtra("ClassShowPrice",csp);
                    context.startActivity(intent);
                } }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
