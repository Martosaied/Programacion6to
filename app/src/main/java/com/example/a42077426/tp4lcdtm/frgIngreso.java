package com.example.a42077426.tp4lcdtm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.database.Cursor;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 42077426 on 13/6/2017.
 */
public class frgIngreso extends Fragment implements View.OnClickListener{
    Button BotIngreso;
    Button BotNuevo;
    View VistaADevolver;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        VistaADevolver=inflater.inflate(R.layout.formulario, container,false);
        BotIngreso=(Button) VistaADevolver.findViewById(R.id.BtnIngresar);
        BotNuevo=(Button) VistaADevolver.findViewById(R.id.BtnNuevo);
        BotNuevo.setOnClickListener(this);
        BotIngreso.setOnClickListener(this);
        return  VistaADevolver;
    }
    public void onClick(View v){

        MainActivity ActividadPrincipal;
        ActividadPrincipal = (MainActivity) getActivity();
        //IA TU SA|BE
        if (v.getId()== BotIngreso.getId()){
            EditText User = (EditText)VistaADevolver.findViewById(R.id.TxtUsuario);
            EditText Pass = (EditText)VistaADevolver.findViewById(R.id.TxtContrasena);
            if(Login(User.getText().toString(),Pass.getText().toString()))
            {
                ActividadPrincipal.Ingresar();
            }else{
                TextView txtError = (TextView)VistaADevolver.findViewById(R.id.txtError);
                txtError.setText("Usuario inexistente");
            }

        }else{
            ActividadPrincipal.Nuevo();
        }

    }

    public boolean Login(String Username , String Pass){
        boolean Existe = false;
        //MainActivity AP = new MainActivity();

        MainActivity AP;
        AP=(MainActivity) getActivity();

        boolean Exitoiso = AP.AccesoBD();
        if(Exitoiso){
            Cursor conjuntoDeRegistros;
            //EL INSERT NO FUNCIONA DE LA FORMA ANTERIOR Y TAMPOCO DE ESTA FORMA
            conjuntoDeRegistros = AP.baseDatos.rawQuery("select * from usuarios", null);
            if (conjuntoDeRegistros.moveToFirst()) {
                do{
                    String UsernameT = conjuntoDeRegistros.getString(0);
                    String Pass1 = conjuntoDeRegistros.getString(1);
                    if (Username.compareTo(UsernameT) == 0 && Pass.compareTo(Pass1) == 0) {
                        /*
                        Date d = new Date();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //Or whatever format fits best your needs.
                        String dateStr = sdf.format(d);
                        String strSQL = "UPDATE Usuarios SET fecha = "+ dateStr + " WHERE user = " + Username;
                        AP.baseDatos.execSQL(strSQL);
                        Existe = true;
                        break;*/
                    }

                } while (conjuntoDeRegistros.moveToNext());

            }
        }
        return Existe;
    }

}
