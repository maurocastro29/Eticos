package com.example.eticos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConfirmacionCompra extends AppCompatActivity {
    Button btn_regresar_inicio, btn_generar_recibo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_compra);
        cambiarColor("#28B463", "#356CA0", "#67A5E0");
        btn_generar_recibo = (Button) findViewById(R.id.btn_generar_recibo);
        btn_regresar_inicio = (Button) findViewById(R.id.btn_regresar_inicio);


        btn_regresar_inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ConfirmacionCompra.this, ScannerActivity.class);
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