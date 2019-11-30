package com.example.eva3_12_broadcast_receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView txtVwDatos;
Intent inService;
BroadcastReceiver brReceptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwDatos = findViewById(R.id.txtVwDatos);
        inService = new Intent(this, MyService.class);
        brReceptor = new MiReceptorDifusion();
        IntentFilter filtro = new IntentFilter("MI_SERVICIO");
        registerReceiver(brReceptor, filtro);
    }

    public void inicioServicio(View v){
        startService(inService);
    }

    public void pararServicio(View v){
        stopService(inService);
    }

    class MiReceptorDifusion extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            txtVwDatos.append(intent.getStringExtra("MENSAJE") + "\n");

        }
    }
}
