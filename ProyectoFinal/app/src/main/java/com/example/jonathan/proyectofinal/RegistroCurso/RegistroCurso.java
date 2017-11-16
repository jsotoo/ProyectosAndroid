package com.example.jonathan.proyectofinal.RegistroCurso;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jonathan.proyectofinal.Administrador.adminEventos;
import com.example.jonathan.proyectofinal.R;




public class RegistroCurso extends AppCompatActivity {

    EditText nombre, codigo, correo;
    Button registro;
    Spinner opciones;
    ListView listV;
    String[] datos = {"Elige el curso" ,"Tenis de mesa", "Capoeira","Futbol","Baloncesto","Ballet","Tenis"};
    DbCon dbcon;
    DbCon.DbHelper dbHelper;
    adminEventos adm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_curso);
        opciones = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, datos);
        opciones.setAdapter(adaptador);
        nombre = (EditText) findViewById(R.id.txtNom);
        codigo = (EditText) findViewById(R.id.txtCod);
        correo = (EditText) findViewById(R.id.txtCorr);
        registro = (Button) findViewById(R.id.btnReg);
        dbcon = new DbCon(this);




        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    dbcon.insert(nombre.getText().toString(), codigo.getText().toString(), correo.getText().toString(), opciones.getSelectedItem().toString());
                    load();
                }catch (Exception e){

                }

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
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(RegistroCurso.this, R.layout.showdetailsevents, cursor, de, para);
        adapter.notifyDataSetChanged();
        listV = (ListView) findViewById(R.id.list);
        listV.setAdapter(adapter);
    }









//    public void registrarUsuarios() {
//
//
//            ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_cursos", null, 1);
//            SQLiteDatabase db = conn.getWritableDatabase();
//
//            ContentValues values = new ContentValues();
//            values.put(Utilidades.CAMPO_NOMBRES, nombre.getText().toString());
//            values.put(Utilidades.CAMPO_CODIGO, codigo.getText().toString());
//            values.put(Utilidades.CAMPO_CORREO, correo.getText().toString());
//            values.put(Utilidades.CAMPO_CURSO, opciones.getSelectedItem().toString());
//
//
//            Long resultante = db.insert(Utilidades.TABLA_CURSO, null, values);
//
//
//            Toast.makeText(getApplicationContext(), "Registro Correcto ", Toast.LENGTH_SHORT).show();
//            nombre.setText("");
//            codigo.setText("");
//            correo.setText("");
//
//
//    }
}
