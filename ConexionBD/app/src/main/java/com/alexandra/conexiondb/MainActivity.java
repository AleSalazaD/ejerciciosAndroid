package com.alexandra.conexiondb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.alexandra.conexiondb.BaseDatos.CRUD;

public class MainActivity extends AppCompatActivity {
    private EditText ed_Nombre, ed_Correo, ed_Telefono, ed_Id;
    private static CRUD crud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_Nombre = findViewById(R.id.edNombre);
        ed_Correo = findViewById(R.id.edCorreo);
        ed_Telefono = findViewById(R.id.edTelefono);
        ed_Id = findViewById(R.id.edId);

        crud = new CRUD(MainActivity.this);
        SQLiteDatabase db = crud.getWritableDatabase();
        if(db != null){
            Toast.makeText(MainActivity.this, "Base de datos creada", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this, "No se creó la base de datos", Toast.LENGTH_LONG).show();
        }
    }
    public void Agregar(View view){
        String nombre = ed_Nombre.getText().toString();
        String correo = ed_Correo.getText().toString();
        String telefono = ed_Telefono.getText().toString();
        crud.Agregar(nombre, correo, telefono);
        //Toast.makeText(MainActivity.this, "Usuario agregado", Toast.LENGTH_SHORT).show();
    }

    public void Consultar(View view){
        String id = ed_Id.getText().toString();
        String datos = crud.Consultar(id);
        Toast.makeText(MainActivity.this, datos, Toast.LENGTH_LONG).show();
    }

    public void Actualizar(View view){
        String id = ed_Id.getText().toString();
        String nombre = ed_Nombre.getText().toString();
        String correo = ed_Correo.getText().toString();
        String telefono = ed_Telefono.getText().toString();
        crud.Actualizar(id, nombre, correo, telefono);
        //Toast.makeText(MainActivity.this, "Usuario actualizado", Toast.LENGTH_SHORT).show();
    }

    public void Borrar(View view){
        String id = ed_Id.getText().toString();
        crud.Borrar(id);
        //Toast.makeText(MainActivity.this, "Usuario eliminado", Toast.LENGTH_SHORT).show();
    }
}