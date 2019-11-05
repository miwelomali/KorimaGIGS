package com.example.exa2_restaurantes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent inShow, inCapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inShow = new Intent(this, Show.class);
        inCapt = new Intent(this, Capture.class);
    }

    public void clickShow(View v){
        startActivity(inShow);
    }

    public void clickCapt(View v) {
        startActivity(inCapt);
    }

    public void clickExit(View v) {
        System.exit(0);
    }
}
