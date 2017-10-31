package com.example.jonathan.proyectofinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.jonathan.proyectofinal.RegistroEstudiante.Estudiante;

/**
 * Created by Jonathan on 22/10/2017.
 */

public class ConexionBD extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "bd_estudiantes.db";
    private static final String TABLA_REGISTRO_ESTUDIANTES = "estudiantes";
    private static final String CAMPO_ESTUDIANTES_ID = "id";
    private static final String CAMPO_ESTUDIANTES_NOMBRES = "nombres";
    private static final String CAMPO_ESTUDIANTES_CORREO = "correo";
    private static final String CAMPO_ESTUDIANTES_USUARIO = "usuario";
    private static final String CAMPO_ESTUDIANTES_PASSWORD = "password";
    SQLiteDatabase db;

    private static final String CREAR_TABLA_ESTUDIANTES = "CREATE TABLE " + TABLA_REGISTRO_ESTUDIANTES+" ("
            +CAMPO_ESTUDIANTES_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CAMPO_ESTUDIANTES_NOMBRES +" TEXT, "
            + CAMPO_ESTUDIANTES_CORREO+ "  TEXT, " + CAMPO_ESTUDIANTES_USUARIO+ " TEXT, "
            + CAMPO_ESTUDIANTES_PASSWORD + " TEXT)";





    public ConexionBD(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREAR_TABLA_ESTUDIANTES);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_REGISTRO_ESTUDIANTES);
        this.onCreate(db);
    }

    public void insertarEstudiante(Estudiante est){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from estudiantes";
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(CAMPO_ESTUDIANTES_ID,count);
        values.put(CAMPO_ESTUDIANTES_NOMBRES, est.getNombre());
        values.put(CAMPO_ESTUDIANTES_CORREO, est.getCorreo());
        values.put(CAMPO_ESTUDIANTES_USUARIO, est.getUsuario());
        values.put(CAMPO_ESTUDIANTES_PASSWORD, est.getPassword());
        db.insert(TABLA_REGISTRO_ESTUDIANTES,null,values);
        db.close();
    }

    public String buscarPass(String usuario){
        db = this.getReadableDatabase();
        String query = "select " + CAMPO_ESTUDIANTES_USUARIO + ", " + CAMPO_ESTUDIANTES_PASSWORD + " from estudiantes";
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "No encontrado";
        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);


                if(a.equals(usuario))
                {
                    b = cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());
        }
        return b;
    }

}
