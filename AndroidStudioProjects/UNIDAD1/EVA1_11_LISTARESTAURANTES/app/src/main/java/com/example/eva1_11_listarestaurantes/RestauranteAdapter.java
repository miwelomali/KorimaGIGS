package com.example.eva1_11_listarestaurantes;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RestauranteAdapter extends ArrayAdapter<Restaurante> {
    Context context;
    int resource;
    Restaurante[] Restaurante;

    public RestauranteAdapter(Context context, int resource, Restaurante[] objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        Restaurante = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ImageView imgRestaurante;
        TextView txtVwNombre, txtVwLocacion, txtVwComida, txtVwRating;


        if (convertView == null) {
            LayoutInflater iInflator = ((Activity) context).getLayoutInflater();
            convertView = iInflator.inflate(resource, parent, false);
        }
        imgRestaurante = convertView.findViewById(R.id.imageView);
        txtVwNombre = convertView.findViewById(R.id.txtVwNombre);
        txtVwComida = convertView.findViewById(R.id.txtVwComida);
        txtVwLocacion = convertView.findViewById(R.id.txtVwLocacion);
        txtVwRating = convertView.findViewById(R.id.txtVwRating);

        imgRestaurante.setImageResource(Restaurante[position].getImagen());
        txtVwNombre.setText(Restaurante[position].getNombre());
        txtVwComida.setText(Restaurante[position].getComida());
        txtVwLocacion.setText(Restaurante[position].getLocacion());
        txtVwRating.setText(Restaurante[position].getRating() + " Estrellas");

        return convertView;
    }
}
