package com.example.dpsdanimasyros;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.core.content.ContextCompat;

public class MapActivity extends AppCompatActivity {
    private MapView mapView;

    private Button logobutton;
    private Button backButton;
    private Button settingsbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize osmdroid configuration
        Configuration.getInstance().load(getApplicationContext(), getPreferences(MODE_PRIVATE));

        setContentView(R.layout.activity_map);

        LinearLayout navigationBar = findViewById(R.id.navigation_bar);

        // Inflate the new layout
        View newLayout = getLayoutInflater().inflate(R.layout.activity_navbar_layout, navigationBar, false);

        // Remove the existing layout from the LinearLayout
        navigationBar.removeAllViews();

        // Add the new layout to the LinearLayout
        navigationBar.addView(newLayout);


        logobutton = findViewById(R.id.logo_icon);
        logobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed(); // Go back to the previous activity
            }
        });

        settingsbutton = findViewById(R.id.settings_btn);
        settingsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        mapView = findViewById(R.id.map);
        mapView.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE);
        mapView.setMultiTouchControls(true);

        // Set the initial map view to Syros
        IMapController mapController = mapView.getController();
        GeoPoint syros = new GeoPoint(37.44250, 24.94116);
        mapController.setCenter(syros);
        mapController.setZoom(17);

        // Hide zoom controls
        mapView.setBuiltInZoomControls(false);
        mapView.setMultiTouchControls(true);




        // Add 7 more markers with different icons
        addMarker(37.44561, 24.94374, "ΘΕΑΤΡΟ ΑΠΟΛΛΩΝ / APOLLO THEATRE", R.drawable.entypo_pin);
        addMarker(37.44529, 24.94348, "ΠΝΕΥΜΑΤΙΚΟ ΚΕΝΤΡΟ / CULTURAL CENTRE", R.drawable.entypo_pin2);
        addMarker(37.44450, 24.94208, "ΠΑΛΛΑΣ ΘΕΡΙΝΟΣ ΚΙΝΗΜΑΤΟΓΡΑΦΟΣ / PALLAS OPEN AIR CINEMA", R.drawable.entypo_pin3);
        addMarker(37.44516, 24.94336, "ΔΗΜΟΤΙΚΗ ΒΙΒΛΙΟΘΗΚΗ / MUNICIPAL LIBRARY", R.drawable.entypo_pin4);
        addMarker(37.44475, 24.94286, "ΠΛΑΤΕΙΑ ΜΙΑΟΥΛΗ / MIAOULI SQUARE", R.drawable.entypo_pin5);
        addMarker(37.44705, 24.94377, "ΙΝΣΤΙΤΟΥΤΟ ΚΥΒΕΛΗ / KYVELI INSTITUTE", R.drawable.entypo_pin6);
        addMarker(37.44551, 24.94172, "ΠΑΝΕΠΙΣΤΗΜΙΟ ΑΙΓΑΙΟΥ / UNIVERSITY OF THE AEGEAN", R.drawable.entypo_pin7);
        addMarker(37.43967, 24.94013, "ΣΤΑΘΜΟΣ ΚΤΕΛ / LOCAL BUS STATION", R.drawable.entypo_pin8);

        // Refresh the map view
        mapView.invalidate();
    }

    private void addMarker(double latitude, double longitude, String title, int iconResource) {
        Marker marker = createMarker(latitude, longitude, title, iconResource);
        mapView.getOverlays().add(marker);
    }

    private Marker createMarker(double latitude, double longitude, String title, int iconResource) {
        Marker marker = new Marker(mapView);
        GeoPoint coordinates = new GeoPoint(latitude, longitude);
        marker.setPosition(coordinates);
        marker.setTitle(title);
        BitmapDrawable icon = (BitmapDrawable) ContextCompat.getDrawable(this, iconResource);
        marker.setIcon(icon);
        return marker;
    }
}

