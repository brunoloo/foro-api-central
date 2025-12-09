package com.brunoloo.foro_app_java.view.User;

import com.brunoloo.foro_app_java.controller.IControladorUsuario;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;


public class viewRegistrarUsuario extends JInternalFrame{

    private IControladorUsuario controlUsr;

    public viewRegistrarUsuario(IControladorUsuario icu) {
        controlUsr = icu;

        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Registrar usuario");
        setBounds(10, 10, 500, 400);
    }

}
