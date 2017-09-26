package com.example.administrador.ejemplosqllite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrador on 14/09/2017.
 */
public class TbVentas extends SQLiteOpenHelper {
    String sqlCreate = "CREATE TABLE TBVENTAS(factura INTEGER, producto INTEGER, cantidad INTEGER, valor INTEGER)";

    public TbVentas(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS TbVentas");
        db.execSQL(sqlCreate);
    }
}
