package com.brunoloo.foro_app_java.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, Usuario> usuariosNickname;
    private Map<String, Usuario> usuariosEmail;

    private static UserManager instancia = null;

    // Constructor privado para el singleton
    private UserManager() {
        usuariosNickname = new HashMap<>();
        usuariosEmail = new HashMap<>();
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
    String email = user.getEmail();
    usuariosNickname.put(nickname, user);
    usuariosEmail.put(email, user);
  }
  
}
