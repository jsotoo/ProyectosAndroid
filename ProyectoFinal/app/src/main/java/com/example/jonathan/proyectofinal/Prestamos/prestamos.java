package com.example.jonathan.proyectofinal.Prestamos;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import com.example.jonathan.proyectofinal.R;

public class prestamos extends AppCompatActivity implements View.OnClickListener {

    EditText fechaSol, fechaEnt, horaEnt,horaSol;
    Button fecSol, fecEnt, horEnt, horSol, prestamo;
    Spinner opciones;
    String[] datos = {"Elige el objeto" ,"Guitarra", "Maracas","Tambor","Flauta","Balón de futbol","Balón de baloncesto",
            "Balón de voleibol", "Raquetas de ping pong", "Raquetas de tenis", "Cartas", "Parqués", "Dominó"};

    private int dia,mes,ano,hora,minutos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos);
        opciones = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, datos);
        opciones.setAdapter(adaptador);
        fechaSol = (EditText) findViewById(R.id.txtFechaSol);
        fechaEnt = (EditText) findViewById(R.id.txtFechaEnt);
        horaEnt = (EditText) findViewById(R.id.txtHoraEnt);
        horaSol =(EditText) findViewById(R.id.txtHoraSol);
        fecEnt = (Button) findViewById(R.id.btnEntrega);
        fecSol = (Button) findViewById(R.id.btnSolicitud);
        horEnt = (Button) findViewById(R.id.btnHoraEntrega);
        horSol = (Button) findViewById(R.id.btnHoraSolicitud);
        prestamo = (Button) findViewById(R.id.btnPrestamo);
        prestamo.setOnClickListener(this);
        fecEnt.setOnClickListener(this);
        fecSol.setOnClickListener(this);
        horEnt.setOnClickListener(this);
        horSol.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == fecEnt){
            Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    fechaEnt.setText(dayOfMonth+"/"+ (month+1)+ "/" + year);
                }
            }
            ,ano,mes,dia);

            datePickerDialog.show();
        }
        if(v == fecSol){
            Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    fechaSol.setText(dayOfMonth+"/"+ (month+1)+ "/" + year);
                }
            }
                    ,ano,mes,dia);
            datePickerDialog.show();


        }
        if(v == horSol){
            final Calendar c =  Calendar.getInstance();
            hora = c.get(Calendar.HOUR_OF_DAY);
            minutos = c.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    horaSol.setText(hourOfDay + ":" +minute);
                }
            },hora,minutos,false);
            timePickerDialog.show();
        }
        if(v == horEnt){
            final Calendar c =  Calendar.getInstance();
            hora = c.get(Calendar.HOUR_OF_DAY);
            minutos = c.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    horaEnt.setText(hourOfDay + ":" +minute);
                }
            },hora,minutos,false);
            timePickerDialog.show();
        }

        if( v == prestamo){
            registrarPrestamo();
        }
    }


    private void registrarPrestamo(){
        if(fechaSol.getText().toString().isEmpty() || fechaEnt.getText().toString().isEmpty() || horaSol.getText().toString().isEmpty() || horaEnt.getText().toString().isEmpty()  || opciones.getSelectedItem().toString().equals("Elige el objeto")){
            Toast.makeText(getApplicationContext(),"Hay campos vacios o falta seleccionar el objeto",Toast.LENGTH_SHORT).show();
        }else {

            BDConexion conn = new BDConexion(this, "bd_prestamos", null, 1);
            SQLiteDatabase db = conn.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(Utilidades.FECHA_SOLICITUD, fechaSol.getText().toString());
            values.put(Utilidades.HORA_SOLICITUD, horaSol.getText().toString());
            values.put(Utilidades.FECHA_ENTREGA, fechaEnt.getText().toString());
            values.put(Utilidades.HORA_ENTREGA, horaEnt.getText().toString());
            values.put(Utilidades.CAMPO_CURSO, opciones.getSelectedItem().toString());

            Long Resultante = db.insert(Utilidades.CREAR_TABLA_PRESTAMO, Utilidades.FECHA_ENTREGA, values);
            Toast.makeText(getApplicationContext(), "Registro correcto", Toast.LENGTH_LONG).show();
            fechaSol.setText("");
            fechaEnt.setText("");
            horaSol.setText("");
            horaEnt.setText("");
        }
    }


}
