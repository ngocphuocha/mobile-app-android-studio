package com.example.com1786tcd0401firstapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.time.LocalDate;


public class MainActivity extends AppCompatActivity {
    private final String[] workStatus = {
            "Full Time",
            "Part Time",
            "Unemployment"
    };

    private CheckBox checkBoxAgreement;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Spinner spinnerWorkStatus = (Spinner) findViewById(R.id.spinnerWorkStatus);
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, workStatus);
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerWorkStatus.setAdapter((dataAdapter));

//        Spinner spinnerWorkStatus = (Spinner) findViewById(R.id.spinnerWorkStatus);
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, workStatus);
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerWorkStatus.setAdapter((dataAdapter));
        Spinner spinnerWorkStatus = findViewById(R.id.spinnerWorkStatus);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, workStatus);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerWorkStatus.setAdapter((dataAdapter));
    }

    public void showDatePickerDialog(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void updateDOB(LocalDate dob) {
        TextView dobText = (TextView) findViewById(R.id.inputDob);
        dobText.setText(dob.toString());
    }

}