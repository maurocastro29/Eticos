package com.example.eticos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnIngresar;
    EditText usuario, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cambiarColor("#28B463", "#356CA0", "#67A5E0");
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        usuario = (EditText) findViewById(R.id.textUsuario);
        password = (EditText) findViewById(R.id.textPassword);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validarCampos()){
                    Intent i = new Intent(MainActivity.this, ScannerActivity.class);
                    startActivity(i);
                }
            }
        });
    }

    private void cambiarColor(String primaryDark, String primary, String background){
        getWindow().setStatusBarColor(Color.parseColor(primaryDark));
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(primary)));
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor(background)));
        getWindow().setNavigationBarColor(Color.parseColor(primary));
    }

    public boolean validarCampos(){
        boolean validar = true;
        String user, passw;
        user = usuario.getText().toString();
        passw = password.getText().toString();
        if(user.isEmpty()){
            usuario.setError("Campo vacio, por favor ingrese su correo");
            validar = false;
        }
        if(passw.isEmpty()){
            password.setError("Campo vacio, por favor ingrese su contraseña");
            validar = false;
        }
        return validar;
    }



}