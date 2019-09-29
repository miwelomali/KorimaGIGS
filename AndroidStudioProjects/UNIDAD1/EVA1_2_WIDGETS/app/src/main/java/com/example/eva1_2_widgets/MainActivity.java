package com.example.eva1_2_widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView  txtVwMensa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwMensa = findViewById(R.id.textVwMensaje);
        txtVwMensa.setText("Hola Gamer, Juguemos League of Legends");
        txtVwMensa.setText(R.string.mi_cadena);
    }
}
