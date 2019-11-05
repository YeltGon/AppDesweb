package com.example.appproyect.Utilidades;

public class Utilidades {

    public static final String TABLA_ALUMNO ="alumno" ;
    public static final String CAMPO_ID ="idalumno";
    public static final String CAMPO_NOMBRE="nombrealumno";

    public static final String CREAR_TABLA_ALUMNO="CREATE TABLE " +
            ""+TABLA_ALUMNO+" ("+CAMPO_ID+" " +
            "INTEGER, "+CAMPO_NOMBRE+" TEXT)";

    public static final String TABLA_GRADO ="grado" ;
    public static final String CAMPO_IDGRADO="idgrado";
    public static final String CAMPO_NOMBREGRADO="nombregrado";

    public static final String CREAR_TABLA_GRADO = "CREATE TABLE " +
            ""+TABLA_GRADO+"("+CAMPO_IDGRADO+""+
            "INTEGER,"+CAMPO_NOMBREGRADO+"TEXT)";


    public static final String TABLA_CURSO ="curso" ;
    public static final String CAMPO_IDCURSO ="idcurso";
    public static final String CAMPO_NOMBRECURSO="nombrecurso";

    public static final String CREAR_TABLA_CURSO="CREATE TABLE " +
            ""+TABLA_CURSO+" ("+CAMPO_IDCURSO+" " +
            "INTEGER, "+CAMPO_NOMBRECURSO+" TEXT)";



    public static final String TABLA_ASIGNACION ="asignacion" ;
    public static final String CAMPO_IDASIG="idasig";
    public static final String CAMPO_FECHASIG="fechasig";

    public static final String CREAR_TABLA_ASIGNACION ="CREATE TABLE " +
            ""+TABLA_ASIGNACION+"("+CAMPO_IDASIG+""+
            "INTEGER,"+CAMPO_FECHASIG+"DATE)";
}
