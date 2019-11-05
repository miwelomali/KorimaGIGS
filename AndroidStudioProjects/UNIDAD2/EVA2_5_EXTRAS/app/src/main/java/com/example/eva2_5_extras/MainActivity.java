package com.example.eva2_5_extras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Intent inLanzar;
EditText edTxtInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edTxtInfo = findViewById(R.id.editText);
        inLanzar = new Intent(this,Secundaria.class );

    }
    public void enviarInfo(View v){
        String sMensaje;
        sMensaje = edTxtInfo.getText().toString();
        inLanzar.putExtra("datos", sMensaje);
        inLanzar.putExtra("numeros", 12);
        startActivity(inLanzar);
    }
}
