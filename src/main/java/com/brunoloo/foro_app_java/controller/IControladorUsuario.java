package com.brunoloo.foro_app_java.controller;

import com.brunoloo.foro_app_java.exceptions.UsuarioRepetidoException;

public interface IControladorUsuario {

    public abstract void registrarUsuario(String n) throws UsuarioRepetidoException;

}
