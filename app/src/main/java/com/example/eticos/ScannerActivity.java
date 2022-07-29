package com.example.eticos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ScannerActivity extends AppCompatActivity {
    Button btn_salir, btn_carrito, btn_escanear, btn_add, btn_limpiar;
    TextView text_codigo, text_nombre, text_stock, text_cantidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        cambiarColor("#28B463", "#356CA0", "#67A5E0");
        btn_carrito = (Button) findViewById(R.id.btn_carrito);
        btn_escanear = (Button) findViewById(R.id.btn_escanear);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_limpiar = (Button) findViewById(R.id.btn_limpiar);
        text_codigo = (TextView) findViewById(R.id.text_codigo);
        text_nombre = (TextView) findViewById(R.id.text_nombre);
        text_stock = (TextView) findViewById(R.id.text_stock);
        text_cantidad = (TextView) findViewById(R.id.text_cantidad);

        //Habilitar lector de codigo de barra
        btn_escanear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator intent = new IntentIntegrator(ScannerActivity.this);
                intent.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                intent.setPrompt("Lector de barras");
                intent.setCameraId(0);
                intent.setBeepEnabled(true);
                intent.setBarcodeImageEnabled(true);
                intent.initiateScan();
            }
        });
        btn_limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_codigo.setText("");
                text_nombre.setText("");
                text_stock.setText("");
                text_cantidad.setText("");
            }
        });
        btn_carrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ScannerActivity.this, Carrito.class);
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

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents() == null){
                Toast.makeText(this, "Lectura cancelada", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                text_codigo.setText(result.getContents());
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public boolean onCreateOptionsMenu(Menu m){
        getMenuInflater().inflate(R.menu.menu, m);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.compras){
            Intent i2 = new Intent(ScannerActivity.this, VentasDia.class);
            startActivity(i2);
        }else if(id == R.id.salir){
            Intent i = new Intent(ScannerActivity.this, MainActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}

//Carrera 49 #74-77
//Hora: 9am
//Servicio de salud ocupacional