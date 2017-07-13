package com.example.a42077426.tp4lcdtm;

import android.content.Context;
import android.content.ContextWrapper;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Administrador on 13/7/2017.
 */

public class AdaptadorUsuarios extends BaseAdapter {
    private ArrayList<Usuario> _ListUsers;
    private Context _Context;
    public AdaptadorUsuarios (ArrayList<Usuario> ListaUsuariosTraida, Context ContextoAUsar){
        _ListUsers = ListaUsuariosTraida;
        _Context = ContextoAUsar;
    }

    public int getCount(){
        return  _ListUsers.size();
    }

    public Usuario getItem(int PosAObt){
        Usuario UsuarioADevolver;
        UsuarioADevolver =_ListUsers.get(PosAObt);
        return UsuarioADevolver;
    }

    public long getItemId(int PosAObt){
        long Id;
        Id =_ListUsers.get(PosAObt).Id;
        return Id;
    }

    public View getView(int PosicionActual, View VistaActual, ViewGroup GrupoActual){
        View VistaADevolver;
        LayoutInflater InfladorDeLayouts;
        InfladorDeLayouts = (LayoutInflater)_Context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        VistaADevolver = InfladorDeLayouts.inflate(R.layout.listview_users_detalles, GrupoActual, false);

        TextView txvUsername = (TextView)VistaADevolver.findViewById(R.id.txvUsername);
        TextView txvCommie = (TextView)VistaADevolver.findViewById(R.id.txvCommie);
        TextView txvSorete = (TextView)VistaADevolver.findViewById(R.id.txvSorete);
        TextView txvLastConn = (TextView)VistaADevolver.findViewById(R.id.txvFechaLastConn);

        Usuario MiUser = new Usuario();
        MiUser = getItem(PosicionActual);

        txvUsername.setText(MiUser.UserName);
        String IsCommie = MiUser.Commie ? "Este pibe sabe" : "Stalin acabara con el";
        txvCommie.setText(IsCommie);
        txvSorete.setText(MiUser.TamañoPromSorete);
        txvLastConn.setText(MiUser.FechaIngreso);

        return  VistaADevolver;
    }
}
