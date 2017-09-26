package com.example.administrador.ejemplosqllite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class actEliminar extends AppCompatActivity {

    EditText txtEliminar;
    Button btnEliminar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_eliminar);

        txtEliminar = (EditText) findViewById(R.id.facEliminar);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TbVentas userDB = new TbVentas(actEliminar.this,"DBInventarios",null,1);
                SQLiteDatabase db = userDB.getWritableDatabase();
                db.execSQL("DELETE FROM TbVentas WHERE factura = " + txtEliminar.getText());
                db.close();
                Toast.makeText(getApplicationContext(),"Factura Eliminada",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
