package com.example.dpsdanimasyros;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import kotlin.Suppress;

public class DirectionsActivity extends AppCompatActivity {
    private Slider_Adapter sliderAdapter;
    private Button buttonOnboardingAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directions);

        buttonOnboardingAction = findViewById(R.id.buttonOnboardingAction);

        setupOnBoardingItems();

        ViewPager2 onboardingViewPager = findViewById(R.id.viewpager);
        onboardingViewPager.setAdapter(sliderAdapter);

        setCurrentOnboardingIndicator(0);

        buttonOnboardingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onboardingViewPager.getCurrentItem() + 1 < sliderAdapter.getItemCount()) {
                    onboardingViewPager.setCurrentItem(onboardingViewPager.getCurrentItem() + 1);
                } else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }
        });
    }

    private void setupOnBoardingItems() {
        List<OnBoardingItems> onBoardingItems = new ArrayList<>();

        OnBoardingItems firstpage = new OnBoardingItems();
        firstpage.setTitle("ΠΛΗΡΟΦΟΡΙΕΣ");
        firstpage.setText1("H είσοδος σε όλες τις δράσεις του Φεστιβάλ είναι δωρεάν.");
        firstpage.setText2("Η ηλεκτρονική κράτηση θέσης, μέσω του Εventbrite είναι απαραίτητη για τις προβολέςστο Θέατρο Απόλλων.");
        firstpage.setText3("Tο πωλητήριο του Φεστιβάλ βρίσκεται στο Θέατρο Απόλλων.");
        firstpage.setImage(R.drawable.dotsposition_marks);

        OnBoardingItems secondpage = new OnBoardingItems();
        secondpage.setTitle("ΠΛΗΡΟΦΟΡΙΕΣ");
        secondpage.setText1("To Café Hermoupolitan λειτουργεί στην Αυλή του Θεάτρου Απόλλων, καθημερινά 16:00-23:00.");
        secondpage.setText2("Σε όλους τους χώρους του Φεστιβάλ εξασφαλίζεται η προσβασιμότητα σε ΑμεΑ.");
        secondpage.setText3("Οι διαδικτυακές προβολές είναι διαθέσιμες στο live.animasyros.gr δωρεάν και χωρίς εγγραφή");
        secondpage.setImage(R.drawable.dotsdotsposition_marks_2);

        OnBoardingItems thirdpage = new OnBoardingItems();
        thirdpage.setTitle("ΠΛΗΡΟΦΟΡΙΕΣ");
        thirdpage.setText1("");
        thirdpage.setText2("Οι δράσεις της Αγοράς μεταδίδονται διαδικτυακά στο κανάλι του Animasyros στο YouTube.");
        thirdpage.setText3("");
        thirdpage.setImage(R.drawable.dotsdotsposition_marks_3);


        onBoardingItems.add(firstpage);
        onBoardingItems.add(secondpage);
        onBoardingItems.add(thirdpage);

        sliderAdapter = new Slider_Adapter(onBoardingItems);
    }

    @SuppressLint("SetTextI18n")
    private void setCurrentOnboardingIndicator(int intex)
    {
        if(intex == sliderAdapter.getItemCount() - 1)
        {
            buttonOnboardingAction.setText("Start");
        }else
        {
            buttonOnboardingAction.setText("Next");
        }
    }
}
