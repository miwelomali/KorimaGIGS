package com.example.eva1_examen_volumen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnCalcularVolumen;
    private EditText edTxtRadio;
    private TextView txtVwAngulo;
    private SeekBar sbBarraAngulo;
    private double dAngulo;
    private double dRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalcularVolumen = findViewById(R.id.button4);
        edTxtRadio = findViewById(R.id.edTxtRadio);
        txtVwAngulo = findViewById(R.id.txtVwAngulo);
        sbBarraAngulo = findViewById(R.id.sbBarraAngulo);
        sbBarraAngulo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int iGrados, boolean b) {
                txtVwAngulo.setText(iGrados + "° grados");
                dAngulo = iGrados;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnCalcularVolumen.setOnClickListener(new View.OnClickListener() { //Evento para calcular el volumen
            @Override
            public void onClick(View view) {
                try {
                    double dRadio = Double.parseDouble(edTxtRadio.getText().toString());
                    double dVolumen = (double) 2 / 3;
                    Double Resu = dVolumen * ((dAngulo * dRadio) * 3);

                    Toast.makeText(MainActivity.this, "Volumen: " + Resu.intValue(), Toast.LENGTH_LONG).show();

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    //Obtiene el valor de Radio si se utiliza el teclado numerico
    public void setText(View v) {
        dRadio = Double.parseDouble(edTxtRadio.getText().toString());
        closeKeyboard();
    }

    //Metodo para ocultar el teclado despues de ingresar el valor en Radio.
    public void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}
