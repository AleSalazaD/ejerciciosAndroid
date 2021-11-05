package com.alexandra.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private EditText correoInicio, contrasenaInicio;
    private Button btnInicio, btnRegistro;

    LinkedList<Usuarios> lista = Registro.listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        correoInicio = findViewById(R.id.editCorreoInicio);
        contrasenaInicio = findViewById(R.id.editContrasenaInicio);
        btnInicio = findViewById(R.id.btnIngresarInicio);
        btnRegistro = findViewById(R.id.btnRegistarInicio);

    }

    public void inicio(View view) {
        String correo = correoInicio.getText().toString();
        String contrasena = contrasenaInicio.getText().toString();

        for (int x = 0; x < lista.size(); x++) {
            if (contrasena.equals(lista.get(x).getContrasena()) && correo.equals(lista.get(x).getCorreo())) {
                Toast.makeText(this, "Sesión iniciada exitosamente", Toast.LENGTH_SHORT).show();
                if (lista.get(x) instanceof Cliente) {
                    //Toast.makeText(this, "Acceso exitoso", Toast.LENGTH_SHORT).show();
                    Intent intencion = new Intent(MainActivity.this, ActivityCliente.class);
                    intencion.putExtra("correo", lista.get(x).getCorreo());
                    startActivity(intencion);
                } else {
                    Intent intencion = new Intent(MainActivity.this, ActivityAdministrador.class);
                    intencion.putExtra("correo", lista.get(x).getCorreo());
                    startActivity(intencion);
                }
            } else {
                Toast.makeText(this, "Revise sus datos de acceso", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void registro(View view) {
        Toast.makeText(this, "Registrarse", Toast.LENGTH_SHORT).show();
        Intent intencion = new Intent(this, Registro.class);
        startActivity(intencion);
    }
}
