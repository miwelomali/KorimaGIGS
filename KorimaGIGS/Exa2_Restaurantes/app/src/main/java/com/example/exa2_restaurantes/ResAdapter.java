package com.example.exa2_restaurantes;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResAdapter extends ArrayAdapter<Rest> {
    Context context;
    int resource;
    Rest[] rest;

    public ResAdapter(Context context, int resource, Rest[] objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        rest = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ImageView imgRest;
        TextView txtName, txtLoc, txtDesc;
        RatingBar rate;


        if (convertView == null) {
            LayoutInflater iInflator = ((Activity) context).getLayoutInflater();
            convertView = iInflator.inflate(resource, parent, false);
        }
        imgRest = convertView.findViewById(R.id.imgRes);
        txtName = convertView.findViewById(R.id.txtName);
        txtLoc = convertView.findViewById(R.id.txtDir);
        txtDesc = convertView.findViewById(R.id.txtDesc);
        rate = convertView.findViewById(R.id.rateBar);

        imgRest.setImageResource(rest[position].getImg());
        txtName.setText(rest[position].getName());
        txtLoc.setText(rest[position].getLoc());
        txtDesc.setText(rest[position].getDesc());
        rate.setRating(rest[position].getRating());


        return convertView;
    }
}
