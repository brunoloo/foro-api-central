package com.brunoloo.foro_app_java.service.Manager;

import com.brunoloo.foro_app_java.service.Tema;

import java.util.ArrayList; 
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class TopicManager {
    private Map<String, Tema> temaID;
    
    private static TopicManager instancia = null;

    // Constructor privado para el singleton
    private TopicManager() {
        temaID = new HashMap<>();
    }

    // Método para obtener la instancia única del ContentManager
    public static TopicManager getInstancia() {
        if (instancia == null) {
            instancia = new TopicManager();
        }
        return instancia;    
    }

}