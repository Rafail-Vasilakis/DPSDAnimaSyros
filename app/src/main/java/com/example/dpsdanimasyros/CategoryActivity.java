package com.example.dpsdanimasyros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dpsdanimasyros.adapterclass.ThemesAdapter;
import com.example.dpsdanimasyros.model.ThemeModel;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    private Button buttoninformation;

    private Button logobutton;
    private Button backButton;

    private Button settingsbutton;

    private final ArrayList<ThemeModel> themeModels = new ArrayList<>();
    RecyclerView recyclerView;

    Button show_favorite_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_category_layout);

        Spinner spinnerLanguages = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.days, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        spinnerLanguages.setAdapter(adapter);

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
                Intent intent = new Intent(CategoryActivity.this, MainActivity.class);
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
                Intent intent = new Intent(CategoryActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.recyclerviewThemes);
        show_favorite_button = findViewById(R.id.show_fav_btn);
        recyclerView.setHasFixedSize(true);
        addToFavorites();

        show_favorite_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoryActivity.this,FavoritesActivity.class));
            }
        });
    }

    public void addToFavorites()
    {
        recyclerView.setAdapter(new ThemesAdapter(themeModels,CategoryActivity.this));
        recyclerView.setLayoutManager(new GridLayoutManager(CategoryActivity.this,1));

        themeModels.add(new ThemeModel(R.drawable.firstcategoryphoto,"10:00 \n" +
                "Σχολική Προβολή στο \n" +
                "Θέατρο Απόλλων","theme1"));
        themeModels.add(new ThemeModel(R.drawable.secondevent,"16:00 \n" +
                "Προβλές ταινιών διαγωνισμού ANIMEGARON","theme2"));
        themeModels.add(new ThemeModel(R.drawable.thirdevent,"16:20 \n" +
                "Διεθνές Πανόραμα","theme3"));
        themeModels.add(new ThemeModel(R.drawable.fourthevent,"18:15 \n" +
                "       Αφιέρωμα \n" +
                "Norway Calling","theme4"));
        themeModels.add(new ThemeModel(R.drawable.fifthevent,"19:30 \n" +
                "Τηλεοπτικές & κατα παραγγελία ταινίες","theme5"));
        themeModels.add(new ThemeModel(R.drawable.sixthevent,"20:45 \n" +
                "Αφιέρωμα Stand with Ukraine","theme6"));
        themeModels.add(new ThemeModel(R.drawable.seventhevent,"22:15 \n" +
                "Διαγωνιστικό Μεγάλου Μήκους-Βραβείο Κοινού","theme7"));
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        addToFavorites();
    }

}


