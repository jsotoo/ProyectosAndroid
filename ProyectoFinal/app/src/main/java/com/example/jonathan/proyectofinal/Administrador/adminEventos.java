package com.example.jonathan.proyectofinal.Administrador;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jonathan.proyectofinal.R;
import com.example.jonathan.proyectofinal.RegistroCurso.ConexionSQLiteHelper;
import com.example.jonathan.proyectofinal.RegistroCurso.Curso;
import com.example.jonathan.proyectofinal.RegistroCurso.Utilidades;
import com.example.jonathan.proyectofinal.RegistroEstudiante.Estudiante;

import java.util.ArrayList;

public class adminEventos extends AppCompatActivity {


    ListView listEvent;
    ArrayList<String> listaInfo;
    ArrayList<Curso> listCurso;
    ConexionSQLiteHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_eventos);

        conn = new ConexionSQLiteHelper(getApplicationContext(),"bd_cursos",null,1);
        listEvent = (ListView) findViewById(R.id.listEventos);

       consultarListaPersonas();

       ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaInfo);
        listEvent.setAdapter(adapter);
        listEvent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String name = parent.getItemAtPosition(position).toString();
              Toast.makeText(getApplicationContext(),"Tu seleccionaste la el item " + name ,Toast.LENGTH_LONG).show();
            }
       });

    }


    private void consultarListaPersonas(){
        SQLiteDatabase db = conn.getReadableDatabase();
        Curso curso = null;
        listCurso = new ArrayList<Curso>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_CURSO, null);
        while(cursor.moveToNext()){
            curso = new Curso();

            curso.setNombres(cursor.getString(0));
            curso.setCodigo(cursor.getString(1));
            curso.setCorreo(cursor.getString(2));
            curso.setCurso(cursor.getString(3));


            listCurso.add(curso);
        }

        obtenerLista();
    }
    private void obtenerLista(){
        listaInfo = new ArrayList<String>();
        for( int i=0; i< listCurso.size(); i++){
            listaInfo.add( listCurso.get(i).getNombres() + " - " + listCurso.get(i).getCodigo()
                    + " - " + listCurso.get(i).getCorreo() + " - " + listCurso.get(i).getCurso()  );
        }
    }





}
