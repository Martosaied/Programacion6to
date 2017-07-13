package com.example.a42077426.tp4lcdtm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
            Usuario.user.UserName = User.getText().toString();
            Usuario.user.Password = User.getText().toString();
            baseMySql MySql = new baseMySql();
            MySql.LogIn.start();
            if(MySql.LogInExito)
            {
                ActividadPrincipal.Ingresar();

            } else {
                TextView txtError = (TextView)VistaADevolver.findViewById(R.id.txtError);
                txtError.setText("Usuario inexistente");
            }

        }else{
            ActividadPrincipal.Nuevo();
        }

    }



}
