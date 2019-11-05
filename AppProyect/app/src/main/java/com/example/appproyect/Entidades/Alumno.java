package com.example.appproyect.Entidades;

import java.io.Serializable;

public class Alumno implements Serializable {

    private Integer idalumno;
    private String nombrealumno;

    public Alumno(Integer idalumno, String nombrealumno) {
        this.idalumno = idalumno;
        this.nombrealumno = nombrealumno;
    }

    public Alumno(){

    }

    public Integer getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Integer idalumno) {
        this.idalumno = idalumno;
    }

    public String getNombrealumno() {
        return nombrealumno;
    }

    public void setNombrealumno(String nombrealumno) {
        this.nombrealumno = nombrealumno;
    }
}
