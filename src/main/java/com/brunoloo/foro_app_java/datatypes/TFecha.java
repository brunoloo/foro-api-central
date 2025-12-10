package com.brunoloo.foro_app_java.datatypes;

import java.time.LocalDate;

public class TFecha {
    private int dia;
    private int mes;
    private int anio;
    
    
    public TFecha() {
    LocalDate hoy = LocalDate.now();
    this.dia = hoy.getDayOfMonth();
    this.mes = hoy.getMonthValue();
    this.anio = hoy.getYear();
    } // Constructor por defecto (fecha actual)   


    public TFecha(int dia, int mes, int anio) { // Constructor con parámetros
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    // Getters y Setters
    
    public int getDia() {
        return dia;
    }
    public void setDia(int dia) {
        this.dia = dia;
    }
    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }

}