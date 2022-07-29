package com.example.eticos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DatosCliente extends AppCompatActivity {

    Button btn_confirmar, btn_volver_compra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_cliente);
        cambiarColor("#28B463", "#356CA0", "#67A5E0");
        btn_confirmar = (Button) findViewById(R.id.btn_confirmar);
        btn_volver_compra = (Button) findViewById(R.id.btn_volver_compra);

        btn_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DatosCliente.this, ConfirmacionCompra.class);
                startActivity(i);
            }
        });

        btn_volver_compra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DatosCliente.this, Carrito.class);
                startActivity(i);
            }
        });



    }

    private void cambiarColor(String primaryDark, String primary, String background){
        getWindow().setStatusBarColor(Color.parseColor(primaryDark));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(primary)));
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor(background)));
        getWindow().setNavigationBarColor(Color.parseColor(primary));
    }
}