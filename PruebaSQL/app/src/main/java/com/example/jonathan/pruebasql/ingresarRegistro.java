package com.example.jonathan.pruebasql;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ingresarRegistro extends AppCompatActivity {

    EditText documento, nombre, codigo;
    Button btInsertar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_registro);
        documento = (EditText) findViewById(R.id.docuText);
        nombre = (EditText) findViewById(R.id.nomText);
        codigo = (EditText) findViewById(R.id.codText);
        btInsertar = (Button) findViewById(R.id.btnInsertar);
        btInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuarios userDB = new Usuarios(ingresarRegistro.this,"DBUsuarios",null,1);
                SQLiteDatabase db = userDB.getWritableDatabase();
                if(db!=null){
                    String doc = documento.getText().toString();
                    String nom = nombre.getText().toString();
                    String cod = codigo.getText().toString();

                    String conSQL = "INSERT INTO Usuarios(documento,codigo,nombre) VALUES(" + doc + "," + cod + "," + nom + ")";
                    db.execSQL(conSQL);
                    db.close();
                    Toast.makeText(getApplicationContext(),"Ingreso Correcto",Toast.LENGTH_LONG).show();

                }
            }
        });


    }
}
