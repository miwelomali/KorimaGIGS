package com.example.eva3_10_clima_asynktask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new ClimaAsynk().execute();
    }

    class ClimaAsynk extends AsyncTask<Void, Void, String>{
    final String ruta = "https://samples.openweathermap.org/data/2.5/find?lat=55.5&lon=37.5&cnt=10&appid=b6907d289e10d714a6e88b30761fae22";


        @Override
        protected String doInBackground(Void... voids) {
            String sResu = null;
            //AQUI VA LA CONEXION
            try {
                URL url = new URL(ruta);
                HttpsURLConnection http = (HttpsURLConnection) url.openConnection();
                http.connect();
                if (http.getResponseCode() == HttpsURLConnection.HTTP_OK){
                    //LLER RESPUESTA
                    String line;
                    StringBuffer lineas = new StringBuffer();
                    InputStream inputStream = http.getInputStream();
                    InputStreamReader isReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader =  new BufferedReader(isReader);

                    while((line = bufferedReader.readLine()) != null){
                        lineas.append(line);
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sResu;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (s != null){
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                //AQUI PROCESAMOS LOS OBJETOS JSON.
                try {
                    JSONObject jsonClima = new JSONObject(s);
                    JSONArray jsonCiudades = jsonClima.getJSONArray("list");
                    for (int i = 0; i< jsonCiudades.length(); i++){
                        //LLER CADA CIUDAD Y PONER LOS DATOS EN UNA LISTA
                     JSONObject jsonCiudad = jsonCiudades.getJSONObject(i);
                     //NOMBRE DE LA CIUDAD

                        //jsonCiudad.getString("name");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
