package com.example.finalprojectnew.RecykelViewuser;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojectnew.R;
import com.example.finalprojectnew.user.Categories.activityuserfinal;
import com.example.finalprojectnew.user.Clothes.userfemale;
import com.example.finalprojectnew.user.Clothes.usermale;

import java.util.ArrayList;

public class AdapterCotr extends RecyclerView.Adapter<HolderCotr> {
    ArrayList<ClassCotr>data;
    Context context;

    public AdapterCotr(ArrayList<ClassCotr> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public HolderCotr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.itemde,parent,false);
        return new HolderCotr(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderCotr holder, int position) {
        ClassCotr c=data.get(position);
        holder.imageView.setImageResource(c.getImageview());
        holder.textView.setText(c.getTextview());
        String name= (String) holder.textView.getText();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String male= context.getString(R.string.male);
                String female= context.getString(R.string.female);
                String laptop= context.getString(R.string.laptop);
                String mouse= context.getString(R.string.mouse);
                String keyboard= context.getString(R.string.keyboard);
                String playstation= context.getString(R.string.playstation);
                String fjacket=context.getString(R.string.fjacket);
                String fshoe= context.getString(R.string.fshoe);
                String fdress= context.getString(R.string.fdress);
                String fhat= context.getString(R.string.fhat);
                String jacket=context.getString(R.string.jacket);
                String shoe= context.getString(R.string.shoe);
                String jeans= context.getString(R.string.jeans);
                String hat= context.getString(R.string.hat);
                String clothes= context.getString(R.string.app_name4);
                String devices= context.getString(R.string.app_name5);
             if(holder.textView.getText().equals(clothes)) {
                Intent intent=new Intent(context, com.example.finalprojectnew.user.Categories.clothes.class);
                 intent.putExtra("finaluser",name);
                 context.startActivity(intent);           }

            else if(holder.textView.getText().equals(male)) {
                Intent intent=new Intent(context, usermale.class);
                 intent.putExtra("finaluser",name);
                 context.startActivity(intent);           }
            else if(holder.textView.getText().equals(female)) {
                Intent intent=new Intent(context, userfemale.class);
                 intent.putExtra("finaluser",name);
                 context.startActivity(intent);           }
             else if(holder.textView.getText().equals(jacket)) {
                 Intent intent=new Intent(context, activityuserfinal.class);
                 intent.putExtra("finaluser",name);
                 context.startActivity(intent);           }
             else if(holder.textView.getText().equals(shoe)) {
                 Intent intent=new Intent(context, activityuserfinal.class);
                 intent.putExtra("finaluser",name);
                 context.startActivity(intent);           }
             else if(holder.textView.getText().equals(jeans)) {
                 Intent intent=new Intent(context, activityuserfinal.class);
                 intent.putExtra("finaluser",name);
                 context.startActivity(intent);           }
             else if(holder.textView.getText().equals(hat)) {
                 Intent intent=new Intent(context, activityuserfinal.class);
                 intent.putExtra("finaluser",name);
                 context.startActivity(intent);           }
             else if(holder.textView.getText().equals(fjacket)) {
                 Intent intent=new Intent(context, activityuserfinal.class);
                 intent.putExtra("finaluser",name);
                 context.startActivity(intent);           }
             else if(holder.textView.getText().equals(fshoe)) {
                 Intent intent=new Intent(context, activityuserfinal.class);
                 intent.putExtra("finaluser",name);
                 context.startActivity(intent);           }
             else if(holder.textView.getText().equals(fdress)) {
                 Intent intent=new Intent(context, activityuserfinal.class);
                 intent.putExtra("finaluser",name);
                 context.startActivity(intent);           }
             else if(holder.textView.getText().equals(fhat)) {
                 Intent intent=new Intent(context, activityuserfinal.class);
                 intent.putExtra("finaluser",name);
                 context.startActivity(intent);           }
             else if(holder.textView.getText().equals(laptop)) {
                 Intent intent=new Intent(context, activityuserfinal.class);
                 intent.putExtra("finaluser",name);
                 context.startActivity(intent);           }
             else if(holder.textView.getText().equals(mouse)) {
                 Intent intent=new Intent(context, activityuserfinal.class);
                 intent.putExtra("finaluser",name);
                 context.startActivity(intent);           }
             else if(holder.textView.getText().equals(keyboard)) {
                 Intent intent=new Intent(context, activityuserfinal.class);
                 intent.putExtra("finaluser",name);
                 context.startActivity(intent);           }
             else if(holder.textView.getText().equals(playstation)) {
                 Intent intent=new Intent(context, activityuserfinal.class);
                 intent.putExtra("finaluser",name);
                 context.startActivity(intent);           }
            }

        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
