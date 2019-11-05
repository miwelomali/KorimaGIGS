package com.example.eva2_6_bundles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
EditText edTxtNombre, edTxtApellido, edTxtEdad;
RadioGroup rdGrpSexo;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edTxtNombre = findViewById(R.id.edTxtNombre);
        edTxtApellido = findViewById(R.id.edTxtApeido);
        edTxtEdad = findViewById(R.id.edTxtEdad);
        rdGrpSexo = findViewById(R.id.rdGrpSexo);
        intent = new Intent(this, Secundaria.class);

    }

    public void onEntrar(View v){

        Bundle bundle = new Bundle();
        bundle.putString("nombre", edTxtNombre.getText().toString());
        bundle.putString("apellido", edTxtApellido.getText().toString());
        int iEdad = Integer.parseInt(edTxtEdad.getText().toString());
        bundle.putInt("edad",iEdad);

        int iSexo = 0;
        if(rdGrpSexo.getCheckedRadioButtonId() == R.id.rBtnMa) {
            iSexo = 0;
        }
        if(rdGrpSexo.getCheckedRadioButtonId() == R.id.rBtnFe) {
            iSexo = 1;

        }
        if(rdGrpSexo.getCheckedRadioButtonId() == R.id.rBtnOtro) {
            iSexo = 2;

        }
        if(rdGrpSexo.getCheckedRadioButtonId() == R.id.rBtnSistemas) {
            iSexo = 3;

        }

        bundle.putInt("sexo",iSexo);

        intent.putExtras(bundle);


        startActivity(intent);
    }
}
