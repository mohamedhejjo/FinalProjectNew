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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
import java.util.UUID;

public class adddevices extends AppCompatActivity {

    private ImageView adddevices;
    static byte[] imageContentdevices;
    TextView name, price;
    Spinner spinner;
    String selected;
    Button add;
    Uri imageuri;
    public  static  final  int PICK_IMAGE=1021;
    private ImageView addimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adddevices);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        adddevices = findViewById(R.id.addimage);
        name = findViewById(R.id.adv1);
        price = findViewById(R.id.adv2);
        add = findViewById(R.id.addcreatedivaec);
        spinner = findViewById(R.id.spinner3);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1 = name.getText().toString();
                String price1 = price.getText().toString();
                if (name1.isEmpty()) {
                    name.setError("name not be empty");
                } else if (price1.isEmpty()) {
                    price.setError("price not be empty");
                }  else if(imageuri !=null){
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
                                            DatabaseReference dr=db.getReference("adddevice");
                                            String id=dr.push().getKey();
                                            Product product=new Product(id,name1,price1,image,selected);
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
                    DatabaseReference dr=db.getReference("adddevice");
                    String id=dr.push().getKey();
                    Product product=new Product(id,name1,price1,"image",selected);
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

                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selected = adapterView.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

                }}});}

    public void Mohamed(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, 100);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICK_IMAGE && resultCode==RESULT_OK && data !=null){
            imageuri =data.getData();
            addimage.setImageURI(imageuri);

        }}}