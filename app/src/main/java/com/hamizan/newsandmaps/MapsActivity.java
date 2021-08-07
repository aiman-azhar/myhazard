package com.hamizan.newsandmaps;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Vector;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    MarkerOptions marker;
    LatLng centerlocation;

    Vector<MarkerOptions> markerOptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        centerlocation = new LatLng(3.0,101);


        markerOptions = new Vector<>();

        markerOptions.add(new MarkerOptions().title("Hazard in Alor Setar")
                .position(new LatLng(6.12, 100.37))
                .snippet("Storm, 13.00pm, 7/8/2021, reported by user: Jantan Khamis")
        );

        markerOptions.add(new MarkerOptions().title("Hazard in Shah Alam")
                .position(new LatLng(3.0733, 101.5185))
                .snippet("Congestion, 17.00pm, 7/8/2021, reported by user: Tan Cheng Keong")
        );

        markerOptions.add(new MarkerOptions().title("Hazard in Teluk Intan")
                .position(new LatLng(4.0224, 101.0206))
                .snippet("Accident, 10.00am, 7/8/2021, repoted by user: Raju Mahmud")
        );

        markerOptions.add(new MarkerOptions().title("Hazard in Kota Bharu")
                .position(new LatLng(6.1248, 102.2544))
                .snippet("Mud Flood, 5.00am, 7/8/2021, reported by user: Anip69")
        );

        markerOptions.add(new MarkerOptions().title("Hazard in Skudai")
                .position(new LatLng(1.5344, 103.6594))
                .snippet("Land Slide, 16.00pm, 7/8/2021, reported by user: Alip197")
        );


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

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

        for (MarkerOptions mark : markerOptions){
            mMap.addMarker(mark);
        }

        enableMyLocation();


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerlocation, 6));
    }

    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            if (mMap != null) {
                mMap.setMyLocationEnabled(true);
            }
        } else {
            String perms[] = {"android.permission.ACCESS_FINE_LOCATION"};
            // Permission to access the location is missing. Show rationale and request permission
            ActivityCompat.requestPermissions(this,perms, 200);
        }
    }
}