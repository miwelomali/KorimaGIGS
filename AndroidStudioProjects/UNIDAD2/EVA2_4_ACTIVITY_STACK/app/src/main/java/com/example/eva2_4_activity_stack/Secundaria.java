package com.example.eva2_4_activity_stack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Secundaria extends AppCompatActivity {
Intent inBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        //inBack = new Intent(this, MainActivity.class);
    }

    public void onRegresar(View v){
        //No hacer esto ya que en vez de cerrar la actividad creara actividades de namera infinita.
        //startActivity(inBack);
        finish();
    }
}
