package com.brunoloo.foro_app_java.view.User;

import com.brunoloo.foro_app_java.controller.IControladorUsuario;
import com.brunoloo.foro_app_java.exceptions.UsuarioRepetidoException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class viewRegistrarUsuario extends JInternalFrame {

    // Controlador
    private IControladorUsuario controlUsr;

    // Componentes de la interfaz
    private JTextField txtNickname;
    private JTextField txtNombre;
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JPasswordField txtConfirmPassword;
    private JTextArea txtDescripcion; 
    private JButton btnRegistrar;
    private JButton btnCancelar;

    public viewRegistrarUsuario(IControladorUsuario icu) {
        // Inicialización básica del InternalFrame
        super("Registrar Nuevo Usuario", true, true, true, true);
        this.controlUsr = icu;
        
        // Configuración de la ventana
        setBounds(10, 10, 450, 450);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        // Inicializar componentes
        initGUI();
    }

    private void initGUI() {
        // Panel principal con márgenes
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // --- FILA 1: Nickname ---
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.weightx = 0; 
        mainPanel.add(new JLabel("Nickname (*):"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 0;
        gbc.weightx = 1.0; 
        txtNickname = new JTextField(20);
        mainPanel.add(txtNickname, gbc);

        // --- FILA 2: Nombre ---
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.weightx = 0;
        mainPanel.add(new JLabel("Nombre (*):"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.weightx = 1.0;
        txtNombre = new JTextField(20);
        mainPanel.add(txtNombre, gbc);

        // --- FILA 3: Email ---
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.weightx = 0;
        mainPanel.add(new JLabel("Email (*):"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.weightx = 1.0;
        txtEmail = new JTextField(20);
        mainPanel.add(txtEmail, gbc);

        // --- FILA 4: Contraseña ---
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.weightx = 0;
        mainPanel.add(new JLabel("Contraseña (*):"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 3;
        gbc.weightx = 1.0;
        txtPassword = new JPasswordField(20);
        mainPanel.add(txtPassword, gbc);

        // --- FILA 5: Confirmar Contraseña ---
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.weightx = 0;
        mainPanel.add(new JLabel("Repetir Contraseña:"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 4;
        gbc.weightx = 1.0;
        txtConfirmPassword = new JPasswordField(20);
        mainPanel.add(txtConfirmPassword, gbc);

        // --- FILA 6: Descripción (Opcional) ---
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST; 
        mainPanel.add(new JLabel("Biografía (Opcional):"), gbc);
        
        gbc.gridx = 1; gbc.gridy = 5;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0; 
        gbc.fill = GridBagConstraints.BOTH; 
        txtDescripcion = new JTextArea(4, 20);
        txtDescripcion.setLineWrap(true); 
        txtDescripcion.setWrapStyleWord(true);
        
        JScrollPane scrollDesc = new JScrollPane(txtDescripcion);
        mainPanel.add(scrollDesc, gbc);

        // --- FILA 7: Botones ---
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnCancelar = new JButton("Cancelar");
        btnRegistrar = new JButton("Registrar");
        
        buttonPanel.add(btnCancelar);
        buttonPanel.add(btnRegistrar);

        gbc.gridx = 0; gbc.gridy = 6;
        gbc.gridwidth = 2; 
        gbc.weighty = 0; 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(buttonPanel, gbc);

        this.setContentPane(mainPanel);

        configurarAcciones();
    }

    private void configurarAcciones() {
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
                setVisible(false); 
            }
        });

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsr();
            }
        });
    }

    private void registrarUsr() {
        // Obtener datos
        String nick = txtNickname.getText().trim();
        String nom = txtNombre.getText().trim();
        String email = txtEmail.getText().trim();
        String pass1 = new String(txtPassword.getPassword());
        String pass2 = new String(txtConfirmPassword.getPassword());
        String desc = txtDescripcion.getText().trim();

        // Validaciones básicas
        if (nick.isEmpty() || nom.isEmpty() || email.isEmpty() || pass1.isEmpty()) {
            // CAMBIO CLAVE: Usamos showInternalMessageDialog
            JOptionPane.showInternalMessageDialog(this.getDesktopPane(), 
                "Por favor complete todos los campos obligatorios (*).", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!pass1.equals(pass2)) {
            JOptionPane.showInternalMessageDialog(this.getDesktopPane(), 
                "Las contraseñas no coinciden.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (pass1.length() < 6) {
            JOptionPane.showInternalMessageDialog(this.getDesktopPane(), 
                "La contraseña debe tener al menos 6 caracteres.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Llamar al controlador
        try {
            controlUsr.registrarUsuario(nick, nom, email, pass1, desc, ""); 
            
            // Éxito
            JOptionPane.showInternalMessageDialog(this.getDesktopPane(), 
                "Usuario: " + nick + ", registrado con éxito.", 
                "Información", 
                JOptionPane.INFORMATION_MESSAGE);
                
            limpiarFormulario();

        } catch (UsuarioRepetidoException ex) {
            JOptionPane.showInternalMessageDialog(this.getDesktopPane(), 
                ex.getMessage(), 
                "Error de Registro", 
                JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showInternalMessageDialog(this.getDesktopPane(), 
                "Ocurrió un error inesperado: " + ex.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarFormulario() {
        txtNickname.setText("");
        txtNombre.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        txtConfirmPassword.setText("");
        txtDescripcion.setText("");
    }
}