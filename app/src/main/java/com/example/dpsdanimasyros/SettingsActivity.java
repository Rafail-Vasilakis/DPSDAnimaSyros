package com.example.dpsdanimasyros;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    private Button backButton;
    private Button favoritesButton;
    private Button privacyButton;

    private Button terms_button;
    private Button shareButton;
    private Button removeAdsButton;
    // ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Spinner spinnerLanguages = findViewById(R.id.choose_language);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.languages, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_layout);
        spinnerLanguages.setAdapter(adapter);

        backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed(); // Go back to the previous activity
            }
        });

            favoritesButton = findViewById(R.id.button_favorites);
            favoritesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Handle favorites button click
                }
            });

            privacyButton = findViewById(R.id.button_privacy);
            privacyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Handle privacy button click
                }
            });


        terms_button = findViewById(R.id.terms_btn);
        terms_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, Terms_Activity.class);
                startActivity(intent);
            }
        });

            shareButton = findViewById(R.id.button_share);
            shareButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Handle share button click
                }
            });

            removeAdsButton = findViewById(R.id.button_remove_ads);
            removeAdsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Handle remove ads button click
                }
            });

            // Add click listeners for other buttons/options

        }
}
