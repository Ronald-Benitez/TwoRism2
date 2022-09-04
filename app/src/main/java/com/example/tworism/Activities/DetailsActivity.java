package com.example.tworism.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tworism.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class DetailsActivity extends AppCompatActivity {
    GoogleMap googleMap;
    MapView mapaMP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mapaMP = findViewById(R.id.mapaView);
        mapaMP.onCreate(savedInstanceState);
        mapaMP.getMapAsync(mapa -> {
            googleMap = mapa;
            LatLng marcador = new LatLng(13.345005, -88.440480);
            googleMap.addMarker(new MarkerOptions().position(marcador).title("Partida").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(marcador));
            LatLng marcador2 = new LatLng(13.377957, -88.354537);
            googleMap.addMarker(new MarkerOptions().position(marcador2).title("destino").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(marcador2));
            googleMap.setMinZoomPreference(11);

        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapaMP.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        mapaMP.onPause();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapaMP.onDestroy();
    }
}