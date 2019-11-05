package com.example.eva2_3_mensaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Intent inSMS;
    EditText txtNumero;
    EditText txtMensaje;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMensaje = findViewById(R.id.editText2);
        txtNumero = findViewById(R.id.editText);
        btnSend = findViewById(R.id.btnSend);


    }

    @Override
    public void onClick(View view) {
        String sTel = "smsto:" + txtNumero.getText().toString();
        inSMS = new Intent(Intent.ACTION_SENDTO, Uri.parse(sTel));
        inSMS.putExtra("sms_body",txtMensaje.getText().toString());
        startActivity(inSMS);
    }
}
