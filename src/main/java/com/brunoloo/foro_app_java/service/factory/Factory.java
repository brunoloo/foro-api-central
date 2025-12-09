package com.brunoloo.foro_app_java.service.factory;

import com.brunoloo.foro_app_java.controller.ControladorUsuario;
import com.brunoloo.foro_app_java.controller.IControladorUsuario;

public class Factory {
    private static Factory instancia;
    private Factory() {} // Constructor privado para evitar instanciación externa
    public static Factory getInstance() {
        if (instancia == null) {
            instancia = new Factory();
        }
        return instancia;
    }

    // Controladres 

    /**
   * Obtiene la instancia del controlador de usuarios.

   * @return IControladorUsuario
   */
    public IControladorUsuario geIControladorUsuario() {
        return ControladorUsuario.getInstance();
    }


}
