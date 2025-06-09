package com.example.votingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class VicepresidentActivity extends AppCompatActivity {

    private RadioButton rbCandidate1, rbCandidate2, rbCandidate3;
    private Button btnBack, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vicepresident);

        // 1) Find views
        rbCandidate1 = findViewById(R.id.rbCandidate1);
        rbCandidate2 = findViewById(R.id.rbCandidate2);
        rbCandidate3 = findViewById(R.id.rbCandidate3);

        btnBack = findViewById(R.id.btnBack);
        btnNext = findViewById(R.id.btnNext);

        // 2) Mutually exclusive
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

        // 3) Back → return to PresidentActivity
        btnBack.setOnClickListener(v -> finish());

        // 4) Next → go to SecretaryActivity
        btnNext.setOnClickListener(v -> {
            String selected = null;
            if (rbCandidate1.isChecked()) {
                selected = "Dwayne Dayrit";
            } else if (rbCandidate2.isChecked()) {
                selected = "Johnny Gurl";
            } else if (rbCandidate3.isChecked()) {
                selected = "Edward Gil";
            }

            if (selected == null) {
                Toast.makeText(VicepresidentActivity.this, "Please select a candidate.", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(VicepresidentActivity.this, SecretaryActivity.class);
            intent.putExtra("selectedVP", selected);
            startActivity(intent);
        });
    }
}
