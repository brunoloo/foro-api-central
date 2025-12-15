package com.brunoloo.foro_app_java.controller;

import com.brunoloo.foro_app_java.datatypes.DTUsuario;

import com.brunoloo.foro_app_java.exceptions.UsuarioNoExisteException;
import com.brunoloo.foro_app_java.exceptions.UsuarioRepetidoException;
import com.brunoloo.foro_app_java.exceptions.InvalidEmailException;
import com.brunoloo.foro_app_java.service.Usuario;
import com.brunoloo.foro_app_java.service.Manager.UserManager;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

// acá se implementaran los casos de uso de Usuario 

public class ControladorUsuario implements IControladorUsuario {

    private static ControladorUsuario instancia = null;

    public ControladorUsuario() {
    }
    
    public static ControladorUsuario getInstance() {
    if (instancia == null) {
      instancia = new ControladorUsuario();
    }
    return instancia;
  }

  @Override
  public void registrarUsuario(String nickname, String nombre, String email, String password, String descripcion, String urlImagen
) throws UsuarioRepetidoException, InvalidEmailException {
      UserManager usrManager = UserManager.getInstancia();
      if(usrManager.existeUsuario(nickname)){
        throw new UsuarioRepetidoException("El usuario: " + nickname + ", ya existe.");
      } else if(!esEmailValido(email)){
        throw new InvalidEmailException("Debe ingresar un email válido.");
      } else {
        Usuario nuevoUsr = new Usuario(nickname, nombre, email, password, descripcion, urlImagen);
        usrManager.addUsuario(nuevoUsr);
      }
  };

  @Override
  public DTUsuario verInfoUsuario(String nick) throws UsuarioNoExisteException { // nickname, nombre, email, desc, urlImagen
    UserManager manejadorusr = UserManager.getInstancia();
    Usuario usr = manejadorusr.obtenerUsuario(nick);

    if (usr != null) {
      // Obtener listas de seguidores y seguidos
      Set<String> seguidores = new HashSet<>();
      Set<String> seguidos = new HashSet<>();
      
      if (usr.getSeguidores() != null) {
        for (Usuario seguidor : usr.getSeguidores()) {
          seguidores.add(seguidor.getNickname());
        }
      }
      
      if (usr.getSeguidos() != null) {
        for (Usuario seguido : usr.getSeguidos()) {
          seguidos.add(seguido.getNickname());
        }
      }
      
      return new DTUsuario(usr.getNickname(), usr.getNombre(), usr.getEmail(), usr.getDesc(), usr.getUrlImagen());
    } else {
      throw new UsuarioNoExisteException("El usuario: " + nick + ", no existe.");
    }
  }
  
  @Override
  public List<DTUsuario> listarUsuarios() {
    UserManager manejadorUsr = UserManager.getInstancia();
    List<Usuario> usuarios = manejadorUsr.obtenerUsuarios();
    
    // 3. Crear una lista vacía para los DTOs
    List<DTUsuario> resultado = new ArrayList<>();
    
    // 4. Convertir cada Usuario (Entidad) a DTUsuario (Datos)
    for (Usuario u : usuarios) {
        DTUsuario dt = new DTUsuario(
            u.getNickname(),
            u.getNombre(),
            u.getEmail(),
            u.getDesc(),
            u.getUrlImagen() 
        );

        dt.setFechaRegistro(u.getFechaRegistro());
        
        resultado.add(dt);
    }
    
    return resultado;
  }

  @Override
  public Set<String> obtenerSeguidores(String nick) throws UsuarioNoExisteException {
    UserManager manejadorUsr = UserManager.getInstancia();
    Usuario usr = manejadorUsr.obtenerUsuario(nick);

    if(usr == null){
      throw new UsuarioNoExisteException("El usuario: " + nick + ", no existe.");
    }

    Set<Usuario> seguidores = usr.getSeguidores();

    Set<String> resultado = new HashSet<>();
    for(Usuario u : seguidores){
      resultado.add(u.getNickname());
    }
    return resultado;
  }

  @Override
  public Set<String> obtenerSeguidos(String nick) throws UsuarioNoExisteException {
    UserManager manejadorUsr = UserManager.getInstancia();
    Usuario usr = manejadorUsr.obtenerUsuario(nick);

    if(usr == null){
      throw new UsuarioNoExisteException("El usuario: " + nick + ", no existe.");
    }

    Set<Usuario> seguidos = usr.getSeguidos();
    
    Set<String> resultado = new HashSet<>();
    for (Usuario u : seguidos) {
        resultado.add(u.getNickname());
    }

    return resultado;
  }

  @Override
  public void eliminarUsuario(String nickname) throws UsuarioNoExisteException {
    UserManager manejadorUsr = UserManager.getInstancia();
    Usuario usr = manejadorUsr.obtenerUsuario(nickname);
    if(!manejadorUsr.existeUsuario(usr.getNickname())){
      throw new UsuarioNoExisteException("El usuario: " + nickname + ", no existe.");
    } else {
      manejadorUsr.eliminarUsuario(nickname);
    }
  }

  // Funciones axuiliares
  private boolean esEmailValido(String email) {
    if (email == null || email.isEmpty()) {
        return false;
    }
    
    // Esta expresión regular verifica:
    // 1. Caracteres permitidos al inicio
    // 2. Un arroba (@)
    // 3. Dominio
    // 4. Un punto (.)
    // 5. Extensión de al menos 2 letras (ej: .com, .uy, .org)
    String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(email);
    
    return matcher.matches();
  }


}
