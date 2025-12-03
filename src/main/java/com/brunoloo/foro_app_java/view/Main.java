package com.brunoloo.foro_app_java.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
       
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    createAndShow_mainFrame();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void createAndShow_mainFrame() {   
        
        // 1. Crear el mainFrame (la ventana principal)
        JFrame mainFrame = new JFrame("Panel de Administración");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        mainFrame.setSize(800, 600); // Tamaño inicial de la ventana

        // 2. Crear la barra de menú
        JMenuBar menuBar = new JMenuBar();

        // 3. Crear el menú "Sistema"
        JMenu menuSistema = new JMenu("Sistema");

        // 4. Crear el ítem "Salir" del menú
        JMenuItem itemSalir = new JMenuItem("Salir");

        // 5. Añadir la acción al botón "Salir"
        itemSalir.addActionListener(e -> {
            System.exit(0);
        });

        // 6. Ensamblar todo
        menuSistema.add(itemSalir); // Añadir el ítem "Salir" al menú "Sistema"
        menuBar.add(menuSistema);   // Añadir el menú "Sistema" a la barra de menú
        mainFrame.setJMenuBar(menuBar); // Establecer la barra de menú en el frame

        // 7. Hacer visible la ventana (¡muy importante!)
        // Se recomienda ponerlo en el centro de la pantalla
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}