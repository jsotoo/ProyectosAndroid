package com.example.jonathan.proyectofinal.RegistroCurso;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jonathan.proyectofinal.R;




public class RegistroCurso extends AppCompatActivity implements View.OnClickListener{

    EditText nombre, codigo, correo;
    Button registro;
    Spinner opciones;
    String[] datos = {"Elige el curso" ,"pingPong", "Capoeira","Futbol","Baloncesto","Ballet","tenis"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_curso);
        opciones = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,datos);
        opciones.setAdapter(adaptador);
        nombre = (EditText) findViewById(R.id.txtNom);
        codigo = (EditText) findViewById(R.id.txtCod);
        correo = (EditText) findViewById(R.id.txtCorr);
        registro = (Button) findViewById(R.id.btnReg);




    }

    @Override
    public void onClick(View v) {
        registrarUsuarios();
    }

    public void registrarUsuarios() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this,"bd_cursos",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRES,nombre.getText().toString());
        values.put(Utilidades.CAMPO_CODIGO,codigo.getText().toString());
        values.put(Utilidades.CAMPO_CORREO,correo.getText().toString());


        Long resultante = db.insert(Utilidades.TABLA_CURSO,null,values);

        Toast.makeText(getApplicationContext(),"Registro Correcto ", Toast.LENGTH_SHORT).show();
    }
}
