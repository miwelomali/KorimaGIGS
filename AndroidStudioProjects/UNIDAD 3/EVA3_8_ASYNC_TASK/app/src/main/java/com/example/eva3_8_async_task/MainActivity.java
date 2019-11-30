package com.example.eva3_8_async_task;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView txtVwDatos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwDatos = findViewById(R.id.txtVwDatos);
        MiClaseAsyncrona miClaseAsyncrona = new MiClaseAsyncrona();
        miClaseAsyncrona.execute(20,500);


    }

    class MiClaseAsyncrona extends AsyncTask<Integer,String,String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtVwDatos.setText("INICIO DEL ASYNTASK" + "\n");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            txtVwDatos.append(s);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            txtVwDatos.append(values[0] + "\n");
        }
        //NO FUNCIONA CON INTERFACES, LAS DEMAS SI
        @Override
        protected String doInBackground(Integer... integers) {


            int iVeces = integers[0];
            int iDemora = integers[1];
            for (int i = 0; i< iVeces; i++){
                try {
                    Thread.sleep(iDemora);
                    publishProgress(i + " : ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "FIN DEL ASYNTASK";
        }
    };

}


