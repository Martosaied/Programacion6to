package com.example.a42077426.tp4lcdtm;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 42077426 on 13/6/2017.
 */

public class frgNuevo extends Fragment implements View.OnClickListener{

    View VistaADevolver;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        VistaADevolver=inflater.inflate(R.layout.formnuevo, container,false);
        Button BotAceptar;
        BotAceptar = (Button) VistaADevolver.findViewById(R.id.BtnReg);
        BotAceptar.setOnClickListener(this);
        return  VistaADevolver;
    }
    public void onClick(View v){
        EditText User = (EditText) VistaADevolver.findViewById(R.id.TxtUsuario);
        EditText Pass = (EditText) VistaADevolver.findViewById(R.id.TxtContrasena);
        EditText ConfirmPass = (EditText) VistaADevolver.findViewById(R.id.TxtReingresar);
        EditText TamañoSorete = (EditText) VistaADevolver.findViewById(R.id.TxtTamañoSorete);
        CheckBox Commie = (CheckBox)VistaADevolver.findViewById(R.id.ChbCommie);
        Usuario.user.UserName = User.getText().toString();
        Usuario.user.Password = Pass.getText().toString();

        Date d = new Date();
        Usuario.user.FechaIngreso = d.toString();
        Usuario.user.TamañoPromSorete = Integer.parseInt(TamañoSorete.getText().toString());
        Usuario.user.Commie = Commie.isChecked();


        baseMySql MySql = new baseMySql();
        MySql.Registrar.start();
        /*MainActivity ActividadPrincipal;
        ActividadPrincipal = (MainActivity) getActivity();
        if(ActividadPrincipal.AccesoBD()==true){
            EditText User = (EditText) VistaADevolver.findViewById(R.id.TxtUsuario);
            EditText Pass = (EditText) VistaADevolver.findViewById(R.id.TxtContrasena);
            if (passwordvalidation(Pass.getText().toString())){
                EditText RePass = (EditText) VistaADevolver.findViewById(R.id.TxtReingresar);
                if(Pass.getText().toString().compareTo(RePass.getText().toString())==0){
                    ContentValues NuevoRegistro;
                    NuevoRegistro = new ContentValues();
                    NuevoRegistro.put("User",User.getText().toString());
                    NuevoRegistro.put("Pass",Pass.getText().toString());
                    ActividadPrincipal.baseDatos.insert("Usuarios",null,NuevoRegistro);
                    ActividadPrincipal.Entrar();
                    Log.d("ESE CULITO", "FUNCA");
                }else{
                    TextView txtError = (TextView)VistaADevolver.findViewById(R.id.txtError);
                    txtError.setText("Contraseñas no coinciden");
                }
            }else{
                TextView txtError = (TextView)VistaADevolver.findViewById(R.id.txtError);
                txtError.setText("Contraseña no valida");
            }
        }*/
    }
    public boolean passwordvalidation (String pass){
        boolean Valido = false;
            String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
            if(pass.matches(pattern)){
                Valido = true;
        }
        return Valido;
    }

}
