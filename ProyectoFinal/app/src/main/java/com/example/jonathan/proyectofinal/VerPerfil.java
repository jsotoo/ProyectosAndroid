package com.example.jonathan.proyectofinal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.jonathan.proyectofinal.RegistroCurso.Utilidades;
import com.example.jonathan.proyectofinal.RegistroEstudiante.Estudiante;

public class VerPerfil extends AppCompatActivity {

    ConexionBD conn;
    EditText nombre, correo, usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_perfil);

        nombre = (EditText) findViewById(R.id.nomText);
        correo = (EditText) findViewById(R.id.correoText);
        usuario = (EditText) findViewById(R.id.userText);
    }
    private void mostrarDatos(){
        SQLiteDatabase db = conn.getReadableDatabase();
        Estudiante est = null;

    }
}
