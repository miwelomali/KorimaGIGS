package com.example.korimagigs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class activity_login extends AppCompatActivity {
TextView txtVwRegister;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtVwRegister = findViewById(R.id.textView5);
        intent = new Intent(this, activity_register.class);

    }
    public void onRegister(View v){
        startActivity(intent);
        finish();

    }


}
