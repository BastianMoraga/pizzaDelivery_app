package com.example.pizzadelivery_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import Clases.Promociones;

public class promociones_act extends AppCompatActivity {

    private Spinner spinner;
    private EditText promocion, envio;
    private TextView msg, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promociones_act);

        promocion = (EditText)findViewById(R.id.edtxtPromocion);
        envio = (EditText)findViewById(R.id.edtxtEnvio);
        msg = (TextView)findViewById(R.id.txtMensaje);
        total = (TextView)findViewById(R.id.txtTotal);

        spinner = (Spinner)findViewById(R.id.spPromocion);

        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("clientes");
        ArrayAdapter<String> adaptClientes = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaClientes);

        spinner.setAdapter(adaptClientes);
    }

    public void calcular(View view)
    {
        String cliente = spinner.getSelectedItem().toString();
        String edPromo = promocion.getText().toString();
        int edEnvio = Integer.parseInt(envio.getText().toString());

        Promociones promo = new Promociones();

        int tot, get;

        if (edPromo.equals("Pizzas promo"))
        {
            get = Integer.parseInt(promo.getPizzasPromo());
            tot = get + edEnvio;

            msg.setText("Estimado " + cliente + "el final según promoción y envio es:");
            total.setText("$" + tot);
        }
        if (edPromo.equals("Master pizza"))
        {
            get = Integer.parseInt(promo.getMasterPizza());
            tot = get + edEnvio;

            msg.setText("Estimado " + cliente + "el final según promoción y envio es:");
            total.setText("$" + tot);
        }
        if (edPromo.equals("Pizza max"))
        {
            get = Integer.parseInt(promo.getPizzaMax());
            tot = get + edEnvio;

            msg.setText("Estimado " + cliente + "el final según promoción y envio es:");
            total.setText("$" + tot);
        }
        else
        {
            Toast.makeText(this, "Promocion no disponible", Toast.LENGTH_LONG).show();
        }

    }
}