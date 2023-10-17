package com.example.legalviatic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.ktx.Firebase;

public class LoginActivity extends AppCompatActivity {

    Button btn_login;
    EditText email, password;
    //conexión para firebase
    FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Variable para la conexión de Firebase
        mAuth = FirebaseAuth.getInstance();
        //Variables para el ingreso de datos y el subo de los componentes del Layout
        email = findViewById(R.id.emailAddress);
        password = findViewById(R.id.editPassword);
        btn_login = findViewById(R.id.buttonLogin);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String emailUser = email.getText().toString().trim();
               String passUser = password.getText().toString().trim();

               if (emailUser.isEmpty() || passUser.isEmpty()){
                   Toast.makeText(LoginActivity.this, "Ingrese todos los datos para continuar", Toast.LENGTH_SHORT).show();
               }else{
                   loginUser(emailUser, passUser);
               }

            }
        });

    }

    private void loginUser(String emailUser, String passUser){
        mAuth.signInWithEmailAndPassword(emailUser, passUser).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    finish();
                    startActivity(new Intent(LoginActivity.this, InicioUserAdmin.class));
                }else{
                    Toast.makeText(LoginActivity.this, "Datos Erroneos", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this, "Error al inicial sesión", Toast.LENGTH_SHORT).show();
            }
        });
    }
}