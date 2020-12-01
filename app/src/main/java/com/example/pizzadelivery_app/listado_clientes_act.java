package com.example.pizzadelivery_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Clases.Cliente;

public class listado_clientes_act extends AppCompatActivity {

    private ListView listado;

    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

    Cliente cliSelected;

    FirebaseDatabase firebase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_clientes_act);

        listado = (ListView)findViewById(R.id.lv);

        inicializarBase();

        databaseReference.child("Clientes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot objSnapshot: snapshot.getChildren())
                {
                    Cliente cli = objSnapshot.getValue(Cliente.class);

                    listaClientes.add(cli);

                    ArrayAdapter adapt = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1, listaClientes);

                    listado.setAdapter(adapt);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                cliSelected = (Cliente) adapterView.getItemAtPosition(position);
            }
        });
    }

    public void eliminar(View view)
    {
        Cliente c = new Cliente();
        c.setId(cliSelected.getId());
        databaseReference.child("Clientes").child(c.getId()).removeValue();

        Toast.makeText(this, "Se ha eliminado un cliente", Toast.LENGTH_LONG).show();
    }

    public void inicializarBase()
    {
        FirebaseApp.initializeApp(this);
        firebase = FirebaseDatabase.getInstance();
        databaseReference = firebase.getReference();
    }
}