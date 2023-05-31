package com.example.dpsdanimasyros;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class InformationProgramActivity  extends AppCompatActivity {

    private Button logobutton;
    private Button backButton;
    private Button settingsbutton;

    private Button add_fav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_program_layout);

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
                Intent intent = new Intent(InformationProgramActivity.this, MainActivity.class);
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
                Intent intent = new Intent(InformationProgramActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });


       /* add_fav = findViewById(R.id.add_fav_btn);
        add_fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InformationProgramActivity.this, FavoritesActivity.class);
                startActivity(intent);
            }
        }); */

    }


}