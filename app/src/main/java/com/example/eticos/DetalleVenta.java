package com.example.eticos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DetalleVenta extends AppCompatActivity {
    Button btn_volver_detalle, btn_generar_recibo_detalle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_venta);
        cambiarColor("#28B463", "#356CA0", "#67A5E0");

        btn_generar_recibo_detalle = (Button) findViewById(R.id.btn_generar_recibo_detalle);
        btn_volver_detalle = (Button) findViewById(R.id.btn_volver_detalle);

        btn_volver_detalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DetalleVenta.this, VentasDia.class);
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