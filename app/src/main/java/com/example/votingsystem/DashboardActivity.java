package com.example.votingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    // These must match IDs in activity_dashboard.xml
    private LinearLayout navHome;
    private LinearLayout navProfile;
    private LinearLayout navOngoing;
    private LinearLayout navUpcoming;
    private LinearLayout navClosed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // 1) Find each bottom‐navigation “card” by its ID:
        navHome     = findViewById(R.id.navHome);
        navProfile  = findViewById(R.id.navProfile);
        navOngoing  = findViewById(R.id.navOngoing);
        navUpcoming = findViewById(R.id.navUpcoming);
        navClosed   = findViewById(R.id.navClosed);

        // 2) “Home” button logic: We’re already on Dashboard, so just show a Toast
        navHome.setOnClickListener(v ->
                Toast.makeText(DashboardActivity.this, "Already on Home", Toast.LENGTH_SHORT).show()
        );

        // 3) “Profile” button logic: Launch ProfileActivity
        navProfile.setOnClickListener(v -> {
            Toast.makeText(DashboardActivity.this, "Opening Profile...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DashboardActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        // 4) “Ongoing Elections” button logic:
        //    We want to go straight to the PresidentActivity screen.
        navOngoing.setOnClickListener(v -> {
            Toast.makeText(DashboardActivity.this, "Opening President Election...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DashboardActivity.this, PresidentActivity.class);
            startActivity(intent);
        });

        // 5) “Upcoming Elections” button logic: Launch UpcomingelectionsActivity
        navUpcoming.setOnClickListener(v -> {
            Toast.makeText(DashboardActivity.this, "Opening Upcoming Elections...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DashboardActivity.this, UpcomingelectionsActivity.class);
            startActivity(intent);
        });

        // 6) “Closed Elections” button logic: Launch CloseelectionActivity
        navClosed.setOnClickListener(v -> {
            Toast.makeText(DashboardActivity.this, "Opening Closed Elections...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DashboardActivity.this, CloseelectionActivity.class);
            startActivity(intent);
        });
    }
}
