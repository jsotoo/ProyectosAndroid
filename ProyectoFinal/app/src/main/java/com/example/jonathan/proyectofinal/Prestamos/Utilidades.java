package com.example.jonathan.proyectofinal.Prestamos;

/**
 * Created by Jonathan on 16/11/2017.
 */

public class Utilidades {
    public static final String TABLA_PRESTAMO = "cursos";
    public static final String FECHA_SOLICITUD = "fecSol";
    public static final String HORA_SOLICITUD = "horSol";
    public static final String FECHA_ENTREGA = "fecEnt";
    public static final String HORA_ENTREGA = "horEnt";
    public static final String CAMPO_CURSO = "curso";



    public static final String CREAR_TABLA_PRESTAMO = "CREATE TABLE " + "" + TABLA_PRESTAMO +" ("+ FECHA_SOLICITUD +" TEXT, "+ HORA_SOLICITUD + " TEXT, " +
            FECHA_ENTREGA + " TEXT, " + HORA_ENTREGA + " TEXT, " + CAMPO_CURSO + " TEXT )";

}
