package com.brunoloo.foro_app_java.controller;

import com.brunoloo.foro_app_java.exceptions.UsuarioRepetidoException;
import com.brunoloo.foro_app_java.exceptions.UsuarioNoExisteException;
import com.brunoloo.foro_app_java.exceptions.InvalidEmailException;

import java.util.Set;
import java.util.List;

import com.brunoloo.foro_app_java.datatypes.DTUsuario;

public interface IControladorUsuario {

    public abstract void registrarUsuario(String nickname, String nombre, String email, String password, String descripcion, String urlImagen ) throws UsuarioRepetidoException, InvalidEmailException;

    public abstract DTUsuario verInfoUsuario(String nick) throws UsuarioNoExisteException;

    public abstract List<DTUsuario> listarUsuarios();

    public abstract Set<String> obtenerSeguidores(String nick) throws UsuarioNoExisteException;

    public abstract Set<String> obtenerSeguidos(String nick) throws UsuarioNoExisteException;

}
