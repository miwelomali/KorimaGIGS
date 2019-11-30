package com.example.eva3_6_banner_post;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar;
    ImageView imagen;
    int iCont = 1;
    int iCambio_Tiempo = 1000;
    int value;
    int max = 3000;
    int min = 200;

    Thread thread = new Thread() {
        @Override
        public void run() {
            super.run();
            while (true) {
                try {
                    Thread.sleep(iCambio_Tiempo);
                    handler.post(runnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            switch (iCont) {
                case 1:
                    imagen.setImageResource(R.drawable.cloudy);
                    iCont++;
                    break;

                case 2:
                    imagen.setImageResource(R.drawable.sunny);
                    iCont++;
                    break;
                default:
                    imagen.setImageResource(R.drawable.rainy);
                    iCont = 1;
                    break;

                //default:
                // imagen.setImageResource(R.drawable.ic_launcher_background);
            }
        }
    };


    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = findViewById(R.id.seekBar);
        imagen = findViewById(R.id.imageView);
        seekBar.setMax(max - min);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                value = max - i;

                iCambio_Tiempo = value;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        thread.start();
    }
}
