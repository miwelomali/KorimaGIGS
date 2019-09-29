package com.example.eva1_4_eventos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener{
    Button btnPorClaseAnonima;
    Button btnPorInt;
    Button btnCE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCE = findViewById(R.id.btnClaseExterna);
        btnPorInt = findViewById(R.id.btnInterfaz);
        btnPorClaseAnonima = findViewById(R.id.btnCA);
        btnPorInt.setOnClickListener(this);
        btnPorClaseAnonima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Click en clase anonima", Toast.LENGTH_SHORT).show();
            }
        });
        MiEventoClick meClick = new MiEventoClick();
        meClick.setContext(this);
        btnCE.setOnClickListener(meClick);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this,"Click en listener", Toast.LENGTH_SHORT).show();
    }

    public void miClick(View v){
        Toast.makeText( this, "Hola dino", Toast.LENGTH_LONG).show();
    }



}
