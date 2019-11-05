package com.example.eva2_6_bundles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;

public class Secundaria extends AppCompatActivity {
    TextView txtVwtexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        txtVwtexto = findViewById(R.id.txtVwDatos);
        Intent intentSec = getIntent();
        Bundle bundle = intentSec.getExtras();
        txtVwtexto.append(bundle.getString("nombre") +"\n");
        txtVwtexto.append(bundle.getString("apellido") + "\n");
        txtVwtexto.append(bundle.getInt("edad") + "\n");
        switch(bundle.getInt("sexo")){

            case 0:
                txtVwtexto.append("Masculino");
            break;

            case 1:
                txtVwtexto.append("Femenino");
                break;

            case 2:
                txtVwtexto.append("Otros");
                break;

            case 3:
                txtVwtexto.append("Estudiante ISC");
                break;
        }


    }
}
