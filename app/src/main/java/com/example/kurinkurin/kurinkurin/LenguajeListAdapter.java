package com.example.kurinkurin.kurinkurin;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Cristo López on 28/11/2016.
 */

public class LenguajeListAdapter  extends ArrayAdapter<String>{
    private final Activity context;
    private final ArrayList<String> itemname;
    private final Integer[] integers;

    public LenguajeListAdapter(Activity context, ArrayList<String> itemname, Integer[] integers) {
        super(context, R.layout.tiendas,itemname );
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.integers=integers;
    }

    public View getView(int posicion,View view, ViewGroup parent){

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.tiendas,null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.texto_principal);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView etxDescripcion = (TextView) rowView.findViewById(R.id.texto_secundario);

        txtTitle.setText(loginActivity.getNombreTiendas().get(posicion));
        imageView.setImageResource( R.drawable.ic_launcher);
        etxDescripcion.setText(loginActivity.getDescripcionTiendas().get(posicion));

        return rowView;
    }
}
