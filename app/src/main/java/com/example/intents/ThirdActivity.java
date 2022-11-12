package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    TextView phoneNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        phoneNumber = findViewById(R.id.result_number);
        Intent intent1 = getIntent();
        String str = intent1.getStringExtra("nums");
        phoneNumber.setText(str);
    }
}