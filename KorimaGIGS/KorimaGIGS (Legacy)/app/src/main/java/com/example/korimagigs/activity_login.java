package com.example.korimagigs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class activity_login extends AppCompatActivity {
TextView txtVwRegister;
EditText edTxtEmail, edTxtPassword;
Button btnSingUp;
Intent intent;

FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Pantalla completa
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);
        txtVwRegister = findViewById(R.id.textView5);

        edTxtEmail = findViewById(R.id.edTxtEmail);
        edTxtPassword = findViewById(R.id.edTxtPassword);
        btnSingUp = findViewById(R.id.btnSignIn);

        intent = new Intent(this, activity_register.class);

        auth = FirebaseAuth.getInstance();

    }
    public void onRegister(View v){
        startActivity(intent);
        finish();

    }
    public void onClick(View v){
        String txt_email = edTxtEmail.getText().toString();
        String txt_password = edTxtPassword.getText().toString();
        if (TextUtils.isEmpty(txt_email) | TextUtils.isEmpty(txt_password)){
            Toast.makeText(this, "All parameters must be filled", Toast.LENGTH_SHORT).show();
        } else{
            auth.signInWithEmailAndPassword(txt_email, txt_password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Intent intento = new Intent(getApplicationContext(), MainActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intento);
                                finish();
                            }
                            else {
                                Toast.makeText(activity_login.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                            }
                        }

                    });
        }

    }


}
