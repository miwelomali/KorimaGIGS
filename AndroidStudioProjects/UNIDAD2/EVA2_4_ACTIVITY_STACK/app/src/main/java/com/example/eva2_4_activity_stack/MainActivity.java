package com.example.eva2_4_activity_stack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent intLanzar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         intLanzar = new Intent(this,Secundaria.class);

    }

    public void onLanzar(View v){
        startActivity(intLanzar);
    }
}
