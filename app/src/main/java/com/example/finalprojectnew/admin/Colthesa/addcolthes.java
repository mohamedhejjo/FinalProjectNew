package com.example.finalprojectnew.admin.Colthesa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalprojectnew.Class.Product;
import com.example.finalprojectnew.MainActivity;
import com.example.finalprojectnew.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

public class addcolthes extends AppCompatActivity {
    Spinner spinner1;
    Spinner spinner2;
    TextView name, price;
    Button add;
    String selected1;
    String selected2;
    Uri selectedimage;
    public static final int PICK_IMAGE = 1021;
    private ImageView addimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcolthes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        addimage = findViewById(R.id.addimage);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        name = findViewById(R.id.acol1);
        price = findViewById(R.id.acol2);
        add = findViewById(R.id.addcreate);
        add.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {


                //create pending intent to open activity outside notification app
                //it will allow users to go directly from the notification to an activity of  app
                Intent notificationIntent = new Intent(getApplicationContext(), addcolthes.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, notificationIntent, 0);

                //Build the Notification
                NotificationManager nm = getSystemService(NotificationManager.class);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel nc = new NotificationChannel("my_id", "added product", NotificationManager.IMPORTANCE_HIGH);
                    nm.createNotificationChannel(nc);
                }
                NotificationCompat.Builder builder = new NotificationCompat.Builder(addcolthes.this, "my_id");

                String name1 = name.getText().toString();
                String price1 = price.getText().toString();
                if (name1.isEmpty()) {
                    name.setError("name not be empty");
                } else if (price1.isEmpty()) {
                    price.setError("price not be empty");
                } else {
                    builder.setContentTitle("Product added:\n"+name.getText().toString());
                    builder.setContentText("price:"+price.getText().toString());
                    builder.setSmallIcon(R.drawable.ic_baseline_send_24);

                    Intent i = new Intent(addcolthes.this, MainActivity.class);
                    PendingIntent pi = PendingIntent.getActivity(addcolthes.this,1021,i,PendingIntent.FLAG_UPDATE_CURRENT);
                    builder.setContentIntent(pi);
                    builder.setColor(Color.BLUE);
                    builder.setColorized(true);
                    nm.notify(new Random().nextInt(), builder.build());
                }

                String name2 = name.getText().toString();
                String price2 = price.getText().toString();
                if (name1.isEmpty()) {
                    name.setError("name not be empty");
                } else if (price1.isEmpty()) {
                    price.setError("price not be empty");
                } else {
                    if (selectedimage != null) {
                        FirebaseStorage fs = FirebaseStorage.getInstance();
                        StorageReference storageReference = fs.getReference("images/" + UUID.randomUUID().toString());
                        storageReference.putFile(selectedimage).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                                if (task.isSuccessful()) {
                                    storageReference.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Uri> task) {
                                            if (task.isSuccessful()) {
                                                String imageurl = task.getResult().toString();

                                                FirebaseDatabase db = FirebaseDatabase.getInstance();
                                                DatabaseReference dr = db.getReference("addcolthes");
                                                String id = dr.push().getKey();
                                                Product product = new Product(id, name1, price1, selected1, imageurl, selected2);
                                                dr.child(id).setValue(product).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if (task.isSuccessful()) {
                                                            Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();

                                                        } else {
                                                            Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                                                        }
                                                        name.setText("");
                                                        price.setText("");
                                                        addimage.setImageResource(R.drawable.ic_launcher_background);
                                                        selected1.isEmpty();
                                                        selected2.isEmpty();

                                                    }
                                                });
                                            }
                                        }
                                    });
                                } else {

                                }
                            }
                        });


                    } else {
                        FirebaseDatabase db = FirebaseDatabase.getInstance();
                        DatabaseReference dr = db.getReference("addcolthes");
                        String id = dr.push().getKey();
                        Product product = new Product(id, name1, price1, selected1, "image", selected2);
                        dr.child(id).setValue(product).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                                }
                                name.setText("");
                                price.setText("");

                            }
                        });
                    }
                }

            }


        });


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> prent, View view, int i, long l) {
                selected1 = prent.getItemAtPosition(i).toString();
                String male = getString(R.string.male);
                String female = getString(R.string.female);
                if (selected1.equals("male") || selected1.equals("ذكر")) {
                    ArrayList<String> male1 = new ArrayList<>();
                    String jacket = getString(R.string.jacket);
                    String shoe = getString(R.string.shoe);
                    String jeans = getString(R.string.jeans);
                    String hat = getString(R.string.hat);
                    male1.add(jacket);
                    male1.add(shoe);
                    male1.add(jeans);
                    male1.add(hat);
                    ArrayAdapter<String> adaptermale = new ArrayAdapter<String>(prent.getContext(), android.R.layout.simple_spinner_dropdown_item, male1);
                    spinner2.setAdapter(adaptermale);
                } else if (selected1.equals("female") || selected1.equals("أنثى")) {
                    ArrayList<String> female1 = new ArrayList<>();
                    String fjacket = getString(R.string.fjacket);
                    String fshoe = getString(R.string.fshoe);
                    String fdress = getString(R.string.fdress);
                    String fhat = getString(R.string.fhat);
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
        startActivityForResult(intent, PICK_IMAGE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            selectedimage = data.getData();
            addimage.setImageURI(selectedimage);


        }
    }


}