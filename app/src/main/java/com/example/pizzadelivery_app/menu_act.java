package com.example.pizzadelivery_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class menu_act extends AppCompatActivity {

    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        video = (VideoView)findViewById(R.id.vMenu);

        String ruta = "android.resourse://" +getPackageName() + "/" +R.raw.video;
        Uri uri = Uri.parse(ruta);
        video.setVideoURI(uri);

        MediaController media = new MediaController(this);
        video.setMediaController(media);
    }

    public void clientes(View view)
    {
        Intent i = new Intent(this, firebase_act.class);
        startActivity(i);
    }

    public void promociones(View view)
    {
        ArrayList<String> clientes = new ArrayList<String>();

        clientes.add("Ramiro");
        clientes.add("Rosa");
        clientes.add("Robert");

        Intent i = new Intent(this, promociones_act.class);
        i.putExtra("clientes", clientes);

        startActivity(i);
    }
}