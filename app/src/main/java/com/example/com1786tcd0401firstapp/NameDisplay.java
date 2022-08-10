package com.example.com1786tcd0401firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NameDisplay extends AppCompatActivity {

    public static final String NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_display);

        TextView myText = (TextView) findViewById(R.id.showName);

        Bundle extras = getIntent().getExtras();

        if (extras == null) return;

        String name = extras.getString(NAME);

        if (name.isEmpty()) {
            myText.setText("The name is empty");
            return; // Exit program
        }

        myText.setText((getString(R.string.hello) + " " + name));

    }
}