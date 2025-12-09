package com.brunoloo.foro_app_java.service.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtils {

    //Recibe una contraseña en texto plano y retorna su hash en SHA-256.
    
    public static String hashPassword(String passwordPlana) {
        try {
            // Instanciamos el algoritmo SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            
            // Convertimos el string a bytes y aplicamos el hash
            byte[] encodedhash = digest.digest(passwordPlana.getBytes(java.nio.charset.StandardCharsets.UTF_8));
            
            // Convertimos el array de bytes a formato Hexadecimal (String legible)
            return bytesToHex(encodedhash);
            
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al inicializar algoritmo de hash", e);
        }
    }

    // Verifica si una contraseña plana coincide con un hash guardado.
   
    public static boolean verificarPassword(String passwordPlana, String hashGuardado) {
        String nuevoHash = hashPassword(passwordPlana);
        return nuevoHash.equals(hashGuardado);
    }

    // Método auxiliar privado para convertir bytes a Hexadecimal
    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }


}
