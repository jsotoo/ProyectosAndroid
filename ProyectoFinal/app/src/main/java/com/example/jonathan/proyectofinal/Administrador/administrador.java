package com.example.jonathan.proyectofinal.Administrador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jonathan.proyectofinal.R;

public class administrador extends AppCompatActivity implements View.OnClickListener{

    Button eventos, prestamos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);
        eventos = (Button) findViewById(R.id.btnEventos);
        prestamos = (Button) findViewById(R.id.btnPrest);
        eventos.setOnClickListener(this);
        prestamos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == eventos){
            Intent i = new Intent(administrador.this, adminEventos.class);
            startActivity(i);
        }
        if(v == prestamos){
            Intent i2 = new Intent(administrador.this, adminPrestamos.class);
            startActivity(i2);
        }
    }
}
