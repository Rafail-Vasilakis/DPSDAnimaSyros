package com.example.dpsdanimasyros;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.dpsdanimasyros.adapterclass.ThemesAdapter;
import com.example.dpsdanimasyros.model.ThemeModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button button;

    private Button fav_btn;
    private Button logobutton;
    private Button backButton;
    private Button settingsbutton;
    private ArrayList<ThemeModel> themeModels;
    private AlertDialog.Builder recyclerView;


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
                intent.putExtra("ButtonPressed", 1); // Pass a value to indicate button1 was pressed
                startActivity(intent);
            }
        });



        button = findViewById(R.id.choose_second_cat);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                intent.putExtra("ButtonPressed", 2); // Pass a value to indicate button1 was pressed
                startActivity(intent);
            }
        });

        button = findViewById(R.id.choose_third_cat);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                intent.putExtra("ButtonPressed", 3); // Pass a value to indicate button1 was pressed
                startActivity(intent);
            }
        });

        button = findViewById(R.id.choose_fourth_cat);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                intent.putExtra("ButtonPressed", 4); // Pass a value to indicate button1 was pressed
                startActivity(intent);
            }
        });

        button = findViewById(R.id.choose_fifth_cat);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });


        fav_btn = findViewById(R.id.favbtn);
        fav_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FavoritesActivity.class);
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

