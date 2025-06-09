package com.example.votingsystem;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpcomingelectionsActivity extends AppCompatActivity {

    ImageButton backButton;
    Button btnRemindMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcomingelections);

        // Initialize UI elements
        backButton = findViewById(R.id.backButton);
        btnRemindMe = findViewById(R.id.btnRemindMe);

        // Back button functionality
        backButton.setOnClickListener(v -> finish());

        // Remind me button click handler
        btnRemindMe.setOnClickListener(v -> {
            // You can replace this with actual notification scheduling logic
            Toast.makeText(this, "You will be reminded when the election starts.", Toast.LENGTH_SHORT).show();
        });
    }
}
