package com.brunoloo.foro_app_java.controller;


/*
acá se implementaran los casos de uso de Usuario 
 */


public class ControladorUsuario implements IControladorUsuario {

    private static ControladorUsuario instancia = null;

    public ControladorUsuario() {
    }
    
    public static ControladorUsuario getInstance() {
    if (instancia == null) {
      instancia = new ControladorUsuario();
    }
    return instancia;
  }

    public void registrarUsuario(String n) {
        
    }
}
