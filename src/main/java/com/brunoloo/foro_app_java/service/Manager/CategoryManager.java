package com.brunoloo.foro_app_java.service.Manager;

import com.brunoloo.foro_app_java.service.Categoria;

import java.util.ArrayList; 
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class CategoryManager {
    private Map<String, Categoria> categoriesName;
    
    private static CategoryManager instancia = null;

    // Constructor privado para el singleton
    private CategoryManager() {
        categoriesName = new HashMap<>();
    }

    // Método para obtener la instancia única del CategoryManager
    public static CategoryManager getInstancia() {
        if (instancia == null) {
            instancia = new CategoryManager();
        }
        return instancia;    
    }

}
