package com.example.jonathan.proyectofinal.Prestamos;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

import com.example.jonathan.proyectofinal.R;

public class prestamos extends AppCompatActivity implements View.OnClickListener {

    EditText fechaSol, fechaEnt, horaEnt,horaSol;
    Button fecSol, fecEnt, horEnt, horSol;
    private int dia,mes,ano,hora,minutos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestamos);
        fechaSol = (EditText) findViewById(R.id.txtFechaSol);
        fechaEnt = (EditText) findViewById(R.id.txtFechaEnt);
        horaEnt = (EditText) findViewById(R.id.txtHoraEnt);
        horaSol =(EditText) findViewById(R.id.txtHoraSol);
        fecEnt = (Button) findViewById(R.id.btnEntrega);
        fecSol = (Button) findViewById(R.id.btnSolicitud);
        horEnt = (Button) findViewById(R.id.btnHoraEntrega);
        horSol = (Button) findViewById(R.id.btnHoraSolicitud);
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
            ,dia,mes,ano);
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
                    ,dia,mes,ano);
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
    }
}
