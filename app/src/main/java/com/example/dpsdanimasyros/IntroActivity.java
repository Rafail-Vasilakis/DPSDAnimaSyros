package com.example.dpsdanimasyros;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class IntroActivity extends AppCompatActivity {

    private Button start_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        start_btn = findViewById(R.id.start_button); // Initialize start_btn

        start_btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                // Perform long-press action
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if (vibrator != null) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        // Vibrate with custom vibration effect (pattern)
                        long[] pattern = {0, 100, 200, 300};
                        vibrator.vibrate(VibrationEffect.createWaveform(pattern, -1));
                    } else {
                        // Vibrate for a fixed duration
                        vibrator.vibrate(500);
                    }
                    Intent intent = new Intent(IntroActivity.this, DirectionsActivity.class);
                    startActivity(intent);
                }
                return true;

            }
        });

    }
}

