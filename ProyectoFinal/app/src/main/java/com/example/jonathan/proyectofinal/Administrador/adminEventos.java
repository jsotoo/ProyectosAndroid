package com.example.jonathan.proyectofinal.Administrador;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jonathan.proyectofinal.R;
import com.example.jonathan.proyectofinal.RegistroCurso.ConexionSQLiteHelper;
import com.example.jonathan.proyectofinal.RegistroCurso.Curso;
import com.example.jonathan.proyectofinal.RegistroCurso.DbCon;
import com.example.jonathan.proyectofinal.RegistroCurso.Utilidades;
import com.example.jonathan.proyectofinal.RegistroEstudiante.Estudiante;

import java.util.ArrayList;

public class adminEventos extends AppCompatActivity {


    EditText nombre, codigo, correo;
    Button btnAdd;
    Spinner opciones;
    String[] datos = {"Elige el curso" ,"Tenis de mesa", "Capoeira","Futbol","Baloncesto","Ballet","Tenis"};
    ListView lst;
    DbCon dbcon;
    DbCon.DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_eventos);
        opciones = (Spinner) findViewById(R.id.spinnerCurso);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, datos);
        opciones.setAdapter(adaptador);
        nombre = (EditText) findViewById(R.id.nom);
        codigo = (EditText) findViewById(R.id.codi);
        correo = (EditText) findViewById(R.id.correo);
        btnAdd = (Button) findViewById(R.id.regBtn);
        dbcon = new DbCon(this);
        load();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    dbcon.insert(nombre.getText().toString(), codigo.getText().toString(), correo.getText().toString(), opciones.getSelectedItem().toString());
                    load();
                } catch (Exception e) {
    }
           }

      });
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor c = dbcon.selected(id);
                Intent intent = new Intent(adminEventos.this, mostrarDetallesCursos.class);
                String sendNombre = c.getString(1);
                String sendCodigo = c.getString(2);
                String sendCorreo = c.getString(3);
                String sendCurso = c.getString(4);
                String sendId = c.getString(0);
                intent.putExtra("sendNombre", sendNombre);
                intent.putExtra("sendCodigo", sendCodigo);
                intent.putExtra("sendCorreo", sendCorreo);
                intent.putExtra("sendCurso", sendCurso);
                intent.putExtra("sendId", sendId);
                startActivity(intent);
            }

        });


    }

    public void load() {
        Cursor cursor = null;
        try {
            dbcon.open();
            cursor = dbcon.readAll();
        } catch (Exception e) {

        }
        String[] de= new String[]{dbHelper.CAMPO_ID, dbHelper.CAMPO_NOMBRES, dbHelper.CAMPO_CODIGO,dbHelper.CAMPO_CORREO,dbHelper.CAMPO_CURSO};
        int[] para = new int[]{R.id.tvId, R.id.tvNombres, R.id.tvCodigo, R.id.tvCorreo,R.id.tvCurso};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(adminEventos.this, R.layout.showdetailsevents, cursor, de, para);
        adapter.notifyDataSetChanged();
        lst = (ListView) findViewById(R.id.list);
        lst.setAdapter(adapter);
    }



}
