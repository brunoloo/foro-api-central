package com.brunoloo.foro_app_java.service.factory;

public class factory {
    private static factory instancia;
    private factory() {} // Constructor privado para evitar instanciación externa
    public static factory getInstance() {
        if (instancia == null) {
            instancia = new factory();
        }
        return instancia;
    }

    // Controladres 


}
