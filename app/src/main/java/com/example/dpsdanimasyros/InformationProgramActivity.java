package com.example.dpsdanimasyros;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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

        // Retrieve the "ButtonPressed" value from the intent
        int buttonPressed = getIntent().getIntExtra("ButtonPressed", -1);
        int image = getIntent().getIntExtra("Image", -1);
        int title = getIntent().getIntExtra("Title", -1);

        // Customize the text based on the buttonPressed value
        TextView infoTextView = findViewById(R.id.infotext);
        ImageView imageView = findViewById(R.id.imagecategory);
        TextView titletext = findViewById(R.id.title);
        if (buttonPressed == 0) {
            titletext.setText("10:00 \n Σχολική Προβολή στο  \n Θέατρο Απόλλων");
            infoTextView.setText("Quarantine Diary (GR, 8’29”)\n Louis and Luca – Mission to the \nMoon (NO, 80’)");
            imageView.setImageResource(R.drawable.firstcategoryphoto);

        } else if (buttonPressed == 1) {
            titletext.setText("\"16:00 \n ΠΡΟΒΟΛΈΣ ΤΑΙΝΙΩΝ \n" +
                    "ΔΙΑΓΩΝΙΣΜΟΎ ANIMEGARON");
            infoTextView.setText("Απολαύστε μια μοναδική εμπειρία προβολών ταινιών στο AnimeGaron! Παρέχουμε μια ευρεία γκάμα από αγαπημένες ταινίες anime, καλύπτοντας διάφορα είδη και στυλ. Ανακαλύψτε τον μαγικό κόσμο του anime και απολαύστε τις αγαπημένες σας ταινίες μαζί με άλλους λάτρεις του anime."

                   + "Επιπλέον, συμμετέχετε στον διαγωνισμό AnimeGaron για να κερδίσετε μοναδικά δώρα και εμπειρίες! Μείνετε ενημερωμένοι για τις λεπτομέρειες του διαγωνισμού και δηλώστε συμμετοχή για την ευκαιρία να αποκτήσετε αξέχαστες αναμνήσεις και αντικείμενα συλλογής." +

                   " Για περισσότερες πληροφορίες σχετικά με τις προβολές ταινιών και τον διαγωνισμό AnimeGaron, επισκεφθείτε την ιστοσελίδα μας ή επικοινωνήστε με την ομάδα υποστήριξής μας. Ανυπομονούμε να σας καλωσορίσουμε στον κόσμο του AnimeGaron και να σας προσφέρουμε μια αξέχαστη εμπειρία!); ");
            imageView.setImageResource(R.drawable.secondevent);
        }
    }

}