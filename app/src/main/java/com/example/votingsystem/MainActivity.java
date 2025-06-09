package com.example.votingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private EditText editTextStudentID, editTextPassword;
    private MaterialButton buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextStudentID = findViewById(R.id.editTextStudentID);
        editTextPassword  = findViewById(R.id.editTextPassword);
        buttonLogin       = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(view -> {
            String studentId = editTextStudentID.getText().toString().trim();
            String password  = editTextPassword.getText().toString().trim();

            if (studentId.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter both Student ID and Password", Toast.LENGTH_SHORT).show();
            } else {
                // Bypass actual validation for now → go to Dashboard
                Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                intent.putExtra("STUDENT_ID", studentId);
                startActivity(intent);
                finish();
            }
        });
    }
}
