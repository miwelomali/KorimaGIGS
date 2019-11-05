package com.example.eva2_2_intentos_llamadas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText edTxtTel;
Intent inMarcar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edTxtTel = findViewById(R.id.edTxtTel);

    }

    @Override
    public void onClick(View view) {
        View btn = findViewById(R.id.button);
        String sTel = "tel:"+ edTxtTel.getText().toString();
        if (view == btn){
        inMarcar = new Intent(Intent.ACTION_DIAL, Uri.parse(sTel));
        }
        else {
            inMarcar = new Intent(Intent.ACTION_CALL, Uri.parse(sTel));
        }
        startActivity(inMarcar);
    }
}
