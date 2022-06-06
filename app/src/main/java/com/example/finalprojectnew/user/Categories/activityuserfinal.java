package com.example.finalprojectnew.user.Categories;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.finalprojectnew.Class.Product;
import com.example.finalprojectnew.R;
import com.example.finalprojectnew.RecykelViewUserConterg.Adapterfinaluser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;

public class activityuserfinal extends AppCompatActivity {
    public ArrayList<Product> data2=new ArrayList<Product>();
    FirebaseDatabase db=FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activityuserfinal);
        Intent intent=getIntent();
        String name=intent.getStringExtra("finaluser");
        String laptop=getString(R.string.laptop);
        String mouse=getString(R.string.mouse);
        String keyboard= getString(R.string.keyboard);
        String playstation= getString(R.string.playstation);
        String fjacket=getString(R.string.fjacket);
        String fshoe= getString(R.string.fshoe);
        String fdress= getString(R.string.fdress);
        String fhat= getString(R.string.fhat);
        String jackets=getString(R.string.jacket);
        String shoes= getString(R.string.shoe);
        String jeans= getString(R.string.jeans);
        String hat= getString(R.string.hat);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DatabaseReference ref=db.getReference("addcolthes");
        Task<DataSnapshot> task=ref.get();
        task.addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()){
                    Iterable<DataSnapshot>data=task.getResult().getChildren();
                    for(DataSnapshot snap:data){
                        Product p=snap.getValue(Product.class);
                        if(name.equals(fjacket)){
                            if (p.getProduct().equals(".jacket")||p.getProduct().equals(".جاكيت")){
                                data2.add(p);}
                            setTitle(fjacket);
                        }
                        if (name.equals(fshoe)){
                            if(p.getProduct().equals(".shoe")||p.getProduct().equals("حذاء.")){
                                data2.add(p);}
                            setTitle(fshoe);
                        }if(name.equals(fdress)) {if(p.getProduct().equals(".dress")||p.getProduct().equals(".فستان")){
                            data2.add(p);}
                            setTitle(fdress);
                        }if(name.equals(fhat)){ if(p.getProduct().equals(".hat")||p.getProduct().equals("طاقية.")){
                            data2.add(p);}
                            setTitle(fhat);
                        }


                        if(name.equals(jackets)){
                            if (p.getProduct().equals("jacket")||p.getProduct().equals("جاكيت")){
                                data2.add(p);}setTitle(jackets);
                        }if(name.equals(jeans)){
                            if(p.getProduct().equals("jeans")||p.getProduct().equals("بنطلون")){
                                data2.add(p);}setTitle(jeans);
                        }if(name.equals(shoes)){
                            if(p.getProduct().equals("shoe")||p.getProduct().equals("حذاء")){
                                data2.add(p);}setTitle(shoes);
                        }if(name.equals(hat)){
                            if(p.getProduct().equals("hat")||p.getProduct().equals("طاقية")){
                                data2.add(p);}setTitle(hat);

                        }
                    } RecyclerView rv=findViewById(R.id.recy1);
                    Adapterfinaluser ad=new Adapterfinaluser(data2);
                    RecyclerView.LayoutManager lm=new LinearLayoutManager(getApplicationContext());

                    rv.setAdapter(ad);
                    rv.setLayoutManager(lm);
                }else{
                    String error=task.getException().getMessage();
                    Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
                }
            }
        });
                  }}