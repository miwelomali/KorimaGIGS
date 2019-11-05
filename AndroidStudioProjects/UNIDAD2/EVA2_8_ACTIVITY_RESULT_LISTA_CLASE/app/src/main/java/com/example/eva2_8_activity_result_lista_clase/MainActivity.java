package com.example.eva2_8_activity_result_lista_clase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtVwCiudad, txtVwTemper, txtVwClima;
    TextView txtVwNombre, txtVwComida, txtVwLocation, txtVwRating;
    double dTemper, dRating;
    int iImagenClima, iImagenRestaurante;
    private static final String[] phoneProjection = new String[] { ContactsContract.CommonDataKinds.Phone.DATA };
    ImageView ImagenClima, ImagenRestaurante;
    Intent inMarcar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwCiudad = findViewById(R.id.txtVwCiudad);
        txtVwClima = findViewById(R.id.txtVwClima);
        txtVwTemper = findViewById(R.id.txtVwTemper);
        ImagenClima = findViewById(R.id.imageView2);
        txtVwNombre = findViewById(R.id.txtVwNombre);
        txtVwComida = findViewById(R.id.txtVwComida);
        txtVwLocation = findViewById(R.id.txtVwLocacion);
        txtVwRating = findViewById(R.id.txtVwRating);
        ImagenRestaurante = findViewById(R.id.imageView);

    }

    public void onClickClima(View v) {
        ComponentName cn = new ComponentName("com.example.eva1_10_listaclima", "com.example.eva1_10_listaclima.MainActivity");
        Intent in = new Intent(Intent.ACTION_MAIN);
        in.setComponent(cn);
        startActivityForResult(in, 1000);


    }

    public void onClickRes(View v) {
        ComponentName cn = new ComponentName("com.example.eva1_11_listarestaurantes", "com.example.eva1_11_listarestaurantes.MainActivity");
        Intent in = new Intent(Intent.ACTION_MAIN);
        in.setComponent(cn);
        startActivityForResult(in, 2000);


    }

    public void onClickCall(View v) {
        Intent in = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        in.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);


        startActivityForResult(in, 3000);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            if (resultCode == Activity.RESULT_OK) {

                txtVwCiudad.setText(data.getStringExtra("ciudad"));
                dTemper = data.getDoubleExtra("temperatura", 30);
                txtVwTemper.setText(dTemper + "");
                txtVwClima.setText(data.getStringExtra("clima"));
                iImagenClima = data.getIntExtra("imagenClima", 30);
                ImagenClima.setImageResource(iImagenClima);


            }
        }
        if (requestCode == 2000) {
            if (resultCode == Activity.RESULT_OK) {

                txtVwNombre.setText(data.getStringExtra("nombre"));
                txtVwComida.setText(data.getStringExtra("comida"));
                txtVwLocation.setText(data.getStringExtra("locacion"));
                iImagenRestaurante = data.getIntExtra("imagenRes",30);
                ImagenRestaurante.setImageResource(iImagenRestaurante);
                dRating = data.getDoubleExtra("rating", 30);
                txtVwRating.setText(dRating + " Estrellas");

            }
        } else if (requestCode == 3000) {
            if (resultCode == Activity.RESULT_OK) {

                Toast.makeText(this, data.getDataString(), Toast.LENGTH_SHORT).show();
                Uri contactUri = data.getData();
                if (null == contactUri) return;
                //no tampering with Uri makes this to work without READ_CONTACTS permission
                Cursor cursor = getContentResolver().query(contactUri, null, null, null, null);
                if (null == cursor) return;
                try {
                    while (cursor.moveToNext()) {
                        int phoneIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                        Toast.makeText(this, cursor.getString(phoneIndex), Toast.LENGTH_SHORT).show();
                        String sTel = "tel:"+ cursor.getString(phoneIndex);
                        inMarcar = new Intent(Intent.ACTION_CALL);
                        inMarcar = new Intent(Intent.ACTION_CALL, Uri.parse(sTel));
                    }
                } finally {
                    cursor.close();
                }
        startActivity(inMarcar);
        }
    }}
}
