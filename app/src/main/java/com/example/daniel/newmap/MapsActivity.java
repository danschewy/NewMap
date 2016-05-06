package com.example.daniel.newmap;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
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

        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

           @Override
            public View getInfoContents(Marker marker) {

                Context context = getApplicationContext(); //or getActivity(), YourActivity.this, etc.

                LinearLayout info = new LinearLayout(context);
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(context);
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(context);
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }
        });

        // Add a marker in Sydney and move the camera
        LatLng Drexel = new LatLng(39.955645, -75.189477);
        LatLng Cart1 = new LatLng(39.956022, -75.189366);
        LatLng Cart2 = new LatLng(39.956367, -75.189379);
        LatLng Cart3 = new LatLng(39.955630, -75.188271);

        mMap.addMarker(new MarkerOptions().position(Drexel).title("Drexel Campus").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.addMarker(new MarkerOptions().position(Cart1).title("Dan's Cart : European Cuisine").snippet("Delicious Russian Borsht For Everyone").icon(BitmapDescriptorFactory.fromAsset("CartMarker.png")));
        mMap.addMarker(new MarkerOptions().position(Cart2).title("Kevin's Cart : Asian Cuisine").snippet("Fried Mice For Cheap").icon(BitmapDescriptorFactory.fromAsset("CartMarker.png")));
        mMap.addMarker(new MarkerOptions().position(Cart3).title("Donuts For Da Peeps : Dessert").snippet("Better than Federal Donuts! Sweet and Sour!").icon(BitmapDescriptorFactory.fromAsset("CartMarker.png")));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Drexel));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(18.5f));



    }

    public void setCartMarker(GoogleMap mMap, FoodCart Cart1){

        mMap.addMarker(new MarkerOptions().position(Cart1.getPosition()).title(Cart1.getName() + ": " + Cart1.getCuisine()).snippet(Cart1.getDescription()).icon(BitmapDescriptorFactory.fromAsset("CartMarker.png")));

    }

}
