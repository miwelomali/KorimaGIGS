package com.example.korimagigs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.korimagigs.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TextView txtVwUsername;
    TextView txtVwTypeUser;
    ImageView imgVwImagen;
    FirebaseUser firebaseUser;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtVwUsername = findViewById(R.id.txtVwUser);
        txtVwTypeUser = findViewById(R.id.txtVwTypeUser);
        imgVwImagen = findViewById(R.id.imageView);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                txtVwUsername.setText(user.getUsername());
                txtVwTypeUser.setText(user.getType());

                if (user.getImageURL().equals("default")) {
                    imgVwImagen.setImageResource(R.mipmap.ic_launcher);
                } else {
                    Glide.with(getApplicationContext()).load(user.getImageURL()).into(imgVwImagen);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), StartActivity.class));
                finish();
                return true;
        }
        return false;
    }

    public void onClick(View v) {
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                if (user.getType().equals("User")) {
                    Toast.makeText(MainActivity.this, "It's a User", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), activity_User.class));
                    finish();

                } else if (user.getType().equals("Artist")) {
                    Toast.makeText(MainActivity.this, "It's an Artist", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), activity_Artist.class));
                    finish();



                } else if (user.getType().equals("Unknown")) {
                    Toast.makeText(MainActivity.this, "It's a Unknown", Toast.LENGTH_SHORT).show();

                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Standar Dialog").setMessage("Select an User")
                            .setPositiveButton("User", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //ACCION
                                    startActivity(new Intent(getApplicationContext(), activity_User.class));
                                    finish();
                                }
                            })
                            .setNegativeButton("Artist", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //ACCION
                                    startActivity(new Intent(getApplicationContext(), activity_Artist.class));
                                    finish();
                                }
                            })
                            .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //ACCION
                                    Toast.makeText(getApplicationContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                                }
                            }).create().show();

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
