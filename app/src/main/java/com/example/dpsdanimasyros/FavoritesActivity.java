package com.example.dpsdanimasyros;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class FavoritesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);


        LinearLayout navigationBar = findViewById(R.id.navigation_bar);

        // Inflate the new layout
        View newLayout = getLayoutInflater().inflate(R.layout.activity_navbar_layout, navigationBar, false);

        // Remove the existing layout from the LinearLayout
        navigationBar.removeAllViews();

        // Add the new layout to the LinearLayout
        navigationBar.addView(newLayout);



    }
}