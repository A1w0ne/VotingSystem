package com.example.votingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecretaryActivity extends AppCompatActivity {

    private RadioButton rbCandidate1, rbCandidate2, rbCandidate3;
    private Button btnBack, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secretary);

        // 1) Find views
        rbCandidate1 = findViewById(R.id.rbCandidate1);
        rbCandidate2 = findViewById(R.id.rbCandidate2);
        rbCandidate3 = findViewById(R.id.rbCandidate3);

        btnBack = findViewById(R.id.btnBack);
        btnNext = findViewById(R.id.btnNext);

        // 2) Make them mutually exclusive
        rbCandidate1.setOnClickListener(v -> {
            rbCandidate2.setChecked(false);
            rbCandidate3.setChecked(false);
        });
        rbCandidate2.setOnClickListener(v -> {
            rbCandidate1.setChecked(false);
            rbCandidate3.setChecked(false);
        });
        rbCandidate3.setOnClickListener(v -> {
            rbCandidate1.setChecked(false);
            rbCandidate2.setChecked(false);
        });

        // 3) Back → return to VicePresidentActivity
        btnBack.setOnClickListener(v -> finish());

        // 4) Next → go to PreviewActivity (preview all selections)
        btnNext.setOnClickListener(v -> {
            String selected = null;
            if (rbCandidate1.isChecked()) {
                selected = "Joberta Gerodias";
            } else if (rbCandidate2.isChecked()) {
                selected = "Johnny Kelly";
            } else if (rbCandidate3.isChecked()) {
                selected = "Carcar Loslos";
            }

            if (selected == null) {
                Toast.makeText(SecretaryActivity.this, "Please select a candidate.", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(SecretaryActivity.this, PreviewActivity.class);
            intent.putExtra("selectedSecretary", selected);
            startActivity(intent);
        });
    }
}
