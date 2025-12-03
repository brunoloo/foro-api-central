package com.brunoloo.foro_app_java.datatypes;

public class DTUsuario {
    private String nickname;
    private String nombre;
    private String email;
    private String bibliografia;
    private String urlImagen;
    
    public DTUsuario(){} // constructor vacío

    public DTUsuario(String nickname, String nombre, String email, String urlImagen) { // constructor con parámetros
        this.nickname = nickname;
        this.nombre = nombre;
        this.email = email;
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

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}