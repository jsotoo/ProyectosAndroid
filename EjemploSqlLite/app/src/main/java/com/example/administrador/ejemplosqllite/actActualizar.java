package com.example.administrador.ejemplosqllite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class actActualizar extends AppCompatActivity {

    EditText buscar,producto, cantidad, valor;
    Button btnBuscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_actualizar);

        buscar = (EditText) findViewById(R.id.factBusc);
        producto = (EditText) findViewById(R.id.productText);
        cantidad = (EditText) findViewById(R.id.cantText);
        valor = (EditText) findViewById(R.id.valText);
        btnBuscar = (Button) findViewById(R.id.btBuscar);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fac = buscar.getText().toString();
                String[] campos = new String[] {"factura","producto","cantidad","valor"};
                String[] argr = new String[] {fac};
                TbVentas userDB = new TbVentas(actActualizar.this,"DBInventarios",null,1);
                SQLiteDatabase db = userDB.getWritableDatabase();

                Cursor c = db.query("TbVentas",campos,"factura=?",argr,null,null,null,null);

                if(c.moveToFirst()){
                    producto.setText( c.getString(1));
                    cantidad.setText(c.getString(2));
                    valor.setText(c.getString(3));
                }
            }
        });

    }
}
