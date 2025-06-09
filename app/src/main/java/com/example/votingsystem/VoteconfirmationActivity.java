package com.example.votingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VoteconfirmationActivity extends AppCompatActivity {

    private ImageButton backButton;
    private Button btnHome;
    private TextView tvConfirmId;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voteconfirmation);

        // 1) Find the views by their IDs in the XML
        backButton = findViewById(R.id.backButton);
        btnHome    = findViewById(R.id.btnHome);       // newly added “Home” button
        tvConfirmId= findViewById(R.id.tvConfirmId);
        btnLogout  = findViewById(R.id.btnLogout);

        // 2) If the launching Intent carried a CONFIRM_ID extra, display it
        Intent incoming = getIntent();
        String confirmId = incoming.getStringExtra("CONFIRM_ID");
        if (confirmId != null) {
            tvConfirmId.setText(confirmId);
        }

        // 3) “Back” → simply finish() to return to the previous screen (e.g. PreviewActivity)
        backButton.setOnClickListener(v -> finish());

        // 4) “Home” → navigate to DashboardActivity (preserving no back‐stack)
        btnHome.setOnClickListener(v -> {
            Intent homeIntent = new Intent(VoteconfirmationActivity.this, DashboardActivity.class);
            // Clear any intermediate activities if needed, so pressing back won’t return here
            homeIntent.setFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP |
                            Intent.FLAG_ACTIVITY_SINGLE_TOP
            );
            startActivity(homeIntent);
            finish();
        });

        // 5) “Logout” → go to MainActivity (login screen), clear everything
        btnLogout.setOnClickListener(v -> {
            Intent logoutIntent = new Intent(VoteconfirmationActivity.this, MainActivity.class);
            logoutIntent.setFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TASK |
                            Intent.FLAG_ACTIVITY_NEW_TASK
            );
            startActivity(logoutIntent);
            // No need to call finish() here because CLEAR_TASK|NEW_TASK removes this activity
        });
    }
}
