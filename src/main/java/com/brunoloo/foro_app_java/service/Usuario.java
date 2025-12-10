package com.brunoloo.foro_app_java.service;

import java.util.HashSet;
import java.util.Set;

import com.brunoloo.foro_app_java.datatypes.TFecha;
import com.brunoloo.foro_app_java.service.utils.PasswordUtils;
import com.brunoloo.foro_app_java.exceptions.InvalidPasswordException;

public class Usuario {
    private String nickname;
    private String nombre;
    private String email;
    private String passwordHash;
    private String desc;
    private TFecha fechaRegistro;
    private String urlImagen;
    private Set<Usuario> seguidores;
    private Set<Usuario> seguidos;

    public Usuario(String nickname, String nombre, String email, String passwordPlana, String desc, String urlImagen) { // constructor con parámetros
        this.nickname = nickname;
        this.nombre = nombre;
        this.email = email;
        this.setPassword(passwordPlana);
        this.desc = desc;
        this.fechaRegistro = new TFecha();
        this.urlImagen = urlImagen;
        this.seguidores = new HashSet<>();
        this.seguidos = new HashSet<>();
    }

    // Getters y Setters

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private void setPassword(String passwordPlana) {
        this.passwordHash = PasswordUtils.hashPassword(passwordPlana); // perdemos contraseña plana
    }

    // Verifica si la contraseña ingresada coincide con la almacenada
    public boolean esContraseniaValida(String passwordIngresada) {
        return PasswordUtils.verificarPassword(passwordIngresada, this.passwordHash); // verificamos con el hash guardado
    }

    /**
     * Permite cambiar la contraseña verificando primero la actual.
     * @param passwordActual La contraseña en texto plano que el usuario usa hoy.
     * @param nuevaPassword La nueva contraseña en texto plano que desea usar.
     * @throws InvalidPasswordException Si la contraseña actual es incorrecta.
     */
    public void cambiarContrasenia(String passwordActual, String nuevaPassword) throws InvalidPasswordException {
        // 1. Validar que la contraseña actual sea correcta
        if (!this.esContraseniaValida(passwordActual)) {
            throw new InvalidPasswordException("La contraseña actual es incorrecta.");
        }

        // 2. Validar que la nueva contraseña no sea vacía o nula (regla básica)
        if (nuevaPassword == null || nuevaPassword.trim().isEmpty()) {
            throw new InvalidPasswordException("La nueva contraseña no puede estar vacía.");
        }

        // 3. Validar que la nueva contraseña contenga al menos 6 caracteres
        if (nuevaPassword.length() < 6) {
            throw new InvalidPasswordException("La nueva contraseña debe tener al menos 6 caracteres.");
        }

        // 4. Validar que la nueva no sea igual a la vieja (Opcional, pero buena práctica)
        if (this.esContraseniaValida(nuevaPassword)) {
            throw new IllegalArgumentException("La nueva contraseña no puede ser igual a la actual.");
        }

        // 5. Si todo está bien, reutilizamos tu método privado existente
        this.setPassword(nuevaPassword);
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public TFecha getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(TFecha fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public void agregarSeguidor(Usuario usuario) {
        this.seguidores.add(usuario);
    }

    public void agregarSeguido(Usuario usuario) {
        this.seguidos.add(usuario);
    }

    public Set<Usuario> getSeguidores() {
        // Retornar una copia para evitar modificaciones externas
        return new HashSet<>(seguidores);
    }

    public Set<Usuario> getSeguidos() {
        // Retornar una copia para evitar modificaciones externas
        return new HashSet<>(seguidos);
    }
}
