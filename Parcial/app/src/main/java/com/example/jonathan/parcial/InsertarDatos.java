package com.example.jonathan.parcial;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jonathan.parcial.utilidades.Utilidades;

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
        registrarUsuarios();
    }
    public void registrarUsuarios() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_empleados",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRES,nombres.getText().toString());
        values.put(Utilidades.CAMPO_CARGO,cargo.getText().toString());
        values.put(Utilidades.CAMPO_EMPRESA,empresa.getText().toString());

        Long resultante = db.insert(Utilidades.TABLA_EMPLEADO,null,values);

        Toast.makeText(getApplicationContext(),"Registro Correcto ", Toast.LENGTH_SHORT).show();
    }
}
