package com.brunoloo.foro_app_java.view.User;

import com.brunoloo.foro_app_java.controller.IControladorUsuario;
import com.brunoloo.foro_app_java.datatypes.DTUsuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Collection;

public class viewConsultarUsuario extends JInternalFrame {

    // Controlador
    private IControladorUsuario controlUsr;

    // Componentes para la tabla
    private JTable tablaUsuarios;
    private DefaultTableModel modeloTabla;

    public viewConsultarUsuario(IControladorUsuario icu) {
        // Inicialización básica del InternalFrame
        super("Listado de Usuarios", true, true, true, true);
        this.controlUsr = icu;
        
        // Configuración de la ventana
        setBounds(10, 10, 600, 450); // Un poco más ancha para la tabla
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        // Inicializar componentes
        initGUI();
        
        // Cargar datos al iniciar
        cargarUsuarios();
    }

    private void initGUI() {
        // Panel principal con BorderLayout
        JPanel pnlPrincipal = new JPanel(new BorderLayout());
        
        // --- 1. Configuración de la Tabla ---
        // Definimos las columnas que queremos mostrar
        String[] columnas = {"Nickname", "Nombre", "Email"};
        
        // Creamos el modelo (los datos) y hacemos que NO sea editable
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Evita que el usuario edite las celdas directamente
            }
        };
        
        tablaUsuarios = new JTable(modeloTabla);
        
        // Agregamos la tabla dentro de un ScrollPane (para que tenga barras de desplazamiento)
        JScrollPane scroll = new JScrollPane(tablaUsuarios);
        pnlPrincipal.add(scroll, BorderLayout.CENTER);

        // --- 2. Panel de Botones (Abajo) ---
        JPanel pnlBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        JButton btnRecargar = new JButton("Recargar Lista");
        JButton btnCerrar = new JButton("Cerrar");

        // Acción Recargar
        btnRecargar.addActionListener(e -> cargarUsuarios());

        // Acción Cerrar
        btnCerrar.addActionListener(e -> setVisible(false));

        pnlBotones.add(btnRecargar);
        pnlBotones.add(btnCerrar);
        
        pnlPrincipal.add(pnlBotones, BorderLayout.SOUTH);

        // Agregamos todo al frame
        setContentPane(pnlPrincipal);
    }

    // --- Lógica para traer datos del controlador ---
    public void cargarUsuarios() {
        try {
            // 1. Limpiamos la tabla actual (para no duplicar filas si recargamos)
            modeloTabla.setRowCount(0);

            // 2. Pedimos la lista al controlador
            // (Asumo que tu método devuelve Collection, List o Set de DTUsuario)
            Collection<DTUsuario> lista = controlUsr.listarUsuarios();
            
            // 3. Verificamos si hay datos
            if (lista == null || lista.isEmpty()) {
                // Opcional: Mostrar mensaje en la barra de estado o dejar vacío
                return;
            }

            // 4. Recorremos la lista y agregamos filas a la tabla
            for (DTUsuario u : lista) {
                Object[] fila = {
                    u.getNickname(),
                    u.getNombre(),
                    u.getEmail()
                };
                modeloTabla.addRow(fila);
            }

        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(getDesktopPane(), 
                "Error al cargar usuarios: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}