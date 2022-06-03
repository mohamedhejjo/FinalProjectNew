package com.example.finalprojectnew.admin.Colthesa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalprojectnew.Class.Admin;
import com.example.finalprojectnew.Class.Product;
import com.example.finalprojectnew.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.UUID;

public class addcolthes extends AppCompatActivity {
    Spinner spinner1;
    Spinner spinner2;
    TextView name,price;
    Button add;
    String selected1;
    String selected2;
    Uri imageuri;
public  static  final  int PICK_IMAGE=1021;
    private ImageView addimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcolthes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        addimage=findViewById(R.id.addimage);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        name=findViewById(R.id.acol1);
        price=findViewById(R.id.acol2);
        add=findViewById(R.id.addcreate);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1=name.getText().toString();
                String price1=price.getText().toString();
                if (name1.isEmpty()){
                    name.setError("name not be empty");}
                else if(price1.isEmpty()){
                    price.setError("price not be empty");}
                else if(imageuri !=null){
                    FirebaseStorage storage=FirebaseStorage.getInstance();
                    StorageReference ref=storage.getReference("images/"+ UUID.randomUUID().toString());
                    ref.putFile(imageuri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                           if (task.isSuccessful()){
                               ref.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                   @Override
                                   public void onComplete(@NonNull Task<Uri> task) {
                                    if (task.isSuccessful())  {
                                        String image=task.getResult().toString();
                                        FirebaseDatabase db= FirebaseDatabase.getInstance();
                                        DatabaseReference dr=db.getReference("addcolthes");
                                        String id=dr.push().getKey();
                                        Product product=new Product(id,name1,price1,selected1,image,selected2);
                                        dr.child(id).setValue(product).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()){
                                                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();

                                                }else{
                                                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                                                }
                                                name.setText("");
                                                price.setText("");
                                            }
                                        });
                                    }
                                   }
                               });
                           }else{
                               Toast.makeText(getApplicationContext(), "Uplooad image failed", Toast.LENGTH_SHORT).show();
                           }
                        }
                    });
                }
                else{
                    FirebaseDatabase db= FirebaseDatabase.getInstance();
                    DatabaseReference dr=db.getReference("addcolthes");
                    String id=dr.push().getKey();
                    Product product=new Product(id,name1,price1,selected1,"image",selected2);
                    dr.child(id).setValue(product).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();

                            }else{
                                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                            }
                            name.setText("");
                            price.setText("");

                }
            });

                }}});

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> prent, View view, int i, long l) {
                selected1 = prent.getItemAtPosition(i).toString();
                String male=getString(R.string.male);
                String female=getString(R.string.female);
                if (selected1.equals(male)) {
                    ArrayList<String> male1 = new ArrayList<>();
                    String jacket=getString(R.string.jacket);
                    String shoe= getString(R.string.shoe);
                    String jeans= getString(R.string.jeans);
                    String hat= getString(R.string.hat);
                    male1.add(jacket);
                    male1.add(shoe);
                    male1.add(jeans);
                    male1.add(hat);
                    ArrayAdapter<String> adaptermale = new ArrayAdapter<String>(prent.getContext(), android.R.layout.simple_spinner_dropdown_item, male1);
                    spinner2.setAdapter(adaptermale);
                } else if (selected1.equals(female)) {
                    ArrayList<String> female1 = new ArrayList<>();
                    String fjacket=getString(R.string.fjacket);
                    String fshoe= getString(R.string.fshoe);
                    String fdress= getString(R.string.fdress);
                    String fhat= getString(R.string.fhat);
                    female1.add(fjacket);
                    female1.add(fshoe);
                    female1.add(fdress);
                    female1.add(fhat);
                    ArrayAdapter<String> adapterfemale = new ArrayAdapter<String>(prent.getContext(), android.R.layout.simple_spinner_dropdown_item, female1);
                    spinner2.setAdapter(adapterfemale);


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selected2 = adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void Mohamed(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent,PICK_IMAGE);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_IMAGE && resultCode==RESULT_OK && data !=null){
             imageuri =data.getData();
            addimage.setImageURI(imageuri);

        }}


}