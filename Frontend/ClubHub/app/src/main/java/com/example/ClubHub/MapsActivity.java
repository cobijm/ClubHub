package com.example.ClubHub;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String mapLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mapLoc = getIntent().getStringExtra("clubName");
//        if(mapLoc == null){
//            mapLoc = "Fishing Club";
//        }
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

        if(mapLoc.equals("Fishing Club")){
            LatLng fishClub = new LatLng(42.0253, -93.6483);
            mMap.addMarker(new MarkerOptions().position(fishClub).title("Fishing club"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(fishClub,18));
        }

        else if(mapLoc.equals("C Monsters")){
            LatLng cMonst = new LatLng(42.0281, -93.6496);
            mMap.addMarker(new MarkerOptions().position(cMonst).title("C Monsters"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cMonst,18));
        }

        else if (mapLoc.equals("Wine Enthusiasts")){
            LatLng wine = new LatLng(42.0275, -93.6421);
            mMap.addMarker(new MarkerOptions().position(wine).title("Wine Enthusiasts"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(wine,18));
        }

        else if (mapLoc.equals("We Love MIPS")){
            LatLng mips  = new LatLng(42.0284, -93.6509);
            mMap.addMarker(new MarkerOptions().position(mips).title("We Love Mips"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(mips,18));
        }

        else if(mapLoc.equals("Runner's High")){
            LatLng runner = new LatLng(42.0267, -93.6372);
            mMap.addMarker(new MarkerOptions().position(runner).title("Runner's High"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(runner,18));
        }
    }
}
