package com.example.finalprojectnew.RecykelViewUserConterg;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.finalprojectnew.R;
import com.example.finalprojectnew.user.Categories.Price;

import java.util.ArrayList;

public class Adapterfinaluser  extends RecyclerView.Adapter<HolderShowPrice> {
    ArrayList<ClassShowPrice> data;
    Context context;

    public Adapterfinaluser(ArrayList<ClassShowPrice> data) {
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
        ClassShowPrice finalu=data.get(position);
        holder.name.setText(finalu.getName());
        holder.image.setImageResource(finalu.getImage());
        holder.price.setText(finalu.getPrice());
        holder.pro.setText(finalu.getPro());
        holder.female.setText(finalu.getFemal());
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
