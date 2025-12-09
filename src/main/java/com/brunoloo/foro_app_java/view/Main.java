package com.brunoloo.foro_app_java.view;

import com.brunoloo.foro_app_java.service.factory.Factory;
import com.brunoloo.foro_app_java.controller.IControladorUsuario;
import com.brunoloo.foro_app_java.view.User.viewRegistrarUsuario;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;



public class Main {
    
    // Controladores
    private static IControladorUsuario icu;

    // frames

    private JDesktopPane desktop;

    private viewRegistrarUsuario frameRegistrarUsuario;
    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Main().start();
                    System.out.println("Aplicación iniciada correctamente.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    private void start() {
        Factory factory = Factory.getInstance(); 
        icu = factory.geIControladorUsuario();

        createAndShow_mainFrame();
        // Crear frame registrar usuario
        frameRegistrarUsuario = new viewRegistrarUsuario(icu);
        frameRegistrarUsuario.setVisible(false);
        desktop.add(frameRegistrarUsuario);
        frameRegistrarUsuario.setBounds(10, 10, 500, 400);
        frameRegistrarUsuario.setClosable(true);
        frameRegistrarUsuario.setIconifiable(true);
    }

    private void createAndShow_mainFrame() {   
        // Crear el mainFrame (la ventana principal)
        JFrame mainFrame = new JFrame("Panel de Administración");
        mainFrame.getContentPane().setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        mainFrame.setSize(800, 600); // Tamaño inicial de la ventana
        
        desktop = new JDesktopPane();
        mainFrame.getContentPane().add(desktop, BorderLayout.CENTER);

        // barra de menú principal
        JMenuBar menuBar = new JMenuBar();

        // barra de menú: sistema | usuarios
        JMenu menuSistema = new JMenu("Sistema");
        JMenu menuUsuarios = new JMenu("Usuarios");

        // itmes de sistema
        JMenuItem itemSalir = new JMenuItem("Salir");

        // Añadir la acción al botón "Salir"
        itemSalir.addActionListener(e -> {
            System.exit(0);
        });

        // items de Usuarios
        JMenuItem RegistrarUsuario = new JMenuItem("Registrar Usuario");

        RegistrarUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frameRegistrarUsuario.setVisible(true);
            }
        });

        // Ensamblar todo
        mainFrame.setJMenuBar(menuBar); // Establecer la barra de menú en el frame
        
        menuBar.add(menuSistema);   // Añadir el menú "Sistema" a la barra de menú
        menuSistema.add(itemSalir); // Añadir el ítem "Salir" al menú "Sistema"
        
        menuBar.add(menuUsuarios);   // Añadir el menú "Usuarios" a la barra de menú
        menuUsuarios.add(RegistrarUsuario); // Añadir el ítem "Registrar Usuario" al menú "Usuarios"

        
        //Hacer visible la ventana y en el centro de la pantalla
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}