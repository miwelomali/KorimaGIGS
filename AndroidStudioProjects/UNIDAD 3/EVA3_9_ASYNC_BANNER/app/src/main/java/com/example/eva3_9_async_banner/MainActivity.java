package com.example.eva3_9_async_banner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
int iCont = 0;
ImageView imagen;
SeekBar barra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagen = findViewById(R.id.imgVwImagen);
        barra = findViewById(R.id.seekBar);
        MiClaseAsincrona miClaseAsincrona = new MiClaseAsincrona();
        miClaseAsincrona.execute(20,500);

    }
    class MiClaseAsincrona extends AsyncTask<Integer, Integer,Integer>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
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

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            return null;
        }
    }
}
