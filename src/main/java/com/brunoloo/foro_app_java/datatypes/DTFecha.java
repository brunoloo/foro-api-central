package com.brunoloo.foro_app_java.datatypes;

public class DTFecha {
    private int dia;
    private int mes;
    private int anio;
    
    
    public DTFecha(){} // Constructor vacío

    public DTFecha(int dia, int mes, int anio) { // Constructor con parámetros
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
}