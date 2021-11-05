package com.alexandra.login;

public class Cliente extends Usuarios {
    private String ciudad;
    private int edad;

    public Cliente(String correo, String contrasena1, String contrasena2, String ciudad, int edad) {
        super(correo, contrasena1, contrasena2);
        this.ciudad = ciudad;
        this.edad = edad;


    }
}



