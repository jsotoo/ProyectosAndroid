package com.example.jonathan.parcial;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.jonathan.parcial.utilidades.Utilidades;

import java.util.ArrayList;

public class MostrarDatos extends AppCompatActivity {

    ListView listEmpleados;
    ArrayList<String> listaInformacion;
    ArrayList<Empleados> listaEmpleados;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        conn = new ConexionSQLiteHelper(getApplicationContext(),"bd_empleados",null,1);
        listEmpleados = (ListView) findViewById(R.id.listViewEmpleados);

        consultarListaPersonas();

        ArrayAdapter adaptador = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaInformacion);


        listEmpleados.setAdapter(adaptador);

        listEmpleados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String informacion = "Nombres: " +listaEmpleados.get(position).getNombres() + "\n";
                informacion += "Cargo: " +listaEmpleados.get(position).getCargo() + "\n";;
                informacion += "Empresa: " +listaEmpleados.get(position).getEmpresa() + "\n";;

                Toast.makeText(getApplicationContext(), informacion, Toast.LENGTH_LONG).show();
            }
        });
    }

        private void consultarListaPersonas(){
            SQLiteDatabase db = conn.getWritableDatabase();

            Empleados empleado = null;
            listaEmpleados = new ArrayList<Empleados>();
            //SELECT * FROM empleados
            Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_EMPLEADO, null);
            while(cursor.moveToNext()){
                empleado = new Empleados();
                empleado.setNombres(cursor.getString(0));
                empleado.setCargo(cursor.getString(1));
                empleado.setEmpresa(cursor.getString(2));


                listaEmpleados.add(empleado);

            }
            obtenerLista();
        }
        private void obtenerLista(){
            listaInformacion = new ArrayList<String>();
            for( int i=0; i<listaEmpleados.size();i++){
                listaInformacion.add( listaEmpleados.get(i).getNombres()+ "\n" +listaEmpleados.get(i).getCargo()+"\n"
                        + listaEmpleados.get(i).getEmpresa());
            }
        }

}
