package com.example.eva3_7_imagen_post;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Bitmap imagen = null;
    ImageView imgVwMostrar;
    Handler handler = new Handler();

    Thread thread = new Thread() {
        @Override
        public void run() {
            super.run();
            try {
                imagen = cargarImagen("https://www-static.masterclass.com/images/364/medium/1479244784-DM5_CM_Hero_V1_A_Gradient.jpg?1479244784");
                handler.post(runnable);
            } catch (Exception e) {
                Log.wtf("Error", e.toString());
            }


        }
    };

    Runnable runnable = new Runnable() {
        //AQUI PODEMOS TRABAJAR CON INTERFAZ
        @Override
        public void run() {
            imgVwMostrar.setImageBitmap(imagen);

            Toast.makeText(MainActivity.this, "IMAGEN CARGADA ", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwMostrar = findViewById(R.id.imageView);

        thread.start();
    }

    private Bitmap cargarImagen(String url) {
        try {
            InputStream input = (InputStream) new URL(url).getContent();
            imagen = BitmapFactory.decodeStream(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imagen;
    }
}


