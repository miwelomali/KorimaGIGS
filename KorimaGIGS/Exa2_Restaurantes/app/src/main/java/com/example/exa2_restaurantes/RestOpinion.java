package com.example.exa2_restaurantes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class RestOpinion extends AppCompatActivity {

    TextView txtName, txtDesc, txtLoc;
    RatingBar rate;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_opinion);

        txtName = findViewById(R.id.txtOpName);
        txtDesc = findViewById(R.id.txtOpDesc);
        txtLoc = findViewById(R.id.txtOpLoc);
        rate = findViewById(R.id.rateOp);
        img = findViewById(R.id.imgVwOp);

        Intent data = getIntent();

        img.setImageResource(data.getIntExtra("img",0));
        txtName.setText(data.getStringExtra("name"));
        txtDesc.setText(data.getStringExtra("desc"));
        txtLoc.setText(data.getStringExtra("loc"));
        rate.setRating(data.getFloatExtra("rating", (float) 0));
    }

}
