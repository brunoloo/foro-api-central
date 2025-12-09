package com.brunoloo.foro_app_java.service;

import com.brunoloo.foro_app_java.datatypes.TFecha;
import com.brunoloo.foro_app_java.service.utils.PasswordUtils;

public class Usuario {
    private String nickname;
    private String nombre;
    private String email;
    private String passwordHash;
    private String desc;
    private TFecha fechaRegistro;
    private String urlImagen;

    public Usuario(String nickname, String nombre, String email, String password, String desc, TFecha fechaRegistro, String urlImagen) { // constructor con parámetros
        this.nickname = nickname;
        this.nombre = nombre;
        this.email = email;
        this.passwordHash = password;
        this.desc = desc;
        this.fechaRegistro = fechaRegistro;
        this.urlImagen = urlImagen;
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

    public void setPassword(String passwordPlana) {
        this.passwordHash = PasswordUtils.hashPassword(passwordPlana); // perdemos contraseña plana
    }

    public boolean esContraseniaValida(String passwordIngresada) {
        return PasswordUtils.verificarPassword(passwordIngresada, this.passwordHash); // verificamos con el hash guardado
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
}
