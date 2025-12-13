package com.brunoloo.foro_app_java.view;

import com.brunoloo.foro_app_java.service.factory.Factory;
import com.brunoloo.foro_app_java.controller.IControladorUsuario;
import com.brunoloo.foro_app_java.view.User.viewConsultarUsuario;
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
    private viewConsultarUsuario frameListaUsuarios;
    
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

        // barra de menú: sistema | usuarios | categorías | temas | comentarios | apelaciones
        JMenu menuSistema = new JMenu("Sistema");
        JMenu menuUsuarios = new JMenu("Usuarios");
        JMenu menuCategorias = new JMenu("Categorías");
        JMenu menuTema  = new JMenu("Temas");
        JMenu menuComentarios = new JMenu("Comentarios");
        JMenu menuApelaciones = new JMenu("Apelaciones");

        // itmes de Sistema
        JMenuItem itemSalir = new JMenuItem("Salir");
        
        // items de Usuarios
        JMenuItem RegistrarUsuario = new JMenuItem("Registrar Usuario");
        JMenuItem verUsuarios = new JMenuItem("Consulta de Usuarios");
        JMenuItem modificarUsuario = new JMenuItem("Modificar Usuario");
        JMenuItem eliminarUsuario = new JMenuItem("Eliminar Usuario");
        
        // items de Categorías
        JMenuItem registrarCategoria = new JMenuItem("Registrar Categoría");
        JMenuItem verCategorias = new JMenuItem("Consulta de categorías");
        JMenuItem modificarCategoria = new JMenuItem("Modificar Categoría");
        JMenuItem eliminarCategoria = new JMenuItem("Eliminar Categoría");
        JMenuItem modificarEstadoCategoria = new JMenuItem("Modificar Estado de Categoría");
        
        // items de Temas
        JMenuItem verTemas = new JMenuItem("Consulta de Temas");
        JMenuItem modificarTema = new JMenuItem("Modificar Tema");
        JMenuItem eliminarTema = new JMenuItem("Eliminar Tema");
        JMenuItem modificarEstadoTema = new JMenuItem("Modificar Estado de Tema");
        
        // items de Comentarios
        JMenuItem verComentarios = new JMenuItem("Consulta de Comentarios");
        JMenuItem eliminarComentario = new JMenuItem("Eliminar Comentario");
        JMenuItem modificarEstadoComentario = new JMenuItem("Modificar Estado de Comentario");
        JMenuItem comentariosVisibles = new JMenuItem("Comentarios Visibles por Usuario");
        
        // items de Apelaciones
        JMenuItem resolverApelacion = new JMenuItem("Resolver Apelación");
        
        // acciones de los botones del menú

        // Añadir la acción al botón "Salir" (Sistema)
        itemSalir.addActionListener(e -> {
            System.exit(0);
        });

        // Añadir la acción al botón "Registrar Usuario" (Usuarios)
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

        // Añadir la acción al botón "Consulta de usuarios" (Usuarios)
        verUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // LAZY LOADING: Solo la creamos si no existe
                if (frameListaUsuarios == null) {
                    frameListaUsuarios = new viewConsultarUsuario(icu);
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
        menuUsuarios.add(modificarUsuario); // Añadir el ítem "Modificar Usuario" al menú "Usuarios"
        menuUsuarios.add(eliminarUsuario); // Añadir el ítem "Eliminar Usuario" al menú "Usuarios"

        menuBar.add(menuCategorias);   // Añadir el menú "Categorías" a la barra de menú
        menuCategorias.add(registrarCategoria); // Añadir el ítem "Registrar Categoría" al menú "Categorías"
        menuCategorias.add(verCategorias); // Añadir el ítem "Consulta de categorías" al menú "Categorías"
        menuCategorias.add(modificarCategoria); // Añadir el ítem "Modificar Categoría" al menú "Categorías"
        menuCategorias.add(eliminarCategoria); // Añadir el ítem "Eliminar Categoría" al menú "Categorías"
        menuCategorias.add(modificarEstadoCategoria); // Añadir el ítem "Modificar Estado de Categoría" al menú "Categorías"

        menuBar.add(menuTema); // Añadir el menú "Temas" a la barra de menú
        menuTema.add(verTemas); // Añadir el ítem "Consulta de Temas" al menú "Temas"
        menuTema.add(modificarTema); // Añadir el ítem "Modificar Tema" al menú "Temas"
        menuTema.add(eliminarTema); // Añadir el ítem "Eliminar Tema" al menú "Temas"
        menuTema.add(modificarEstadoTema); // Añadir el ítem "Modificar Estado de Tema" al menú "Temas"

        menuBar.add(menuComentarios); // Añadir el menú "Comentarios" a la barra de menú
        menuComentarios.add(verComentarios); // Añadir el ítem "Consulta de Comentarios" al menú "Comentarios"
        menuComentarios.add(eliminarComentario); // Añadir el ítem "Eliminar Comentario" al menú "Comentarios"
        menuComentarios.add(modificarEstadoComentario); // Añadir el ítem "Modificar Estado de Comentario" al menú "Comentarios"
        menuComentarios.add(comentariosVisibles); // Añadir el ítem "Comentarios Visibles por Usuario" al menú "Comentarios"

        menuBar.add(menuApelaciones); // Añadir el menú "Apelaciones" a la barra de menú
        menuApelaciones.add(resolverApelacion); // Añadir el ítem "Resolver Apelación" al menú "Apelaciones"
        
        //Hacer visible la ventana y en el centro de la pantalla
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}