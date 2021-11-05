package com.alexandra.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityCliente extends AppCompatActivity {
    private String correo;
    private TextView saludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        saludo.findViewById(R.id.textCliente);
        correo = getIntent().getStringExtra("correo");
        saludo.setText("Hola! cómo estás hoy, cliente "+correo);
    }
}