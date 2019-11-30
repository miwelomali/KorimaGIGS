package com.example.eva3_14_servicio_player;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent inRola;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inRola = new Intent(this, miServicio.class);


    }

    public void iniciarRola(View v) {
            startService(inRola);
    }

    public void pararRola(View v) {
            stopService(inRola);
    }

}


