package com.example.exa2_restaurantes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Show extends AppCompatActivity implements ListView.OnItemClickListener {

    ListView lsRest;
    Intent inOpinion;

    Rest[] rests = {

            new Rest(),
            new Rest(R.drawable.tacos, "Chihuas", "Colonia Centro","Taquitos bbs", (float) 2),
            new Rest(R.drawable.meat,"Las Faenas","Colonia aeropuerto","Cortest bbs",(float) 3),
            new Rest(R.drawable.wings, "Buffalucas", "Colonia San Felipe","Bounles bbs", (float) 1)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        lsRest = findViewById(R.id.lsRest);
        lsRest.setAdapter(new ResAdapter(this, R.layout.list, rests));
        lsRest.setOnItemClickListener(this);

        inOpinion = new Intent(this, RestOpinion.class);



    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {

        inOpinion.putExtra("img",rests[pos].getImg());
        inOpinion.putExtra("name",rests[pos].getName());
        inOpinion.putExtra("desc",rests[pos].getDesc());
        inOpinion.putExtra("loc",rests[pos].getLoc());
        inOpinion.putExtra("rating",rests[pos].getRating());

        setResult(Activity.RESULT_OK,inOpinion);
        startActivity(inOpinion);
    }
}
