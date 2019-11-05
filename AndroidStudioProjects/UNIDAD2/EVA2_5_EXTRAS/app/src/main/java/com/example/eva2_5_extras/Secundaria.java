package com.example.eva2_5_extras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Secundaria extends AppCompatActivity {

    TextView txtMensaje;
    TextView txtNumero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        Intent intent;
        intent = getIntent();
        txtMensaje = findViewById(R.id.textView);
        txtNumero = findViewById(R.id.textView2);
        txtMensaje.setText("datos: " + intent.getStringExtra("datos").toString());
       // txtNumero.setText(intent.getIntExtra("numeros", 2));

    }
    public void onCerrar(View v){
        finish();
    }
}
