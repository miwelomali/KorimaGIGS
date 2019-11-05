package com.example.eva2_8_activity_result_lista;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    TextView txtVwCiudad, txtVwClima, txtVwTemper;        //Variables para CLIMA
    TextView txtVwNombre, txtVwComida,  txtVwLocation, txtVwRating;        //Variables para RESTAURANTE
    ImageView ImagenClima, ImagenRestaurante;
    double dRating,dTemper;
;
    int iImagenClima,iImagenRestaurante;
    final int SECUNDARIA = 16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mibutton = findViewById(R.id.button);
        txtVwCiudad = findViewById(R.id.txtVwCiudad);
        txtVwClima = findViewById(R.id.txtVwClima);
        txtVwTemper = findViewById(R.id.txtVwTemper);
        ImagenClima = findViewById(R.id.imageView2);

        txtVwNombre = findViewById(R.id.txtVwNombre);
        txtVwComida = findViewById(R.id.txtVwComida);
        txtVwLocation = findViewById(R.id.txtVwLocacion);
        txtVwRating = findViewById(R.id.txtVwRating);
        ImagenRestaurante = findViewById(R.id.imageView);

    }

    public void onClick(View view) {


        if (view.getId() == R.id.button) {
            intent = new Intent(this, activity_Clima.class);

        } else if (view.getId() == R.id.button2) {

            intent = new Intent(this, Activity_Restaurantes.class);

        }

        startActivityForResult(intent, SECUNDARIA);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case SECUNDARIA:
                if (resultCode == Activity.RESULT_OK) {
                    //Aqui recibimos datos
                    txtVwCiudad.setText(data.getStringExtra("CIUDADES"));
                    dTemper = data.getDoubleExtra("TEMPERATURA",30);
                    txtVwTemper.setText(dTemper + "");
                    txtVwClima.setText(data.getStringExtra("CLIMA"));
                    iImagenClima = data.getIntExtra("IMAGEN",30);
                    ImagenClima.setImageResource(iImagenClima);




                } else {
                    txtVwNombre.setText(data.getStringExtra("RESTAURANTES"));
                    txtVwComida.setText(data.getStringExtra("DESCRIPCION"));
                    txtVwLocation.setText(data.getStringExtra("LOCACION"));
                    iImagenRestaurante = data.getIntExtra("IMAGEN",30);
                    ImagenRestaurante.setImageResource(iImagenRestaurante);
                    dRating = data.getDoubleExtra("RATING",30);
                    txtVwRating.setText(dRating + "");
                }
                break;

            default:

        }
    }
}
