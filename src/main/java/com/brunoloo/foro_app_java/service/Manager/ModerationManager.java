package com.brunoloo.foro_app_java.service.Manager;

import com.brunoloo.foro_app_java.service.Apelacion;
import com.brunoloo.foro_app_java.service.Reporte;

import java.util.ArrayList; 
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ModerationManager {
    private Map<String, Apelacion> apelacionID;
    private Map<String, Reporte> reporteID;
    
    private static ModerationManager instancia = null;

    // Constructor privado para el singleton
    private ModerationManager() {
        apelacionID = new HashMap<>();
        reporteID = new HashMap<>();
    }

    // Método para obtener la instancia única del ModerationManager
    public static ModerationManager getInstancia() {
        if (instancia == null) {
            instancia = new ModerationManager();
        }
        return instancia;    
    }

  
}
