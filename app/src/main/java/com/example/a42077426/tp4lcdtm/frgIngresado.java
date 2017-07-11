package com.example.a42077426.tp4lcdtm;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.DragAndDropPermissions;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by devandroid on 15/6/2017.
 */

public class frgIngresado extends Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View VistaADevolver;
        VistaADevolver = inflater.inflate(R.layout.todos, container, false);
        boolean Existe = false;
        MainActivity AP;
        AP = (MainActivity) getActivity();
        ArrayList<String> DatosLista;
        DatosLista=new ArrayList<>();
        baseMySql MySql = new baseMySql();
        MySql.Traer.start();
        if(MySql.ListUsers == null){

            Log.d("asjiodfasjiodsa","NO hay cosas en la lista");
        }else
        {
            Log.d("asjiodfasjiodsa","Hay cosas en la lista");
        }
        boolean Exitoiso = AP.AccesoBD();
        if (Exitoiso) {
            Cursor conjuntoDeRegistros;
            conjuntoDeRegistros = AP.baseDatos.rawQuery("select user from usuarios", null);
            if (conjuntoDeRegistros.moveToFirst()) {
                do {
                    String UsernameT = conjuntoDeRegistros.getString(0);
                    DatosLista.add(UsernameT);
                } while (conjuntoDeRegistros.moveToNext());
            }
            ArrayAdapter<String> Adaptador;
            Adaptador=new ArrayAdapter<String>(VistaADevolver.getContext() ,android.R.layout.simple_spinner_item, DatosLista);
            Adaptador.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

            Spinner spnTodos = (Spinner)VistaADevolver.findViewById(R.id.Spinner);
            spnTodos.setAdapter(Adaptador);



        }
        return VistaADevolver;

    }
}
