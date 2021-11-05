package com.alexandra.login;

public class Administrador extends Usuarios {
    private String idAdministrador, dependencia;

    public Administrador(String correo, String contrasena1, String contrasena2, String idAdministrador, String dependencia) {
        super(correo, contrasena1, contrasena2);
        this.idAdministrador = idAdministrador;
        this.dependencia = dependencia;
    }
}


