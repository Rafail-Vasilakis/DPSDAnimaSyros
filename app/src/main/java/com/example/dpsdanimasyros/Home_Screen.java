package com.example.dpsdanimasyros;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class Home_Screen extends AppCompatActivity {
    private Slider_Adapter sliderAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupOnBoardingItems();

        ViewPager2 onboardingViewPager = findViewById(R.id.viewpager);
        onboardingViewPager.setAdapter(sliderAdapter);
    }

    private void setupOnBoardingItems()
    {
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
        secondpage.setText2("ιβάλ εξασφαλίζεται η προσβασιμότητα σε ΑμεΑ.");
        secondpage.setText3("Οι διαδικτυακές προβολές είναι διαθέσιμες στο live.animasyros.gr δωρεάν και χωρίς εγγραφή");
        secondpage.setImage(R.drawable.dotsdotsposition_marks_2);

        OnBoardingItems thirdpage = new OnBoardingItems();
        thirdpage.setTitle("ΠΛΗΡΟΦΟΡΙΕΣ");
        thirdpage.setText1(" ");
        thirdpage.setText2("Οι δράσεις της Αγοράς μεταδίδονται διαδικτυακά στο κανάλι του Animasyros στο YouTube.");
        thirdpage.setText3(" ");
        thirdpage.setImage(R.drawable.dotsdotsposition_marks_3);

        onBoardingItems.add(firstpage);
        onBoardingItems.add(secondpage);
        onBoardingItems.add(thirdpage);

        sliderAdapter = new Slider_Adapter(onBoardingItems);
    }

}
