package com.example.legalviatic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddUser extends AppCompatActivity {

    private Spinner mSpinner;
    Button btn_add_user;
    EditText nombres, documento, mail, password;

    //firebase
    private FirebaseFirestore mfirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        //boton
        btn_add_user = findViewById(R.id.btnAddUser);
        //datos usuario
        nombres = findViewById(R.id.nombresUser);
        documento = findViewById(R.id.docUser);
        mail = findViewById(R.id.mailUser);
        password = findViewById(R.id.passwordUser);
        //firebase
        mfirestore = FirebaseFirestore.getInstance();
        //spinner
        mSpinner = (Spinner) findViewById(R.id.selTipoUser);

        //Elección usuario administrador o normal

        ArrayList<String> tipoUsuario = new ArrayList<>();
        tipoUsuario.add("Seleccione una Opción");
        tipoUsuario.add("Empleado");
        tipoUsuario.add("Administrador");
        ArrayAdapter adp = new ArrayAdapter(AddUser.this, android.R.layout.simple_spinner_dropdown_item, tipoUsuario);
        //para usar el spinner y saber que usuario es
        mSpinner.setAdapter(adp);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String tUser = (String) mSpinner.getAdapter().getItem(i);
                int tUsuario;
                if(tUser.equals("Administrador")){
                    tUsuario = 1;
                }else{
                    tUsuario = 0;
                }

                int saldo = 0;
                btn_add_user.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String nameUser = nombres.getText().toString().trim();
                        String documentoUser = documento.getText().toString().trim();
                        String mailUser = mail.getText().toString().trim();
                        String pass = password.getText().toString().trim();

                        if(nameUser.isEmpty() || documentoUser.isEmpty() || mailUser.isEmpty() || pass.isEmpty()){
                            Toast.makeText(getApplicationContext(), "Ingrese todos los datos", Toast.LENGTH_SHORT).show();
                        }else{
                            postCrearNuevoUsuario(nameUser, documentoUser, mailUser, pass, tUsuario, saldo);
                        }

                    }
                });
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void postCrearNuevoUsuario(String nameUser, String documentoUser, String mailUser, String pass, int tUsuario, int saldo){
        Map<String, Object> map = new HashMap<>();
        map.put("nombres", nameUser);
        map.put("documento", documentoUser);
        map.put("correo", mailUser);
        map.put("password", pass);
        map.put("tipoUsuario", tUsuario);
        map.put("saldo", saldo);
        mfirestore.collection("usuarios").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(getApplicationContext(), "Creado Exitosamente", Toast.LENGTH_SHORT).show();
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Error al subir datos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}