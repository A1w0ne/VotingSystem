package com.example.votingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ElectionActivity extends AppCompatActivity {

    private LinearLayout navHome, navProfile;
    private LinearLayout navStudentCouncil, navDeptReps, navFacultyBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elections);

        // Bottom‐tab navigation (Home / Profile) if you need them:
        navHome = findViewById(R.id.navHome);
        navProfile = findViewById(R.id.navProfile);

        navHome.setOnClickListener(v ->
                Toast.makeText(ElectionActivity.this, "Returning to Home...", Toast.LENGTH_SHORT).show()
        );

        navProfile.setOnClickListener(v ->
                        Toast.makeText(ElectionActivity.this, "Opening Profile...", Toast.LENGTH_SHORT).show()
                // startActivity(new Intent(ElectionActivity.this, ProfileActivity.class));
        );

        // === Find each “card” by ID ===
        navStudentCouncil = findViewById(R.id.navStudentCouncil);
        navDeptReps       = findViewById(R.id.navDeptReps);
        navFacultyBoard   = findViewById(R.id.navFacultyBoard);

        // 1) Student Council card → PresidentActivity
        navStudentCouncil.setOnClickListener(v -> {
            Intent intent = new Intent(ElectionActivity.this, PresidentActivity.class);
            startActivity(intent);
        });

        // 2) Department Reps card → VicePresidentActivity (if you want)
        navDeptReps.setOnClickListener(v -> {
            Intent intent = new Intent(ElectionActivity.this, VicepresidentActivity.class);
            startActivity(intent);
        });

        // 3) Faculty Board card → SecretaryActivity (if you want)
        navFacultyBoard.setOnClickListener(v -> {
            Intent intent = new Intent(ElectionActivity.this, SecretaryActivity.class);
            startActivity(intent);
        });
    }
}
