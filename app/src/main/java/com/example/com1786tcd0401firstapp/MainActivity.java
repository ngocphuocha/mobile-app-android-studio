package com.example.com1786tcd0401firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import java.util.jar.Attributes;



public class MainActivity extends AppCompatActivity {
    private EditText nameText;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView helloText = findViewById(R.id.textHello);

        nameText = (EditText) findViewById(R.id.name);
    }

    public void handleButtonClick(View view) {
        String strName = nameText.getText().toString();

        Intent i = new Intent(this, NameDisplay.class);

        i.putExtra(NameDisplay.NAME, strName);

        startActivity(i);
    }
}