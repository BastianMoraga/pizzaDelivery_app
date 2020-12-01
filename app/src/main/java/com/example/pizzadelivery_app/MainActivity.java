package com.example.pizzadelivery_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;

    private ProgressBar progress;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = (ProgressBar)findViewById(R.id.pb);
        progress.setVisibility(View.INVISIBLE);

        user = (EditText)findViewById(R.id.edtxtUsuario);
        pass = (EditText)findViewById(R.id.edpass);

        boton = (Button)findViewById(R.id.btnIniciar);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Task().execute();
            }
        });
    }

    class Task extends AsyncTask<String, Void, String>{
        @Override
        protected void onPreExecute() {
            progress.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {

            for(int i = 0; i <= 10; i++)
            {
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            String usuario = user.getText().toString();
            String contrasena = pass.getText().toString();

            if((!usuario.isEmpty()) && (!contrasena.isEmpty()))
            {
                if ((usuario.equals("Android")) && (contrasena.equals("123")))
                {
                    progress.setVisibility(View.VISIBLE);
                    credencialesCorrectas();
                    Intent i = new Intent(getBaseContext(), menu_act.class);
                    startActivity(i);
                }
                else
                {
                    credencialesIncorrectas();
                }
            }
            else
            {
                camposNull();
            }
        }
    }

    public void camposNull()
    {
        Toast.makeText(this, "Completar ambos campos", Toast.LENGTH_LONG).show();
    }
    public  void credencialesIncorrectas()
    {
        Toast.makeText(this, "Usuario o contraseña incorrecto", Toast.LENGTH_LONG).show();
    }
    public void credencialesCorrectas()
    {
        Toast.makeText(this, "Auntentificacion correcta", Toast.LENGTH_LONG).show();
    }
}