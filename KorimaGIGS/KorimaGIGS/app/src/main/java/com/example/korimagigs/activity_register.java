package com.example.korimagigs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;


public class activity_register extends AppCompatActivity {
Intent intent;
Button btnSignUp;

FirebaseAuth auth;
DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnSignUp = findViewById(R.id.btnSignUp);
        auth = FirebaseAuth.getInstance();
        intent = new Intent(this, activity_login.class);

    }
    private void onRegister(String sUsername, String sEmail, String sPassword){
        Toast.makeText(this, "Intentando Crear Sesion", Toast.LENGTH_SHORT).show();
        auth.createUserWithEmailAndPassword(sEmail,sPassword)
        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        startActivity(intent);
    }
}
