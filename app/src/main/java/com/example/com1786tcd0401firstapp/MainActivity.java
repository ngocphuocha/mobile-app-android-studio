package com.example.com1786tcd0401firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView helloText = findViewById(R.id.textHello);

        TextView markPoint = findViewById(R.id.markPoint);
        helloText.setText("Hello world");

        int mark = 0;

        Random r = new Random();
        mark = r.nextInt(100);
        mark += 1;

        markPoint.setText("" + mark); // Display mark point

        if (mark < 50) {
            helloText.setText("Sorry you failed");
            helloText.setTextColor(Color.RED);
        } else if (mark > 70) {
            helloText.setText("Brilliant, you got a distinction");
            helloText.setTextColor(Color.parseColor("#239B56"));
        } else {
            helloText.setText("Well done you passed");
            helloText.setTextColor(Color.GREEN);
        }
    }
}