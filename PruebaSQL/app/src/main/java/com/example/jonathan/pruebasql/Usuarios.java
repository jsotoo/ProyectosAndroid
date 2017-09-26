package com.example.jonathan.pruebasql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jonathan on 21/09/2017.
 */

public class Usuarios extends SQLiteOpenHelper {
    String sqlCreate = "CREATE TABLE Usuarios (documento INTEGER,codigo INTEGER, nombre INTEGER)";

    public Usuarios(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int verAnt, int verNueva) {

        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        db.execSQL(sqlCreate);
    }

}
