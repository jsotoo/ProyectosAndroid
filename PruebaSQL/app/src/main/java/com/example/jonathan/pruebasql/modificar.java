package com.example.jonathan.pruebasql;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class modificar extends AppCompatActivity implements View.OnClickListener{

    EditText buscar, nombres, codigo;
    Button btBuscar,btActualizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);
        buscar= (EditText) findViewById(R.id.docBusc);
        nombres =(EditText) findViewById(R.id.nombText);
        codigo = (EditText) findViewById(R.id.codiText);
        btBuscar = (Button) findViewById(R.id.btnBuscar);
        btActualizar = (Button) findViewById(R.id.btnActualizar);
        btBuscar.setOnClickListener(this);
        btActualizar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnBuscar:
        String doc =buscar.getText().toString();
        String[] campos= new String[] {"documento", "codigo", "nombre"};
        String[] args = new String[]{doc};
        Usuarios userDB = new Usuarios(modificar.this,"DBUsuarios",null,1);
        SQLiteDatabase db = userDB.getWritableDatabase();
        Cursor c = db.query("Usuarios",campos,"documento=?",args, null, null, null);
        if(c.moveToFirst()){
            Toast.makeText(getApplicationContext(),"Encontrado",Toast.LENGTH_SHORT).show();
            codigo.setText(c.getString(1));
            nombres.setText(c.getString(2));

        }
        else{
            Toast.makeText(getApplicationContext(),"No Encontrado",Toast.LENGTH_SHORT).show();
        }
        break;

            case R.id.btnActualizar:
                Usuarios userD = new Usuarios(modificar.this,"DBUsuarios",null,1);
                SQLiteDatabase d = userD.getWritableDatabase();
                String docu =buscar.getText().toString();
                String cod = codigo.getText().toString();
                String nom = nombres.getText().toString();
                d.execSQL("UPDATE Usuarios SET codigo=" + cod + "," +
                        "nombre=" + nom + " WHERE documento=" + docu );
                Toast.makeText(getApplicationContext(),"Actualizado",Toast.LENGTH_LONG).show();
                d.close();
                break;
    }
    }
}
