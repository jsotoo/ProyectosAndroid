package com.example.jonathan.parcial;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Jonathan on 10/10/2017.
 */
public class DataBaseManager {
    public static final String TABLE_NAME = "empleados";
    public static final String CN_NOMBRES = "nombres";
    public static final String CN_CARGO = "cargo";
    public static final String CN_EMPRESA ="empresa";

    public static final String CREATE_TABLE = "create table " +TABLE_NAME+ " ("
            + CN_NOMBRES + "text not null,"
            + CN_CARGO + "text not null,"
            + CN_EMPRESA + "text);";

    private DbHelper helper;
    private SQLiteDatabase db;

    public DataBaseManager(Context context) {
        helper = new DbHelper(context);
        db = helper.getWritableDatabase();
    }
    public ContentValues generarContentValues(String nombres,String cargo, String empresa){
        ContentValues valores = new ContentValues();
        valores.put(CN_NOMBRES, nombres);
        valores.put(CN_CARGO, cargo);
        valores.put(CN_EMPRESA, empresa);

        return valores;
    }
    public void insertar(String nombres, String cargo, String empresa){
        db.insert(TABLE_NAME,null,generarContentValues(nombres, cargo, empresa));
    }

}
