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
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class activity_register extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    Intent intent;
    Button btnSignUp;
    RadioGroup rdGrpTipoUsuario;
    EditText edTxtUsername, edTxtEmail, edTxtPassword;
    FirebaseAuth auth;
    DatabaseReference reference;
    String sTipoUsuario = "User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Pantalla completa
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_register);

        btnSignUp = findViewById(R.id.btnSignIn);
        edTxtUsername = findViewById(R.id.edTxtUsername);
        edTxtEmail = findViewById(R.id.edTxtEmail);
        edTxtPassword = findViewById(R.id.edTxtPassword);

        rdGrpTipoUsuario = findViewById(R.id.rdGrpTipoUsuario);
        rdGrpTipoUsuario.setOnCheckedChangeListener(this);

        auth = FirebaseAuth.getInstance();
        intent = new Intent(this, activity_login.class);

    }

    public void onClick(View v) {
        String txt_username = edTxtUsername.getText().toString();
        String txt_email = edTxtEmail.getText().toString();
        String txt_password = edTxtPassword.getText().toString();

        if (TextUtils.isEmpty(txt_username) || TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)) {
            Toast.makeText(this, "All parameters must be filled", Toast.LENGTH_SHORT).show();
        } else if (txt_password.length() < 6) {
            Toast.makeText(this, "Password must be at least 6 characters", Toast.LENGTH_SHORT).show();
        } else {
            onRegister(txt_username, txt_email, txt_password);
        }

    }

    private void onRegister(final String sUsername, String sEmail, String sPassword) {
        Toast.makeText(this, "Creating User...", Toast.LENGTH_SHORT).show();
        auth.createUserWithEmailAndPassword(sEmail, sPassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            final FirebaseUser firebaseuser = auth.getCurrentUser();
                            assert firebaseuser != null;
                            String userid = firebaseuser.getUid();

                            reference = FirebaseDatabase.getInstance().getReference("Users").child(userid);
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("id", userid);
                            hashMap.put("username", sUsername);
                            hashMap.put("type", sTipoUsuario);
                            hashMap.put("imageURL", "default");

                            reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Intent intento = new Intent(getApplicationContext(), MainActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intento);
                                        finish();
                                        Toast.makeText(activity_register.this, "User Registered", Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });
                        } else {
                            Toast.makeText(activity_register.this, "Can't register with this email or password", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }



    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

        if (checkedId == R.id.rdBtnUser) {
            sTipoUsuario = "User";
            Toast.makeText(this, "You can only see events and artists", Toast.LENGTH_LONG).show();
        } else if (checkedId == R.id.rdBtnArtist) {
            sTipoUsuario = "Artist";
            Toast.makeText(this, "You can create events and custom your exposure to the users", Toast.LENGTH_LONG).show();
        } else if (checkedId == R.id.rdBtnUkn) {
            sTipoUsuario = "Unknown";
            Toast.makeText(this, "You can either see events or create 'em", Toast.LENGTH_LONG).show();
        }
        
    }
}
