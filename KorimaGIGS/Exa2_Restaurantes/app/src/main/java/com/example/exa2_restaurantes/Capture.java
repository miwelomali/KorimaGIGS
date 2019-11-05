package com.example.exa2_restaurantes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Capture extends AppCompatActivity {

    EditText txtName, txtDesc, txtDir;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture);

        txtName = findViewById(R.id.edTxtName);
        txtDesc = findViewById(R.id.edTxtDesc);
        txtDir = findViewById(R.id.edTxtDir);

        btnSave = findViewById(R.id.btnSave);
    }
}
