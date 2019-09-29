package com.example.eva1_71_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.function.DoubleToIntFunction;

public class MainActivity extends AppCompatActivity {
Button btnShowMensaje;
TextView txtVwMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShowMensaje = findViewById(R.id.btnShowM);
        txtVwMensaje = findViewById(R.id.txtVwMensaje);
        btnShowMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sDia ="";
                int RandomNumber;
                RandomNumber = (int) Math.round(Math.random()*2);
                System.out.println(RandomNumber + "");
                switch (RandomNumber){
                    case 0:
                        sDia = "Lluvioso";
                        break;

                    case 1:
                        sDia= "Soleado";
                        break;
                    case 2:
                        sDia= "Nublado";
                        break;

                }

                txtVwMensaje.append("El dia es: " + sDia + " ");
            }
        });

    }
}
