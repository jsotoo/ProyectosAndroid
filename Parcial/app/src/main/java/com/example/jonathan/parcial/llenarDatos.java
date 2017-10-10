package com.example.jonathan.parcial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class llenarDatos extends AppCompatActivity {

    ListView listviewEmpleados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_llenar_datos);
        listviewEmpleados = (ListView) findViewById(R.id.listEmpleados);
    }
}
