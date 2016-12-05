package com.example.kurinkurin.kurinkurin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.w3c.dom.Text;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class loginActivity extends AppCompatActivity {

    TextView verTiendas;

    private String PathGetTiendas = "http://jsonplaceholder.typicode.com/users";
    private static ArrayList<String> nombreTiendas = new ArrayList<String>();
    private static ArrayList<String> descripcionTiendas = new ArrayList<String>();
    private JSONArray array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        verTiendas = (TextView)findViewById(R.id.ir_tiendas);
        verTiendas.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                nombreTiendas = new ArrayList<String>();
                descripcionTiendas = new ArrayList<String>();
                //Http get Request
                System.out.println("Intentoooooooooooo");
                nombreTiendas.add("Kurin");
                descripcionTiendas.add("KurinKurin");
                AsyncHttpClient client = new AsyncHttpClient();
                client.get(PathGetTiendas, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        if(responseBody != null){
                            try {
                                array = new JSONArray(new String(responseBody));
                                System.out.println("Entroooooo array");
                                System.out.println("----"+array);
                                for(int c = 0; c < array.length() ; c++){
                                    try {
                                        nombreTiendas.add((String) array.getJSONObject(c).get("name"));
                                        descripcionTiendas.add((String) array.getJSONObject(c).get("username"));
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                                for (int h = 0 ; h<nombreTiendas.size();h++){
                                    System.out.println("++++>"+nombreTiendas.get(h));
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                    }
                });

                Intent tiendas = new Intent(loginActivity.this,MainActivity.class);
                startActivity(tiendas);


            }
        });


    }

    public static ArrayList<String> getNombreTiendas(){
        return nombreTiendas;
    }

    public static ArrayList<String> getDescripcionTiendas(){
        return descripcionTiendas;
    }
}
