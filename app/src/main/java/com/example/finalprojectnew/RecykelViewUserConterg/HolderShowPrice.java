package com.example.finalprojectnew.RecykelViewUserConterg;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojectnew.R;


public class HolderShowPrice extends RecyclerView.ViewHolder {
    TextView name;
    TextView price;
    TextView pro;
    TextView female;
    ImageView image;
    View view;
    View item;
    View itemw;

    public HolderShowPrice(@NonNull View itemView) {
        super(itemView);
        view =itemView;
        item =itemView;
        itemw =itemView;
        name=itemView.findViewById(R.id.nameuser);
        image=itemView.findViewById(R.id.imageuser);
        price=itemView.findViewById(R.id.priceuser);
        pro=itemView.findViewById(R.id.prouser);
        female=itemView.findViewById(R.id.femal);
    }
}
