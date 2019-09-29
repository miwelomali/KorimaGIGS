package com.example.eva1_4_eventos;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class MiEventoClick implements View.OnClickListener {
    Context context;
    @Override
    public void onClick(View view) {
        Toast.makeText(context,"Click en Clasa afuera", Toast.LENGTH_SHORT).show();
    }
    public void setContext(Context context){
        this.context = context;
    }
}
