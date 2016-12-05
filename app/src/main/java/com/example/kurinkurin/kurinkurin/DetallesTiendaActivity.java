package com.example.kurinkurin.kurinkurin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DetallesTiendaActivity extends AppCompatActivity {

    TextView nombre,descripcion;
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_tienda);

        nombre = (TextView) findViewById(R.id.tiendaTitulo);
        nombre.setText(loginActivity.getNombreTiendas().get(MainActivity.getTiendaSeleccionada()));

        descripcion = (TextView) findViewById(R.id.tiendaDescripcion);
        descripcion.setText(loginActivity.getDescripcionTiendas().get(MainActivity.getTiendaSeleccionada()));


        lista = (ListView)findViewById(R.id.tiendaServicios);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MainActivity.getServicios());
        lista.setAdapter(adaptador);

    }
}
