package com.example.eva2_7_activity_result;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class actividad2 extends AppCompatActivity {
    Button btnEnviarDatos;
    Button btnEnviarDatos2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);
        btnEnviarDatos = findViewById(R.id.button2);
        btnEnviarDatos2 = findViewById(R.id.button3);

    }
    public void clickEnviar(View v){
        if (v.getId() == R.id.button3){
            setResult(Activity.RESULT_CANCELED);
            finish();
        }
        else{
        Intent indDatos = new Intent();
        indDatos.putExtra("MENSAJE", "Hola mundo Cruel");
        setResult(Activity.RESULT_OK,indDatos);
        finish();

    }
}}
