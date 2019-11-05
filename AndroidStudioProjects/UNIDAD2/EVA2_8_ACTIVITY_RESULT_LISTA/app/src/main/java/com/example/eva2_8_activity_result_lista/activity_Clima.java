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

public class activity_Clima extends AppCompatActivity implements AdapterView.OnItemClickListener {


    ListView Lista;
    TextView Texto;

    String [] asCiudades = {
            "Bonn",
            "Villa Ahumada",
            "Tokio",
            "Chihuahua",
            "Delicias"

    };

    double [] asTemperatura = {
            20,
            30,
            30,
            20,
            25

    };

    String [] asClima = {
            "Nevado",
            "Ciclon",
            "Tranqui",
            "Chill",
            "Infernal"

    };

    int [] asImagen = {
            R.drawable.snow,
            R.drawable.tornado,
            R.drawable.light_rain,
            R.drawable.cloudy,
            R.drawable.thunderstorm

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__clima);
        Texto = findViewById(R.id.txtVwTexto);
        Lista = findViewById(R.id.lisVwLista);
        Lista.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, asCiudades));

        Lista.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        //Toast.makeText(this, asResta[position], Toast.LENGTH_SHORT).show();

        Texto.setText(asCiudades[position] + " " + asTemperatura[position] + " " + asClima[position]);
        Intent indDatos = new Intent();
        indDatos.putExtra("CIUDADES", asCiudades[position]);
        indDatos.putExtra("TEMPERATURA", asTemperatura[position]);
        indDatos.putExtra("CLIMA", asClima[position]);
        indDatos.putExtra("IMAGEN", asImagen[position]);


        setResult(Activity.RESULT_OK,indDatos);
        finish();
    }
}
