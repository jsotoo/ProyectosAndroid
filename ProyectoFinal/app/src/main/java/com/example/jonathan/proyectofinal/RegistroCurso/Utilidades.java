package com.example.jonathan.proyectofinal.RegistroCurso;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Jonathan on 30/10/2017.
 */

public class Utilidades {




    public void insert(String nombres, String codigo, String correo, String curso){
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRES,nombres);
        values.put(Utilidades.CAMPO_NOMBRES,nombres);
        values.put(Utilidades.CAMPO_NOMBRES,nombres);
        values.put(Utilidades.CAMPO_NOMBRES,nombres);

    }



    public static final String TABLA_CURSO = "cursos";
    public static final String CAMPO_ID = "Id";
    public static final String CAMPO_NOMBRES = "nombres";
    public static final String CAMPO_CODIGO = "codigo";
    public static final String CAMPO_CORREO = "correo";
    public static final String CAMPO_CURSO = "curso";



    public static final String CREAR_TABLA_CURSO = "CREATE TABLE " + "" + TABLA_CURSO +" ("+ CAMPO_NOMBRES +" TEXT, "+ CAMPO_CODIGO + " INTEGER,"+ CAMPO_CORREO+ " TEXT," +CAMPO_CURSO +" TEXT)";




}
