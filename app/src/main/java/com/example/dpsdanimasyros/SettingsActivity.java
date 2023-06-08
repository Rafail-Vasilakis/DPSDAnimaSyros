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

    private Button add_account;
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
                    Intent intent = new Intent(SettingsActivity.this, FavoritesActivity.class);
                    startActivity(intent);
                }
            });

            privacyButton = findViewById(R.id.button_privacy);
            privacyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Handle privacy button click
                }
            });

        // Find the share button in your layout and set a click listener
        findViewById(R.id.button_share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create the share intent
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Your Subject");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Content to share");

                // Start the activity with the share intent
                startActivity(Intent.createChooser(shareIntent, "Share via"));
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



            removeAdsButton = findViewById(R.id.button_remove_ads);
            removeAdsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Handle remove ads button click
                }
            });

        add_account = findViewById(R.id.add_account_btn);
        add_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, RegistrationActivity.class);
                startActivity(intent);

            }
        });


        // Add click listeners for other buttons/options

        }
}
