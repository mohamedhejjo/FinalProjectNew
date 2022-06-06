package com.example.finalprojectnew.Recyviewsales;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojectnew.R;

public class holdersales extends RecyclerView.ViewHolder {
    View view;
    TextView name;
    TextView price;
    ImageView imageView;

    public holdersales(@NonNull View itemView) {
        super(itemView);
        view=itemView;
        name=itemView.findViewById(R.id.textviewe);
        price=itemView.findViewById(R.id.textView2);
        imageView=itemView.findViewById(R.id.imageView2);
    }}
