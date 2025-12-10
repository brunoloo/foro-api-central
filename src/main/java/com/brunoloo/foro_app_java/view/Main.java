package com.brunoloo.foro_app_java.view;

import com.brunoloo.foro_app_java.service.factory.Factory;
import com.brunoloo.foro_app_java.controller.IControladorUsuario;
import com.brunoloo.foro_app_java.view.User.viewListaUsuarios;
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
    private IControladorUsuario icu;

    // frames
    private JDesktopPane desktop;
    private viewRegistrarUsuario frameRegistrarUsuario;
    private viewListaUsuarios frameListaUsuarios;
    
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
        icu = factory.getIControladorUsuario();
        createAndShow_mainFrame();
    }

    private void createAndShow_mainFrame() {   

        // Crear el mainFrame (la ventana principal)
        JFrame mainFrame = new JFrame("Panel de Administración");
        mainFrame.getContentPane().setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        mainFrame.setSize(800, 600); // Tamaño inicial de la ventana
        
        // controlador desktop para manejar ventanas internas
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
        JMenuItem verUsuarios = new JMenuItem("Lista de Usuarios");

        // Añadir la acción al botón "Registrar Usuario"
        RegistrarUsuario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // LAZY LOADING: Solo la creamos si no existe
                if (frameRegistrarUsuario == null) {
                    frameRegistrarUsuario = new viewRegistrarUsuario(icu);
                    desktop.add(frameRegistrarUsuario);
                    frameRegistrarUsuario.setVisible(true);
                } else {
                // Si ya existe, solo la mostramos y la traemos al frente
                    frameRegistrarUsuario.setVisible(true);
                    frameRegistrarUsuario.toFront(); 
                }
            }
        });

        // Añadir la acción al botón "Lista de Usuarios"
        verUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // LAZY LOADING: Solo la creamos si no existe
                if (frameListaUsuarios == null) {
                    frameListaUsuarios = new viewListaUsuarios(icu);
                    desktop.add(frameListaUsuarios);
                    frameListaUsuarios.setVisible(true);
                } else {
                // Si ya existe, solo la mostramos y la traemos al frente
                    frameListaUsuarios.setVisible(true);
                    frameListaUsuarios.toFront(); 
                }
            }
        });


        // Ensamblar todo
        mainFrame.setJMenuBar(menuBar); // Establecer la barra de menú en el frame
        
        menuBar.add(menuSistema);   // Añadir el menú "Sistema" a la barra de menú
        menuSistema.add(itemSalir); // Añadir el ítem "Salir" al menú "Sistema"
        
        menuBar.add(menuUsuarios);   // Añadir el menú "Usuarios" a la barra de menú
        menuUsuarios.add(RegistrarUsuario); // Añadir el ítem "Registrar Usuario" al menú "Usuarios"
        menuUsuarios.add(verUsuarios); // Añadir el ítem "Lista de Usuarios" al menú "Usuarios"

        //Hacer visible la ventana y en el centro de la pantalla
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}