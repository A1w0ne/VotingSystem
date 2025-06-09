package com.example.votingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CloseelectionActivity extends AppCompatActivity {

    ImageButton backButton, btnNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closeelections); // Ensure this matches your XML filename

        // Hook UI elements
        backButton = findViewById(R.id.backButton);
        btnNotification = findViewById(R.id.btnotifcation);

        // Back button returns to previous screen
        backButton.setOnClickListener(v -> finish());

        // Notification bell
        btnNotification.setOnClickListener(v ->
                Toast.makeText(this, "No new notifications", Toast.LENGTH_SHORT).show());

        // Sample behavior for result buttons
        findViewById(R.id.btnViewResult1).setOnClickListener(v ->
                Toast.makeText(this, "Viewing results for SSC President Election", Toast.LENGTH_SHORT).show());

        findViewById(R.id.btnViewResult2).setOnClickListener(v ->
                Toast.makeText(this, "Results not yet available", Toast.LENGTH_SHORT).show());

        findViewById(R.id.btnViewResult3).setOnClickListener(v ->
                Toast.makeText(this, "Viewing results for Finance Officer Election", Toast.LENGTH_SHORT).show());

        findViewById(R.id.btnViewResult4).setOnClickListener(v ->
                Toast.makeText(this, "Viewing results for Finance Officer Election", Toast.LENGTH_SHORT).show());
    }
}
