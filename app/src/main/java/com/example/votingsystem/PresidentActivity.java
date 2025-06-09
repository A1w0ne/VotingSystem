package com.example.votingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PresidentActivity extends AppCompatActivity {

    private RadioButton rbCandidate1, rbCandidate2, rbCandidate3;
    private Button btnBack, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_president);

        // 1) Find each RadioButton & Button by ID
        rbCandidate1 = findViewById(R.id.rbCandidate1);
        rbCandidate2 = findViewById(R.id.rbCandidate2);
        rbCandidate3 = findViewById(R.id.rbCandidate3);

        btnBack = findViewById(R.id.btnBack);
        btnNext = findViewById(R.id.btnNext);

        // 2) Make the three radio buttons mutually exclusive (manual group)
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

        // 3) “Back” → just finish() to return to ElectionActivity
        btnBack.setOnClickListener(v -> finish());

        // 4) “Next” → check which one is checked, then go to VicePresidentActivity
        btnNext.setOnClickListener(v -> {
            String selected = null;
            if (rbCandidate1.isChecked()) {
                selected = "Sarah Johnson";
            } else if (rbCandidate2.isChecked()) {
                selected = "Johnny Boi";
            } else if (rbCandidate3.isChecked()) {
                selected = "Edward Enriquez";
            }

            if (selected == null) {
                Toast.makeText(PresidentActivity.this, "Please select a candidate.", Toast.LENGTH_SHORT).show();
                return;
            }

            // Optionally pass the selected president name via Intent:
            Intent intent = new Intent(PresidentActivity.this, VicepresidentActivity.class);
            intent.putExtra("selectedPresident", selected);
            startActivity(intent);
        });
    }
}
