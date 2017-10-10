package com.example.jonathan.parcial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertarDatos extends AppCompatActivity implements View.OnClickListener{

    EditText nombres, cargo, empresa;
    Button btnIngresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_datos);
        nombres = (EditText) findViewById(R.id.txtNombres);
        cargo = (EditText) findViewById(R.id.txtCargo);
        empresa = (EditText) findViewById(R.id.txtEmpresa);
        btnIngresar = (Button) findViewById(R.id.btnInsertar);
        btnIngresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String nom = nombres.getText().toString();
        String car = cargo.getText().toString();
        String emp = empresa.getText().toString();

        DataBaseManager m = new DataBaseManager(this);
        m.insertar(nom,car,emp);

        Toast.makeText(getApplicationContext(), "Correcto",  Toast.LENGTH_LONG).show();
    }
}
