package com.alexandra.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.LinkedList;

public class Registro extends AppCompatActivity {
    private String correo, contrasena, contrasena2, ciudad, idAdminstrador, dependencia;
    private int edad;
    private EditText correoReg, contrasenaReg, contrasenareg2;
    private Switch swrolReg;
    private Button atras, registro;

    public static LinkedList<Usuarios> listaUsuarios = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        correoReg = findViewById(R.id.txtEditEmailReg);
        contrasenaReg = findViewById(R.id.txtEditContrasena1Reg);
        contrasenareg2 = findViewById(R.id.txtEditContrasena2Reg);
        swrolReg = findViewById(R.id.swtTipoReg);
        atras = findViewById(R.id.btnAtrasReg);
        registro = findViewById(R.id.btnRegistroReg);
    }

    public void atras(View view) {
        Toast.makeText(Registro.this, "Atrás", Toast.LENGTH_SHORT).show();
        Intent intencion = new Intent(Registro.this, MainActivity.class);
        startActivity(intencion);
    }

    public void registro(View view) {
        correo = correoReg.getText().toString();
        contrasena = contrasenaReg.getText().toString();
        contrasena2 = contrasenareg2.getText().toString();

        if (contrasena.equals(contrasena2) && correo.contains("@") && correo.contains(".") && contrasena.length() > 3) {
                if (swrolReg.isChecked()) {
                    Usuarios cliente = new Cliente(correo, contrasena, contrasena2, ciudad, edad);
                    listaUsuarios.add(cliente);

                } else {
                    Usuarios administrador = new Administrador(correo, contrasena, contrasena2, idAdminstrador, dependencia);
                    listaUsuarios.add(administrador);
                }

            Toast.makeText(Registro.this, "Listo el registro!", Toast.LENGTH_SHORT).show();
            correoReg.setText(null);
            contrasenaReg.setText(null);
            contrasenareg2.setText(null);
        }
        else {
            //Toast.makeText(Registro.this, "No es posible el registro", Toast.LENGTH_SHORT).show();

            //*******Toast de prueba******
            Toast.makeText(Registro.this, listaUsuarios.get(0).toString(), Toast.LENGTH_SHORT).show();
            /*if(listaUsuarios.get(0) instanceof Cliente){
                Toast.makeText(Registro.this, "Es un cliente", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(Registro.this, "Es un Administrador", Toast.LENGTH_SHORT).show();
            }*/

            correoReg.setText(null);
            contrasenaReg.setText(null);
            contrasenareg2.setText(null);

        }
    }
}