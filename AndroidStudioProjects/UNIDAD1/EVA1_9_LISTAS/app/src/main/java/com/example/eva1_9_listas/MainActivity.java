package com.example.eva1_9_listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
ListView Lista;
TextView Texto;

String [] asResta = {
        "Montados la junta",
        "Orientales",
        "La Cerve",
        "Buffalucas",
        "Tripitas",
        "Tortas Piolin",
        "La Cafe",
        "Enrizos"
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Texto = findViewById(R.id.txtVwTexto);
        Lista = findViewById(R.id.lisVwLista);
        Lista.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, asResta));

        Lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        //Toast.makeText(this, asResta[position], Toast.LENGTH_SHORT).show();
        Texto.setText(asResta[position]);

    }
}
