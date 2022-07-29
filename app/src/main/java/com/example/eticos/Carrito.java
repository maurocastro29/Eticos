package com.example.eticos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Carrito extends AppCompatActivity {
    Button btn_volver, btn_cancelar_compra, btn_comprar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        cambiarColor("#28B463", "#356CA0", "#67A5E0");
        btn_volver = (Button) findViewById(R.id.btn_volver);
        btn_cancelar_compra = (Button) findViewById(R.id.btn_cancelar_compra);
        btn_comprar = (Button) findViewById(R.id.btn_comprar);

        /**
         * Confirmar una compra que se encuentre en el carrito de compras
         * **/
        btn_comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Carrito.this, DatosCliente.class);
                startActivity(i);
            }
        });
        /**
         * Se regresa a la vista de escanear productos sin eliminar de carrito de compras
         * **/
        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Carrito.this, ScannerActivity.class);
                startActivity(i);
            }
        });
        /**
         * Elimina todos los productos del carrito de compras y regresa a
         * la vista de escanear productos
         * **/
        btn_cancelar_compra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Carrito.this, ScannerActivity.class);
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