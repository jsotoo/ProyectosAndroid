package com.example.jonathan.proyectofinal.RegistroCurso;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Jonathan on 30/10/2017.
 */

public class ConexionSQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLA_CURSO = "cursos";
    public static final String CAMPO_ID = "Id";
    public static final String CAMPO_NOMBRES = "nombres";
    public static final String CAMPO_CODIGO = "codigo";
    public static final String CAMPO_CORREO = "correo";
    public static final String CAMPO_CURSO = "curso";
    SQLiteDatabase db;



    public static final String CREAR_TABLA_CURSO = "CREATE TABLE " + "" + TABLA_CURSO +" ("+CAMPO_ID + "INTEGER PRIMARY KEY AUTOINCREMENT " +CAMPO_NOMBRES +" TEXT, "+ CAMPO_CODIGO + " INTEGER,"+ CAMPO_CORREO+ " TEXT," +CAMPO_CURSO +" TEXT)";

    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_CURSO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS cursos");
        onCreate(db);
    }








}
