package com.example.dpsdanimasyros;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

public class RegistrationActivity extends AppCompatActivity {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");

    private EditText etUsername;
    private EditText etEmail;
    private EditText etPassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);

        // Set the input type of the EditText fields to "text" to prevent new line on Enter key press
        etUsername.setSingleLine(true);
        etEmail.setSingleLine(true);
        etPassword.setSingleLine(true);

        // Set the action listener for the password field to handle the Done/Next action
        etPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_NEXT) {
                    // Hide the keyboard when the user presses Enter on the last field
                    if (v == etPassword) {
                        hideKeyboard();
                        return true;
                    }
                }
                return false;
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    private void register() {
        String username = etUsername.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (username.isEmpty()) {
            etUsername.setError("Username is required");
            etUsername.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            etEmail.setError("Email is required");
            etEmail.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Invalid email address");
            etEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            etPassword.setError("Password is required");
            etPassword.requestFocus();
            return;
        }

        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            etPassword.setError("Invalid password. Password must contain at least 1 uppercase letter, 1 lowercase letter, 1 symbol,1 number, and be at least 8 characters long.");
            etPassword.requestFocus();
            return;
        }

        // Perform registration logic
        boolean registrationSuccessful = performRegistration(username, email, password);

        if (registrationSuccessful) {
            // Save user registration information in SharedPreferences
            saveUserRegistration(username, email, password);

            // Show registration success toast
            Toast.makeText(RegistrationActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();

            // Navigate to the main screen or perform post-registration actions
            Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Optional: Finish the registration activity so the user cannot go back to it
        }
    }

    private boolean performRegistration(String username, String email, String password) {
        // Perform validation and registration logic
        // You can make API calls or use other methods as per your backend implementation

        // Assuming registration is successful
        return true;
    }

    private void saveUserRegistration(String username, String email, String password) {
        String userData = username + "," + email + "," + password + "\n";

        // Get the file path for saving the CSV file
        File file = new File(getExternalFilesDir(null), "user_registration.csv");

        try {
            // Create a FileWriter object with the file path
            FileWriter fileWriter = new FileWriter(file, true);

            // Write the user registration data to the CSV file
            fileWriter.append(userData);

            // Close the FileWriter
            fileWriter.close();

            Toast.makeText(RegistrationActivity.this, "User registration data saved successfully.", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(RegistrationActivity.this, "Failed to save user registration data.", Toast.LENGTH_SHORT).show();
        }
    }

    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
