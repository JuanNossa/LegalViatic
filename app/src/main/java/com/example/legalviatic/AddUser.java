package com.example.legalviatic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class AddUser extends AppCompatActivity {

    private Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        //datos usuario


        //spinner
        mSpinner = (Spinner) findViewById(R.id.selTipoUser);

        //Elección usuario administrador o normal
        ArrayList<String> tipoUsuario = new ArrayList<>();
        tipoUsuario.add("Seleccione una Opción");
        tipoUsuario.add("Empleado");
        tipoUsuario.add("Administrador");
        ArrayAdapter adp = new ArrayAdapter(AddUser.this, android.R.layout.simple_spinner_dropdown_item, tipoUsuario);
        mSpinner.setAdapter(adp);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String tUser = (String) mSpinner.getAdapter().getItem(i);
                //variable para el tipo de usuario
                Integer tUsuario = 0;
                if(tUser == "Administrador"){
                    tUsuario = 1;
                }else{
                    tUsuario = 0;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    //metodo para usar el spinner de tipo de usuario

}