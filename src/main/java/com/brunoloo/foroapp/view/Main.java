package com.brunoloo.foroapp.view;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Main extends JFrame {
    
    public Main() {
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Foro Central");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear barra de menú
        JMenuBar menuBar = new JMenuBar();
        
        // Menú Archivo
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem menuItemSalir = new JMenuItem("Salir");
        menuItemSalir.addActionListener(e -> dispose());
        menuArchivo.add(menuItemSalir);
        
        // Menú Usuarios
        JMenu menuUsuarios = new JMenu("Usuarios");
        JMenuItem menuItemListarUsuarios = new JMenuItem("Listar Usuarios");
        menuItemListarUsuarios.addActionListener(e -> 
            JOptionPane.showMessageDialog(Main.this, 
                "Funcionalidad de listar usuarios próximamente", 
                "Usuarios", 
                JOptionPane.INFORMATION_MESSAGE));
        menuUsuarios.add(menuItemListarUsuarios);
        
        // Menú Ayuda
        JMenu menuAyuda = new JMenu("Ayuda");
        JMenuItem menuItemAcercaDe = new JMenuItem("Acerca de");
        menuItemAcercaDe.addActionListener(e -> 
            JOptionPane.showMessageDialog(Main.this, 
                "Foro Central v1.0\nDesarrollado por Bruno", 
                "Acerca de", 
                JOptionPane.INFORMATION_MESSAGE));
        menuAyuda.add(menuItemAcercaDe);
        
        // Agregar menús a la barra
        menuBar.add(menuArchivo);
        menuBar.add(menuUsuarios);
        menuBar.add(menuAyuda);
        
        setJMenuBar(menuBar);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main mainFrame = new Main();
            mainFrame.setVisible(true);
        });
    }
}
