package com.example.a42077426.tp4lcdtm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by 42077426 on 13/6/2017.
 */

public class LogoEmpresa extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View VistaADevolver;
        VistaADevolver=inflater.inflate(R.layout.logoempresa, container,false);

        Button btnEntrar;
        btnEntrar = (Button)VistaADevolver.findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(this);
        return  VistaADevolver;
    }

    public void onClick(View VistaRecibida){
        MainActivity ActividadPrincipal;
        ActividadPrincipal = (MainActivity) getActivity();
        ActividadPrincipal.Entrar();
    }
}