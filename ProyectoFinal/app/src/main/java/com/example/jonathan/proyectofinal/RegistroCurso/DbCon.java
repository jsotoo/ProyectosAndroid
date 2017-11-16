package com.example.jonathan.proyectofinal.RegistroCurso;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jonathan on 15/11/2017.
 */

public class DbCon {
    Context myContext;
    SQLiteDatabase db;
    DbHelper dbHelper;


    public DbCon(Context c) {
        myContext = c;
    }

    public DbCon open() {
        try {
            dbHelper = new DbHelper(myContext);
            db = dbHelper.getWritableDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return this;
        }
    }

    public void close() {
        db.close();
    }

    public void insert(String nombre, String codigo, String correo, String curso) {
        ContentValues values = new ContentValues();
        values.put(dbHelper.CAMPO_NOMBRES, nombre);
        values.put(dbHelper.CAMPO_CODIGO, codigo);
        values.put(dbHelper.CAMPO_CORREO, correo);
        values.put(dbHelper.CAMPO_CURSO, curso);
        db.insert(dbHelper.TABLA_CURSO, null, values);
    }

    public Cursor readAll() {
        String[] columns = new String[]{dbHelper.CAMPO_ID, dbHelper.CAMPO_NOMBRES, dbHelper.CAMPO_CODIGO, dbHelper.CAMPO_CORREO, dbHelper.CAMPO_CURSO};
        Cursor c = db.query(dbHelper.TABLA_CURSO, columns, null, null, null, null, dbHelper.CAMPO_ID + " desc");
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public Cursor selected(long id) {
        String[] columns = new String[]{dbHelper.CAMPO_ID, dbHelper.CAMPO_NOMBRES, dbHelper.CAMPO_CODIGO, dbHelper.CAMPO_CORREO, dbHelper.CAMPO_CURSO};
        Cursor c = db.query(dbHelper.TABLA_CURSO, columns, dbHelper.CAMPO_ID + "=" + id, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public void delete(long id) {
        open();
        db.delete(dbHelper.TABLA_CURSO, dbHelper.CAMPO_ID + "=" + id, null);
        close();
    }

    public void update(long id, String nombre, String codigo, String correo, String curso) {
        open();
        ContentValues values = new ContentValues();
        values.put(dbHelper.CAMPO_NOMBRES, nombre);
        values.put(dbHelper.CAMPO_CODIGO, codigo);
        values.put(dbHelper.CAMPO_CORREO, correo);
        values.put(dbHelper.CAMPO_CURSO, curso);

        db.update(dbHelper.TABLA_CURSO, values, dbHelper.CAMPO_ID + "=" + id, null);
        close();
    }

    public class DbHelper extends SQLiteOpenHelper {

        public static final String DB_NAME ="bd_cursos.db";
        public static final String TABLA_CURSO = "cursos";
        public static final String CAMPO_ID = "_id";
        public static final String CAMPO_NOMBRES = "nombres";
        public static final String CAMPO_CODIGO = "codigo";
        public static final String CAMPO_CORREO = "correo";
        public static final String CAMPO_CURSO = "curso";
        public static final String CREAR_TABLA_CURSO = "CREATE TABLE " + TABLA_CURSO + " ( " +CAMPO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +CAMPO_NOMBRES +" TEXT, "
                + CAMPO_CODIGO + " INTEGER, "+ CAMPO_CORREO + " TEXT, " +CAMPO_CURSO +" TEXT)";

        public static final int VERSION = 1;


        public DbHelper(Context context) {
            super(context, DB_NAME, null, VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREAR_TABLA_CURSO);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS" + TABLA_CURSO);
            onCreate(db);
        }
    }

}