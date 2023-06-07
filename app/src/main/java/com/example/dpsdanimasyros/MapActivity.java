package com.example.dpsdanimasyros;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

public class MapActivity extends AppCompatActivity {
    private MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize osmdroid configuration
        Configuration.getInstance().load(getApplicationContext(), getPreferences(MODE_PRIVATE));

        setContentView(R.layout.activity_map);

        mapView = findViewById(R.id.map);
        mapView.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE);
        mapView.setMultiTouchControls(true);

        // Set the initial map view to Syros
        IMapController mapController = mapView.getController();
        GeoPoint syros = new GeoPoint(37.4431, 24.9465);
        mapController.setCenter(syros);
        mapController.setZoom(15);

        // Hide zoom controls
        mapView.setBuiltInZoomControls(false);
        mapView.setMultiTouchControls(true);

        // Hide waypoints or do any other customizations as needed
        // ...
    }
}

