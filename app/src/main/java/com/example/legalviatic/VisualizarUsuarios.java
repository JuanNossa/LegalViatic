package com.example.legalviatic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class VisualizarUsuarios extends AppCompatActivity {

    RecyclerView recyclerViewUser;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_usuarios);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        recyclerViewUser = findViewById(R.id.recyclerViewUsuarios);
        recyclerViewUser.setLayoutManager(new LinearLayoutManager(this));

        DocumentReference dreference = fStore.collection("usuarios").document();

        FirebaseRecyclerOptions<modelListaUsuarios> options =
                new FirebaseRecyclerOptions.Builder<>().setQuery(FirebaseFirestore.getInstance(), modelListaUsuarios.class).build();
    }
}