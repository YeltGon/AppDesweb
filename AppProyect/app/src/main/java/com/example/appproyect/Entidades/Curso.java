package com.example.appproyect.Entidades;

import java.io.Serializable;

public class Curso implements Serializable {

    private Integer idcurso;
    private String nombrecurso;

    public Curso(Integer idcurso, String nombrecurso) {
        this.idcurso = idcurso;
        this.nombrecurso = nombrecurso;
    }
    public Curso(){

    }

    public Integer getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Integer idcurso) {
        this.idcurso = idcurso;
    }

    public String getNombrecurso() {
        return nombrecurso;
    }

    public void setNombrecurso(String nombrecurso) {
        this.nombrecurso = nombrecurso;
    }
}
