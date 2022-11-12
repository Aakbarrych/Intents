package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView getNumber;
    EditText input;
    Button generateBtn;
    TextView code;
    Button submit;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        input = findViewById(R.id.number_input);
        getNumber = findViewById(R.id.result_number);
        generateBtn = findViewById(R.id.generate_btn);
        code = findViewById(R.id.random_code);
        submit = findViewById(R.id.submit_btn);
        Random randomCode = new Random();
        generateBtn.setOnClickListener(view -> {
            code.setText(String.valueOf(randomCode.nextInt(999999)));
        });
        Intent intent = getIntent();
        String str = intent.getStringExtra("number");
        getNumber.setText(str);
        submit.setOnClickListener(view -> {
            if (input.getText().toString().equals(code.getText())){
                Intent intent1 = new Intent(SecondActivity.this, ThirdActivity.class);
                intent1.putExtra("nums", getNumber.getText().toString());
                startActivity(intent1);
            }else{
                Toast.makeText(getApplicationContext(), "неправильный код", Toast.LENGTH_SHORT).show();
            }
        });
    }
}