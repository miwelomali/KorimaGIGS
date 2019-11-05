package com.example.eva3_3_hilo_ejemplos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Bitmap imagen = null;
    ImageView imgVwMostrar;
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            imgVwMostrar.setImageBitmap(imagen);
        }
    };
    Thread hilo = new Thread() {
        @Override
        public void run() {
            super.run();
           imagen = cargarImagen("https://www-static.masterclass.com/images/364/medium/1479244784-DM5_CM_Hero_V1_A_Gradient.jpg?1479244784");
           Message msg = handler.obtainMessage();
           handler.sendMessage(msg);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwMostrar = findViewById(R.id.imgVwMostrar);
        hilo.start();
        //Bitmap bitmap = cargarImagen("https://www-static.masterclass.com/images/364/medium/1479244784-DM5_CM_Hero_V1_A_Gradient.jpg?1479244784");
        //imgVwMostrar.setImageBitmap(bitmap);

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
