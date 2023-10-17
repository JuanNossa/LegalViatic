package com.example.legalviatic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class InicioUserAdmin extends AppCompatActivity {

    ImageButton btnAddUser, btnListUsers, btnChangePassword, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_user_admin);

        btnListUsers = findViewById(R.id.listUser);
        btnAddUser = findViewById(R.id.addUser);
        btnChangePassword = findViewById(R.id.changePassword);
        btnExit = findViewById(R.id.exit);

        btnListUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InicioUserAdmin.this, VisualizarUsuarios.class));
            }
        });
        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InicioUserAdmin.this, AddUser.class));
            }
        });
    }
}