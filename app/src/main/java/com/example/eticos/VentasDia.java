package com.example.eticos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VentasDia extends AppCompatActivity {
    Button btn_detalle_venta, btn_volver_ventas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas_dia);
        cambiarColor("#28B463", "#356CA0", "#67A5E0");
        btn_detalle_venta = (Button) findViewById(R.id.btn_detalle_venta);
        btn_volver_ventas = (Button) findViewById(R.id.btn_volver_ventas);


        btn_detalle_venta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VentasDia.this, DetalleVenta.class);
                startActivity(i);
            }
        });
        btn_volver_ventas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(VentasDia.this, ScannerActivity.class);
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