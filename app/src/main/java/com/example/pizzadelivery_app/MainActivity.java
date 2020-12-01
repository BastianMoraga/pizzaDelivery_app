package com.example.pizzadelivery_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText)findViewById(R.id.edtxtUsuario);
        pass = (EditText)findViewById(R.id.edpass);
    }

    public void iniciar(View view)
    {
        String usuario = user.getText().toString();
        String contrasena = pass.getText().toString();

        if(usuario == "ANDROID" || usuario == "Android" && contrasena == "123")
        {
            Intent i = new Intent(this, menu_act.class);
            startActivity(i);
        }
    }
}