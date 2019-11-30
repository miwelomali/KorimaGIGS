package com.example.eva3_5_handler_post;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView txtVwDatos;
Thread thread = new Thread(){
    @Override
    public void run() {
        super.run();
        while (true){
            try {
                Thread.sleep(1000);
                handler.post(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
};


   Handler handler =  new Handler();
   //Aqui PODEMOS MODIFICAR LA INTERFAZ GRAFICA
   Runnable runnable = new Runnable() {
       @Override
       public void run() {
           txtVwDatos.append("Hola Mundo!!" + "\n");
       }
   };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwDatos = findViewById(R.id.txtVwDatos);
        thread.start();
    }
}
