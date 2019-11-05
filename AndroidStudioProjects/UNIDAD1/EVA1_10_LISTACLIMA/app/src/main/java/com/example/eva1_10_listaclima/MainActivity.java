package com.example.eva1_10_listaclima;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener{
    ListView lstClima;
 Clima[] cCiudades = {
         new Clima(),
         new Clima(R.drawable.snow,"Bonn",20,"Nevado"),
         new Clima(R.drawable.tornado,"Villa Ahumada",30,"Ciclon"),
         new Clima(R.drawable.light_rain,"Tokyo",30,"Tranqui"),
         new Clima(R.drawable.cloudy,"Chihuahua",20,"Chill"),
         new Clima(R.drawable.thunderstorm,"Delicias",25,"Infernal")

 };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstClima = findViewById(R.id.listLista);
        lstClima.setAdapter(new ClimaAdapter(this, R.layout.layoutclima, cCiudades));

        lstClima.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        Intent inDatos = new Intent();
        inDatos.putExtra("ciudad", cCiudades[position].getCiudad());
        inDatos.putExtra("temperatura", cCiudades[position].getTemperatura());
        inDatos.putExtra("clima", cCiudades[position].getClima());
        inDatos.putExtra("imagenClima", cCiudades[position].getImagen());



        setResult(Activity.RESULT_OK,inDatos);
        Toast.makeText(this, cCiudades[position].getCiudad(), Toast.LENGTH_SHORT).show();
        finish();

    }

}
