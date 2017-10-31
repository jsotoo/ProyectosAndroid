package com.example.jonathan.parcial.utilidades;

/**
 * Created by Jonathan on 10/10/2017.
 */

public class Utilidades {

    //Constantes campos tabla Empleado
    public static final String TABLA_EMPLEADO = "empleados";
    public static final String CAMPO_NOMBRES = "nombres";
    public static final String CAMPO_CARGO = "cargo";
    public static final String CAMPO_EMPRESA = "empresa";



    public static final String CREAR_TABLA_EMPLEADOS = "CREATE TABLE " + "" + TABLA_EMPLEADO+" ("+CAMPO_NOMBRES
            +" TEXT, "+ CAMPO_CARGO+ "  TEXT,"+ CAMPO_EMPRESA+ " TEXT)";

}
