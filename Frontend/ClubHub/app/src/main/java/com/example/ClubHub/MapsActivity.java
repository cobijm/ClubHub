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

        // Add a marker in For StandUp and move the camera
        LatLng standUp = new LatLng(42.0275, -93.6421);
        mMap.addMarker(new MarkerOptions().position(standUp).title("Stand Up Comedy"));

        // Add a marker in For HKN and move the camera
        LatLng hkn = new LatLng(42.0284, -93.6509);
        mMap.addMarker(new MarkerOptions().position(hkn).title("Eta Kappa Nu"));

        // Add a marker in For HKN and move the camera
        LatLng solar = new LatLng(42.0278, -93.6509);
        mMap.addMarker(new MarkerOptions().position(solar).title("Solar Car"));

        // Add a marker in For HKN and move the camera
        LatLng codingClub = new LatLng(42.0281, -93.6496);
        mMap.addMarker(new MarkerOptions().position(codingClub).title("Coding club"));

        // Add a marker in For HKN and move the camera
        LatLng filmClub = new LatLng(42.0253, -93.6483);
        mMap.addMarker(new MarkerOptions().position(filmClub).title("Film club"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(filmClub,14));

    }
}
