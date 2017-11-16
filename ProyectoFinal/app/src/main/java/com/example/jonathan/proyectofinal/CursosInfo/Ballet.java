package com.example.jonathan.proyectofinal.CursosInfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jonathan.proyectofinal.R;
import com.example.jonathan.proyectofinal.RegistroCurso.RegistroCurso;

public class Ballet extends AppCompatActivity implements View.OnClickListener{

    Button reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ballet);
        reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i =  new Intent(Ballet.this, RegistroCurso.class);
        startActivity(i);
    }
}
