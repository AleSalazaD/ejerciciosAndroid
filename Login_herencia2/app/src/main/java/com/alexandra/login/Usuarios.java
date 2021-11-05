package com.alexandra.login;

import java.util.LinkedList;

public class Usuarios {
    private String correo, contrasena, contrasena2;

    public Usuarios(String correo, String contrasena, String contrasena2) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.contrasena2 = contrasena2;
    }

    public Usuarios(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getCorreo() {return correo;}

    public String getContrasena() {return contrasena;}

    public String getContrasena2() {return contrasena2;}

    @Override
    public String toString() {
        return "Usuarios{" +
                "correo='" + correo + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}


