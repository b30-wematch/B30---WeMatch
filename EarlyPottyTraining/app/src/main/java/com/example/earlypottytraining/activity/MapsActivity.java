package com.example.earlypottytraining.activity;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.earlypottytraining.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

//        Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-37.8136, 144.9631);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        //test
        List<String> babyChangeList = new ArrayList<String>();
        try {
            InputStreamReader is = new InputStreamReader(getAssets().open("toilet_training.csv"));
            BufferedReader reader = new BufferedReader(is);
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] str = line.split(",");
                if (str[8].equals("TRUE")) {
                    babyChangeList.add(str[2] + "," + str[3] + "," + str[8] + "," + str[9] + "," + str[10]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "Loading...", Toast.LENGTH_LONG).show();

        for (String unit : babyChangeList) {
            String[] cell = unit.split(",");
            double latitude;
            try {
                latitude = Double.parseDouble(cell[3]);
            } catch (Exception e) {
                e.printStackTrace();
                latitude = 0;
            }
            double longitude;
            try {
                longitude = Double.parseDouble(cell[4]);
            } catch (Exception e) {
                e.printStackTrace();
                longitude = 0;
            }
            String name = cell[0];
            String address = cell[1];
            LatLng location = new LatLng(latitude, longitude);

            mMap.addMarker(new MarkerOptions().position(location).title(name).snippet(address));
        }
        addMaker(new LatLng(-37.8136, 144.9631), googleMap);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-37.8136, 144.9631), 12.0f));
    }

    public void addMaker(LatLng location, GoogleMap googleMap) {
        GoogleMap map = googleMap;
        if (map != null) {
            MarkerOptions options = new MarkerOptions();
//            BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.flag_china);
//            options.icon(icon);
            options.position(location).title("You Are Here");
            map.addMarker(options);
        }
    }

}
