package com.brunoloo.foro_app_java.service;

import java.util.Collection;
import java.util.ArrayList; 
import java.util.List;
import java.util.HashMap;
import java.util.Map;

// Clase para gestionar los usuarios en memoria
public class UserManager {
    private Map<String, Usuario> usuariosNickname;

    private static UserManager instancia = null;

    // Constructor privado para el singleton
    private UserManager() {
        usuariosNickname = new HashMap<>();
    }

    // Método para obtener la instancia única del UserManager
    public static UserManager getInstancia() {
        if (instancia == null) {
            instancia = new UserManager();
        }
        return instancia;    
    }

    /**
   * Agrega un usuario al sistema.

   * @param user el usuario a agregar
   */
    public void addUsuario(Usuario user) {
    String nickname = user.getNickname();
    usuariosNickname.put(nickname.toLowerCase(), user); // guardo los nickname en minúsculas para evitar problemas de mayúsculas/minúsculas
  }
  
  /**
   * Obtiene un usuario por su nickname.

   * @param nick el nickname del usuario
   * @return el usuario correspondiente o null si no existe
   */
  public Usuario obtenerUsuario(String nick) {
    return usuariosNickname.get(nick.toLowerCase());
  }

    /**
     * Obtiene todos los usuarios registrados.
    
     * @return una colección de todos los usuarios
     */  
    public List<Usuario> obtenerUsuarios() {
        // Convertir la colección de valores del mapa a una lista y retornarla
        return new ArrayList<>(usuariosNickname.values());
    }
}
