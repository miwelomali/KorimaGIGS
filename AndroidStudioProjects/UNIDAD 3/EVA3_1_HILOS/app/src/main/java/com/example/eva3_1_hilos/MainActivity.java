package com.example.eva3_1_hilos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView txtTexto;
Thread tRun;
Thread t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTexto = findViewById(R.id.txtVwTexto);
        t = new Thread(){
            @Override
            public void run() {
                super.run();
                //Aqui se hace el trabajo en segundo plano
                for (int i = 0; i < 10; i++){
                    try {
                        Thread.sleep(1000);
                        Log.wtf("hilo por medio de t", "i = " + i);
                        //txtTexto.setText("Runnable ----> i = " + i); //No funciona
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Log.wtf("Hilo interrumpido de t (FOR)", "Interrupcion");
                        t.interrupt();
                        break;
                    }
                }
                int i = 0;
                while(true){
                    try {
                        Thread.sleep(1000);
                        Log.wtf("hilo por medio de t", "i = " + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Log.wtf("Hilo interrumpido t", "Interrupcion");
                        break;
                    }
                }
            }
        };
        t.start(); //El hilo siempre iniciarlo con un start
        Runnable rRun = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++){
                    try {
                        Thread.sleep(1000);
                        Log.wtf("hilo por medio de runnable", "i = " + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Log.wtf("Hilo interrumpido de runnable", "Interrupcion");
                        break;

                    }
                }
            }
        };
        tRun = new Thread(rRun);
        tRun.start();

    }

    @Override
    protected void onStop() {
        super.onStop();
        tRun.interrupt();
        t.interrupt();

    }
}
