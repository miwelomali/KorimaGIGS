package com.example.eva2_7_activity_result;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final int SECUNDARIA = 16;
    Intent intento;
    TextView txtVwDatos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwDatos = findViewById(R.id.txtVwDatos);

        intento = new Intent (this,actividad2.class);
    }
    public void clickEnviar(View v){
        startActivityForResult(intento, SECUNDARIA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case SECUNDARIA:
                if (resultCode == Activity.RESULT_OK){
                    //Aqui recibimos datos
                    txtVwDatos.setText(data.getStringExtra("MENSAJE"));
                }
                else {
                    Toast.makeText(this, "Actividad CANCELADA", Toast.LENGTH_SHORT).show();
                }
                break;

            default:

        }
    }

}
