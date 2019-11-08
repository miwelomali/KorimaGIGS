package com.example.korimagigs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.korimagigs.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class activity_Artist extends AppCompatActivity {

    TextView txtArtist, txtGenre, txtLinks;
    ImageView imgArtist;
    FirebaseUser firebaseUser;
    DatabaseReference reference;

    Intent inImg;
    private static final int SELECT_PICTURE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        txtArtist = findViewById(R.id.txtVwArtist);
        txtGenre = findViewById(R.id.txtVwGenre);
        txtLinks = findViewById(R.id.txtVwLinks);
        imgArtist = findViewById(R.id.imgVwArtist);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                txtArtist.setText(user.getUsername());

                if (user.getImageURL().equals("default")) {
                    imgArtist.setImageResource(R.drawable.def_user);
                } else {
                    Glide.with(getApplicationContext()).load(user.getImageURL()).into(imgArtist);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        imgArtist.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                inImg = new Intent();
                inImg.setType("image/*");
                inImg.setAction(Intent.ACTION_GET_CONTENT);
                //We pass an extra array with the accepted mime types. This will ensure only components with these MIME types as targeted.
                // Launching the Intent
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

                    imgArtist.setImageURI(selectedImageUri);

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

}
