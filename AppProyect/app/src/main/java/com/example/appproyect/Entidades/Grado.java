package com.example.appproyect.Entidades;

import java.io.Serializable;

public class Grado implements Serializable {

    private Integer idgrado;
    private String nombregrado;

    public Grado(Integer idgrado, String nombregrado) {
        this.idgrado = idgrado;
        this.nombregrado = nombregrado;
    }

    public Grado(){

    }

    public Integer getIdgrado() {
        return idgrado;
    }

    public void setIdgrado(Integer idgrado) {
        this.idgrado = idgrado;
    }

    public String getNombregrado() {
        return nombregrado;
    }

    public void setNombregrado(String nombregrado) {
        this.nombregrado = nombregrado;
    }
}
