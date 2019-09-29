package com.example.eva1_5_radiogroup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements RadioGroup.OnCheckedChangeListener {
    RadioGroup rdGrpComida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rdGrpComida = findViewById(R.id.radioGr);
        rdGrpComida.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        String mensaje = "";
        if (checkedId == R.id.radioButton) {
            mensaje = "Montados";
        } else if (checkedId == R.id.radioButton2) {
            mensaje = "Burritos";
        } else if (checkedId == R.id.radioButton3) {
            mensaje = "Tortas";
        } else if (checkedId == R.id.radioButton4) {
            mensaje = "Tacos";
        }
        Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
    }




}
