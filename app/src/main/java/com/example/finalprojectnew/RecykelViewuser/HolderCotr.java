package com.example.finalprojectnew.RecykelViewuser;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalprojectnew.R;


public class HolderCotr extends RecyclerView.ViewHolder {
    View view;
    TextView textView;
    ImageView imageView;

    public HolderCotr(@NonNull View itemView) {
        super(itemView);
        view=itemView;
        textView=itemView.findViewById(R.id.textviewe);
        imageView=itemView.findViewById(R.id.imagebutton);
    }
}
