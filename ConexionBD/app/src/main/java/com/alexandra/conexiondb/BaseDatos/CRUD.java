package com.alexandra.conexiondb.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class CRUD extends DbConexion{
    private Context context;

    public CRUD(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public void Agregar(String nombre, String correo, String telefono){
        try{
            DbConexion dbConexion = new DbConexion(context);
            SQLiteDatabase db = dbConexion.getWritableDatabase();
            ContentValues datos = new ContentValues();
            datos.put("nombre", nombre);
            datos.put("correo", correo);
            datos.put("telefono", telefono);
            db.insert(TABLE_NAME, null, datos);
        }catch(Exception ex){
            ex.toString();
        }
    }
    public String Consultar(String id){

        try{
            DbConexion dbConexion = new DbConexion(context);
            SQLiteDatabase db = dbConexion.getWritableDatabase();

            Cursor cursor_Usuarios = null;
            cursor_Usuarios = db.rawQuery("SELECT * FROM "+ TABLE_NAME+ "WHERE id = '"+id+"'", null);
            if(cursor_Usuarios.moveToFirst()){
                String nombre = cursor_Usuarios.getString(1);
                String correo = cursor_Usuarios.getString(2);
                String telefono = cursor_Usuarios.getString(3);
                return nombre+ ","+correo+ ","+telefono;
                }
        }catch(Exception ex){
            ex.toString();
        }
        return null;
    }
    public void Actualizar(String id, String nombre, String correo, String telefono){
        try {
            DbConexion dbConexion = new DbConexion(context);
            SQLiteDatabase db = dbConexion.getWritableDatabase();

            ContentValues datos = new ContentValues();
            datos.put("nombre", nombre);
            datos.put("correo", correo);
            datos.put("telefono", telefono);
            db.update(TABLE_NAME, datos, "id=?", new String[]{id});
        }catch (Exception ex){
            ex.toString();
        }
    }
    public void Borrar(String id){
        try {
            DbConexion dbConexion = new DbConexion(context);
            SQLiteDatabase db = dbConexion.getWritableDatabase();
            db.delete(TABLE_NAME, "id=?", new String[]{id});
        }catch (Exception ex){
            ex.toString();
        }
    }
}
