package com.example.a42077426.tp4lcdtm;

import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase baseDatos;
    FragmentManager AdminFragments;
    FragmentTransaction ElBanqueroPapu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdminFragments=getSupportFragmentManager();
        Fragment frgEntrar;
        frgEntrar= new LogoEmpresa();


        Log.d("MainActiviy","UN loggggggggggg wachinnnnnnnnnn(leo log)");
        ElBanqueroPapu=AdminFragments.beginTransaction();
        ElBanqueroPapu.replace(R.id.TheAlojator, frgEntrar);
        ElBanqueroPapu.commit();

    }
    public void Entrar(){
        Log.d("Main","Funciono el boton");
        Fragment frgForm;
        frgForm= new frgIngreso();
        ElBanqueroPapu=AdminFragments.beginTransaction();
        ElBanqueroPapu.replace(R.id.TheAlojator, frgForm);
        ElBanqueroPapu.commit();
    }

    public void Ingresar() {
        Log.d("Main","INGRESAR");
        Fragment frgIngresado;
        frgIngresado= new frgIngresado();
        ElBanqueroPapu=AdminFragments.beginTransaction();
        ElBanqueroPapu.replace(R.id.TheAlojator, frgIngresado);
        ElBanqueroPapu.commit();
    }
    public void Nuevo()
    {
        Log.d("Main","NUEVO");
        Fragment frgNuevo;
        frgNuevo= new frgNuevo();
        ElBanqueroPapu=AdminFragments.beginTransaction();
        ElBanqueroPapu.replace(R.id.TheAlojator, frgNuevo);
        ElBanqueroPapu.commit();
    }

    }
