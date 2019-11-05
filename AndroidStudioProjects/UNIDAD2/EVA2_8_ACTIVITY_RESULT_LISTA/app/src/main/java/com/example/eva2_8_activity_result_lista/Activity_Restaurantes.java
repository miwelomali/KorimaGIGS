package com.example.eva2_8_activity_result_lista;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Activity_Restaurantes extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView Lista;
    TextView Texto;

    String [] asRestaurantes = {
            "Live on London",
            "El Escuadron",
            "KimChica"

    };

    String [] asDescripcion = {
            "Restaurante Ingles",
            "Restaurante Mexicano",
            "Restaurante Japones"

    };

    String [] asLocacion = {
            "Colonia Centro",
            "Colonia Aeropuerto",
            "Colonia San Felipe"

    };
    int [] asImagen = {
            R.drawable.f1,
            R.drawable.f3,
            R.drawable.f2

    };

    double [] asRating = {
            4.0,
            5.0,
            4.5

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__restaurantes);
        Texto = findViewById(R.id.txtVwTexto);
        Lista = findViewById(R.id.lisVwLista);
        Lista.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, asRestaurantes));

        Lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Texto.setText(asRestaurantes[position]);
        Intent indDatos = new Intent();
        indDatos.putExtra("RESTAURANTES", asRestaurantes[position]);
        indDatos.putExtra("DESCRIPCION", asDescripcion[position]);
        indDatos.putExtra("LOCACION", asLocacion[position]);
        indDatos.putExtra("RATING", asRating[position]);
        indDatos.putExtra("IMAGEN", asImagen[position]);


        setResult(Activity.RESULT_CANCELED,indDatos);
        finish();
    }
}
