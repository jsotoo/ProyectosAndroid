package com.example.administrador.ejemplosqllite;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class actIngresar extends AppCompatActivity implements View.OnClickListener {

    Button btnIngresar;
    EditText factura, codigo, cantidad, valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_ingresar);

        btnIngresar = (Button) findViewById(R.id.btnRegistrar);
        factura = (EditText) findViewById(R.id.numFactura);
        codigo = (EditText) findViewById(R.id.codProducto);
        cantidad = (EditText) findViewById(R.id.cantidad);
        valor = (EditText) findViewById(R.id.valor);
        btnIngresar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        TbVentas userDB = new TbVentas(this,"DBInventarios",null,1);
        SQLiteDatabase db = userDB.getWritableDatabase();
        if(db!=null){
            String fac = factura.getText().toString();
            String cod = codigo.getText().toString();
            String cant = cantidad.getText().toString();
            String val = valor.getText().toString();
            String conSQL = "INSERT INTO TbVentas VALUES(" + fac + "," + cod + "," + cant + "," + val + ")";
            db.execSQL(conSQL);
            db.close();
            Toast.makeText(getApplicationContext(),"Ingreso Correcto",Toast.LENGTH_LONG).show();

        }
        else{
            Toast.makeText(getApplicationContext(),"Error en BD",Toast.LENGTH_LONG).show();
        }
    }
}