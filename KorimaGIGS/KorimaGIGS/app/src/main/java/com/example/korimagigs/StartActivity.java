package com.example.korimagigs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StartActivity extends AppCompatActivity {
    Intent intent;

    FirebaseUser firebaseUser;

    @Override
    protected void onStart() {
        super.onStart();
        //Se necesita de por lo menos un usuario en la base de datos para que no crashe
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        //Si ya existe un usuario logeado

        if (firebaseUser != null) {
            Intent intento = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intento);
            finish();
        }




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Pantalla completa
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start);




    }

    public void onClick(View v) {
        if (v.getId() == R.id.btnSignIn) {
            intent = new Intent(this, activity_login.class);

        } else if (v.getId() == R.id.btnSignUp) {

            intent = new Intent(this, activity_register.class);

        }


        startActivity(intent);
    }
}
