package com.example.votingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PreviewActivity extends AppCompatActivity {
    private ImageButton btnBack;
    private TextView tvPreviewPresident, tvPreviewVP, tvPreviewSecretary;
    private Button btnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        // 1) Find views
        btnBack = findViewById(R.id.btnBack);
        tvPreviewPresident = findViewById(R.id.tvPreviewPresident);
        tvPreviewVP        = findViewById(R.id.tvPreviewVP);
        tvPreviewSecretary = findViewById(R.id.tvPreviewSecretary);
        btnConfirm         = findViewById(R.id.btnConfirm);

        // 2) Read extras from Intent (passed down the chain)
        Intent incoming = getIntent();
        String pres  = incoming.getStringExtra("selectedPresident");
        String vp    = incoming.getStringExtra("selectedVP");
        String sec   = incoming.getStringExtra("selectedSecretary");

        if (pres != null) tvPreviewPresident.setText("President: " + pres);
        if (vp != null)   tvPreviewVP.setText("Vice-President: " + vp);
        if (sec != null)  tvPreviewSecretary.setText("Secretary: " + sec);

        // 3) Back → return to SecretaryActivity
        btnBack.setOnClickListener(v -> finish());

        // 4) Confirm → go to VoteConfirmationActivity
        btnConfirm.setOnClickListener(v -> {
            // You could show a toast, upload the choices, etc.
            Toast.makeText(PreviewActivity.this, "Vote Submitted!", Toast.LENGTH_SHORT).show();

            Intent confirmIntent = new Intent(PreviewActivity.this, VoteconfirmationActivity.class);
            // Optionally pass a confirmation ID:
            confirmIntent.putExtra("CONFIRM_ID", "VOT-2025-0472-8392");
            startActivity(confirmIntent);
        });
    }
}
