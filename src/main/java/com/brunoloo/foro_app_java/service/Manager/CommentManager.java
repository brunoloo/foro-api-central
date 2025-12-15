package com.brunoloo.foro_app_java.service.Manager;

import com.brunoloo.foro_app_java.service.Comentario;

import java.util.ArrayList; 
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class CommentManager {
    private Map<String, Comentario> CommentID;
    
    private static CommentManager instancia = null;

    // Constructor privado para el singleton
    private CommentManager() {
        CommentID = new HashMap<>();
    }

    // Método para obtener la instancia única del ComentManager
    public static CommentManager getInstancia() {
        if (instancia == null) {
            instancia = new CommentManager();
        }
        return instancia;    
    }

  
}
