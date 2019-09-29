package com.example.eva1_11_listarestaurantes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener{
    ListView listaRestaurante;
    Restaurante[] cRestauntes = {

            new Restaurante(),
            new Restaurante(R.drawable.f1, "Live on London", "Restaurante Ingles", "Colonia Centro", 4.0),
            new Restaurante(R.drawable.f3,"El Escuadron","Restaurante Mexicano","Colonia aeropuerto", 5.0),
            new Restaurante(R.drawable.f2, "KimChica", "Restaurante Japones", "Colonia San Felipe", 4.5)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaRestaurante = findViewById(R.id.listRestaurante);
        listaRestaurante.setAdapter(new RestauranteAdapter(this,R.layout.restaurante_layout,cRestauntes));
        listaRestaurante.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Toast.makeText(this, cRestauntes [position].getNombre(), Toast.LENGTH_SHORT).show();
    }
}
