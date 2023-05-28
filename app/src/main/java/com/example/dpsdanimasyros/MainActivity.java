package com.example.dpsdanimasyros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button logobutton;
    private Button backButton;
    private Button settingsbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout navigationBar = findViewById(R.id.navigation_bar);

        // Inflate the new layout
        View newLayout = getLayoutInflater().inflate(R.layout.activity_navbar_layout, navigationBar, false);

        // Remove the existing layout from the LinearLayout
        navigationBar.removeAllViews();

        // Add the new layout to the LinearLayout
        navigationBar.addView(newLayout);

        button = findViewById(R.id.button_choose_category);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });

        logobutton = findViewById(R.id.logo_icon);
        logobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
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
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

    }

    }

