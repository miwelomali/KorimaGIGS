package com.example.korima_player.ui.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.korima_player.MyRola;
import com.example.korima_player.R;

import org.w3c.dom.Text;

public class HomeFragment extends Fragment implements View.OnClickListener{
    Intent inRola;
    int iPlayStop = 0;



    private HomeViewModel homeViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inRola = new Intent(getContext(), MyRola.class);
        final Button exampleBtn = (Button) view.findViewById(R.id.btn_conferma);
        final TextView textView =(TextView) view.findViewById(R.id.text_home);
        //MediaMetadataRetriever mmr = new MediaMetadataRetriever();
       // Uri uri = Uri.parse("android.resource://com.example.korima_player/raw/whatlike");
       // mmr.setDataSource(uri.getEncodedPath());

        //String albumName = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
        //textView.setText(albumName);
        exampleBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if (iPlayStop == 0){
                    exampleBtn.setBackgroundResource(R.drawable.pause);
                    getActivity().startService(inRola);

                    iPlayStop++;
                }

                else {
                    getActivity().stopService(inRola);
                    exampleBtn.setBackgroundResource(R.drawable.play);
                    iPlayStop =0;
                }
                // TODO Auto-generated method stub


            }

        });

    }

    @Override
    public void onClick(View view) {
        inRola = new Intent(getActivity(), MyRola.class);
        getActivity().startService(new Intent(getActivity(),MyRola.class));
    }


}

