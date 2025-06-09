package com.example.votingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class ProfileActivity extends AppCompatActivity {

    private TextView tvUserName, tvUserID, tvProgram, tvYear, tvEmail;
    private MaterialButton btnLogout;
    private ImageButton backButton;
    private ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize views
        tvUserName = findViewById(R.id.tvUserName);
        tvUserID = findViewById(R.id.tvUserID);
        tvProgram = findViewById(R.id.tvProgram);
        tvYear = findViewById(R.id.tvYear);
        tvEmail = findViewById(R.id.tvEmail);
        btnLogout = findViewById(R.id.btnLogout);
        backButton = findViewById(R.id.backButton);
        imgLogo = findViewById(R.id.imgLogo);

        // Get student ID from intent
        Intent intent = getIntent();
        String studentId = intent.getStringExtra("STUDENT_ID");
        if (studentId != null) {
            tvUserID.setText("Student ID: " + studentId);
            tvUserName.setText("Welcome, " + studentId);
        }

        // Handle logo click (optional)
        imgLogo.setOnClickListener(v ->
                Toast.makeText(this, "STI Logo Clicked", Toast.LENGTH_SHORT).show()
        );

        // Back to Dashboard
        backButton.setOnClickListener(v -> {
            Intent intentBack = new Intent(ProfileActivity.this, DashboardActivity.class);
            intentBack.putExtra("STUDENT_ID", studentId); // Pass ID if needed
            startActivity(intentBack);
            finish();
        });

        // Logout to MainActivity
        btnLogout.setOnClickListener(v -> {
            Toast.makeText(this, "Logging out...", Toast.LENGTH_SHORT).show();
            Intent logoutIntent = new Intent(ProfileActivity.this, MainActivity.class);
            logoutIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(logoutIntent);
        });
    }
}
