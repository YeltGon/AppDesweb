package com.example.appproyect.Entidades;

import java.io.Serializable;
import java.util.Date;

public class Asignacion implements Serializable {

    private Integer idasig;
    private Date fechasig;

    public Asignacion(Integer idasig, Date fechasig) {
        this.idasig = idasig;
        this.fechasig = fechasig;
    }

    public Asignacion(){

    }

    public Integer getIdasig() {
        return idasig;
    }

    public void setIdasig(Integer idasig) {
        this.idasig = idasig;
    }

    public Date getFechasig() {
        return fechasig;
    }

    public void setFechasig(Date fechasig) {
        this.fechasig = fechasig;
    }
}
