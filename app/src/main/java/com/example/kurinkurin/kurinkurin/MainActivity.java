package com.example.kurinkurin.kurinkurin;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.mime.content.StringBody;

public class MainActivity extends Activity{

    private static int TiendaSeleccionada;



    private String[] lenguajeProgramacion=new String[]{"Java","PHP","Python","JavaScript","Ruby","C",
            "Go","Perl","Pascal","Otro"};

    private static String[] servicios = new String[]{"Servicio_1","Servicio_2","Servicio_3","Servicio_4","Servicio_5","Servicio_6","Servicio_7","Servicio_8","Servicio_n"};

    private Integer[] imgid={
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher
    };

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        LenguajeListAdapter adapter=new LenguajeListAdapter(this,loginActivity.getNombreTiendas(),imgid);
        lista=(ListView)findViewById(R.id.mi_lista);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String Slecteditem= lenguajeProgramacion[+position];
                //Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
                TiendaSeleccionada = position;
                Intent tienda = new Intent(MainActivity.this,DetallesTiendaActivity.class);
                startActivity(tienda);



            }
        });
    }

   public static int getTiendaSeleccionada(){
        return TiendaSeleccionada;
    }

    public static String[] getServicios(){
        return servicios;
    }
}
