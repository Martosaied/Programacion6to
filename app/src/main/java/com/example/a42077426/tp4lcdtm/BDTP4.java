package com.example.a42077426.tp4lcdtm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by devandroid on 15/6/2017.
 */

public class BDTP4 extends SQLiteOpenHelper {

    public BDTP4 (Context contexto, String Nombre, SQLiteDatabase.CursorFactory fabrica, int Version){
        super(contexto,Nombre,fabrica,Version);
        Log.d("Base", "-1");

    }
    @Override
    public void onCreate(SQLiteDatabase BaseDatos){
        Log.d("Base", "0");
        String sqlCrearTablaUsuarios;
        Log.d("Base", "1");
        sqlCrearTablaUsuarios = "create table Usuarios(user text, pass text, fecha text)";
        Log.d("Base", "2");
        BaseDatos.execSQL(sqlCrearTablaUsuarios);
        Log.d("Base", "3");

    }
    @Override
    public void onUpgrade(SQLiteDatabase BaseDatos, int versionAnterior, int VersionNueva){
        Log.d("BaseOnUp", "1");
        String SQLBorrarTabla="drop table usuarios";
        BaseDatos.execSQL(SQLBorrarTabla);
        Log.d("BaseOnUp", "2");
        String sqlCrearTablaUsuarios = "create table Usuarios(user text, pass text, fecha text)";
        Log.d("BaseOnUp", "3");
        BaseDatos.execSQL(sqlCrearTablaUsuarios);
        Log.d("BaseOnUp", "4");
    }
}
