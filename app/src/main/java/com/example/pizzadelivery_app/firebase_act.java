package com.example.pizzadelivery_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import Clases.Cliente;

public class firebase_act extends AppCompatActivity {

    private EditText nombre, destino, promocion;
    private Button guardar;

    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_act);

        nombre = (EditText)findViewById(R.id.edtxtNombre);
        destino = (EditText)findViewById(R.id.edtxtDestino);
        promocion = (EditText)findViewById(R.id.edtxtPromocion);
        guardar = (Button)findViewById(R.id.btnGuardar);

        inicializarBase();

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!nombre.equals(""))
                {
                    Cliente cli = new Cliente();

                    cli.setId(UUID.randomUUID().toString());
                    cli.setNombre(nombre.getText().toString());
                    cli.setDestino(destino.getText().toString());
                    cli.setPromocion(promocion.getText().toString());

                    databaseReference.child("Clientes").child(cli.getId()).setValue(cli);

                    Toast.makeText(getBaseContext(), "Se ha guardado el cliente", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getBaseContext(), "No se ha guardado", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void inicializarBase()
    {
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();
    }

    public void listado(View view)
    {
        Intent i = new Intent(this, listado_clientes_act.class);
        startActivity(i);
    }
}