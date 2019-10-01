package com.example.eva1_examen_acredita;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar skBarPuntos, skBarCalif;
    TextView txtVwPuntos, txtVwCalif, txtVwAcredita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        skBarPuntos = findViewById(R.id.skBarPuntos);
        skBarCalif = findViewById(R.id.skBarCalif);
        txtVwAcredita = findViewById(R.id.txtVwAcredita);
        txtVwCalif = findViewById(R.id.txtVwCalif);
        txtVwPuntos = findViewById(R.id.txtVwPuntos);


        skBarPuntos.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressPuntos, boolean fromUser) {
                txtVwPuntos.setText("Puntos para acreditar: "+progressPuntos);
                if (skBarCalif.getProgress() < progressPuntos) {
                    txtVwAcredita.setText("No acredita.");
                } else {
                    txtVwAcredita.setText("Acredita.");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        skBarCalif.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progressCalif, boolean fromUser) {
                txtVwCalif.setText("Calificación: " + progressCalif);
                if (progressCalif < skBarPuntos.getProgress()) {
                    txtVwAcredita.setText("No acredita.");
                } else {
                    txtVwAcredita.setText("Acredita.");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}