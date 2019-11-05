package com.example.eva2_9_dialogos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void onClick(View v) {
    new AlertDialog.Builder(this)
            .setTitle("Cuadro de dialogo estandar").setMessage("Hola mundo Cruel")
            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //ACCION
                    Toast.makeText(getApplicationContext(), "Boton OK", Toast.LENGTH_SHORT).show();
                }
            })
            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //ACCION
                    Toast.makeText(getApplicationContext(), "Boton NO", Toast.LENGTH_SHORT).show();
                }
            })
            .setNeutralButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //ACCION
                    Toast.makeText(getApplicationContext(), "Boton CANCELAR", Toast.LENGTH_SHORT).show();
                }
            }).create().show();

    }

    public void onClickDialog(View v) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.mi_dialogo);
        //VINCULAR LOS WIDGETS DEL CUADRO DE DIALOGO
        final EditText edTxtCaptu;
        edTxtCaptu = dialog.findViewById(R.id.edTxtNombre);
        Button btnOK;
        btnOK = dialog.findViewById(R.id.btnOk);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sCade = edTxtCaptu.getText().toString();
                Toast.makeText(getApplicationContext(), sCade, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.show();

    }
}