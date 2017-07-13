package com.example.a42077426.tp4lcdtm;
import android.util.Log;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 42077426 on 27/6/2017.
 */

public class baseMySql {
    Connection Conexion;
    private String conn() {
        try {
            Log.d("SelectUsuarios", "Proban3");
            Class.forName("com.mysql.jdbc.Driver");
            String RutaServidorMySql, NombreBaseDatos, NombreUsuario, PasswordUsuario, CadenaCompletaConexion;
            int PuertoServidor;
            RutaServidorMySql = "10.0.2.2";
            PuertoServidor = 3306;
            NombreBaseDatos = "db";
            NombreUsuario = "root";
            PasswordUsuario = "root";

            CadenaCompletaConexion = "jdbc:mysql://" + RutaServidorMySql + ":" + PuertoServidor + "/" + NombreBaseDatos;
            Conexion = DriverManager.getConnection(CadenaCompletaConexion, NombreUsuario, PasswordUsuario);
            Log.d("Conexion", "Se conecto");

            String todopeola = "Eh ameo te salio todo re cheto gatito";
            return  todopeola ;
        } catch (ClassNotFoundException e) {
            String Error = "Error"+e.getMessage();
            return  Error;
        } catch (SQLException e) {
            String Error = "Error"+e.getMessage();
            return  Error;
        }
    }
    public Thread Registrar = new Thread(){
        public void run(){
            try {
                String result = conn();
                if(result.compareTo("Eh ameo te salio todo re cheto gatito") == 0) {
                    Statement Instruccion = Conexion.createStatement();
                    String SQLLectura = "INSERT INTO `usuarios`(`Nombre`, `Contrasena`, `FechaIngreso`, `Commie`, `SoretePromCm`) VALUES ("+ Usuario.user.UserName+","+Usuario.user.Password+","+Usuario.user.FechaIngreso+","+Usuario.user.Commie+","+ Usuario.user.TamañoPromSorete+")";
                    Instruccion.executeQuery(SQLLectura);
                }
            }catch(SQLException e){
                Log.d("Insert", "Error: " + e.getMessage());
            }
        }
    };
    public ArrayList<Usuario> ListUsers = new ArrayList<>();
    public Thread Traer = new Thread(){
        public void run(){
            ListUsers = new ArrayList<>();
            try {
                String result = conn();
                if(result.compareTo("Eh ameo te salio todo re cheto gatito") == 0) {
                    Statement Instruccion = Conexion.createStatement();
                    String SQLLectura = "select * from usuarios";
                    ResultSet Resultados = Instruccion.executeQuery(SQLLectura);
                    if(Resultados.first()){
                        Usuario user = new Usuario();
                        user.Id = Resultados.getInt(1);
                        user.UserName = Resultados.getString(1);
                        user.Password = Resultados.getString(2);
                        user.FechaIngreso = Resultados.getString(3);
                        user.Commie = Resultados.getBoolean(4);
                        user.TamañoPromSorete = Resultados.getInt(5);
                        ListUsers.add(user);
                        while (Resultados.next()){
                            user.Id = Resultados.getInt(1);
                            user.UserName = Resultados.getString(2);
                            user.Password = Resultados.getString(3);
                            user.FechaIngreso = Resultados.getString(4);
                            user.Commie = Resultados.getBoolean(5);
                            user.TamañoPromSorete = Resultados.getInt(6);
                            ListUsers.add(user);
                        }
                    }else{
                        Log.d("SelectUsuarios", "No hay nada");
                    }
                }


            }catch(SQLException e){

            }
        }
    };
    public boolean LogInExito;
    public Thread LogIn = new Thread(){
        public void run(){
            LogInExito = false;
            try {
                String result = conn();
                if(result.compareTo("Eh ameo te salio todo re cheto gatito") == 0) {
                    Statement Instruccion = Conexion.createStatement();
                    String SQLLectura = "select * from usuarios WHERE Nombre = " + Usuario.user.UserName + "AND Contrasena = " + Usuario.user.Password;
                    ResultSet Resultados = Instruccion.executeQuery(SQLLectura);
                    if(Resultados.first()){
                        LogInExito = true;
                        int id = Resultados.getInt(1);
                        Date d = new Date();
                        Instruccion = Conexion.createStatement();
                        SQLLectura = "UPDATE `usuarios` SET `FechaIngreso`=" + d.toString() + " WHERE Id = " + id;
                        Instruccion.executeQuery(SQLLectura);
                    }else{
                        Log.d("SelectUsuarios", "No hay nada");
                    }
                }
            }catch(SQLException e){

            }
        }
    };
}
