package com.example.korimagigs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
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

public class activity_User extends AppCompatActivity implements ListView.OnItemClickListener {

    ListView lsUser;

    TextView txtUser;
    ImageView imgUser;
    FirebaseUser firebaseUser;
    DatabaseReference reference;

    Intent inImg;
    private static final int SELECT_PICTURE = 100;

    String[] user = {
            "Locales",
            "Artistas",
            "Preferencias",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        lsUser = findViewById(R.id.lsUser);
        txtUser = findViewById(R.id.txtUser);
        imgUser = findViewById(R.id.imgVwUser);

        lsUser.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,user));
        lsUser.setOnItemClickListener(this);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                txtUser.setText(user.getUsername());

                if (user.getImageURL().equals("default")) {
                    imgUser.setImageResource(R.drawable.def_user);
                } else {
                    Glide.with(getApplicationContext()).load(user.getImageURL()).into(imgUser);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        imgUser.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                inImg = new Intent();

                // tipo de archivo a seleccionar
                inImg.setType("image/*");
                inImg.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(inImg,"Select pic"), SELECT_PICTURE);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                // obtener la uri de los datos
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // localización del uri
                    String path = getPathFromURI(selectedImageUri);

                    //Log.i(TAG, "Image Path : " + path);

                    imgUser.setImageURI(selectedImageUri);

                    // Aqui se manda a BD

                }
            }
        }
    }

    /* obtener la ubicaión real del uri */
    public String getPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
        }
        cursor.close();
        return res;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
        Toast.makeText(this, user[pos], Toast.LENGTH_SHORT).show();
    }
}
