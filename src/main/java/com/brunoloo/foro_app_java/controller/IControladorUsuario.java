package com.brunoloo.foro_app_java.controller;

import com.brunoloo.foro_app_java.exceptions.UsuarioRepetidoException;
import com.brunoloo.foro_app_java.exceptions.UsuarioNoExisteException;

import java.util.Set;
import java.util.List;

import com.brunoloo.foro_app_java.datatypes.DTUsuario;

public interface IControladorUsuario {

    public void registrarUsuario(
          String nickname, 
          String nombre, 
          String email, 
          String password, 
          String descripcion, 
          String urlImagen ) 
          throws UsuarioRepetidoException;

    public DTUsuario verInfoUsuario(String nick) throws UsuarioNoExisteException;

    public List<DTUsuario> listarUsuarios();

    public Set<String> obtenerSeguidores(String nick) throws UsuarioNoExisteException;

    public Set<String> obtenerSeguidos(String nick) throws UsuarioNoExisteException;

}
