package com.example.com1786tcd0401firstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;


public class MainActivity extends AppCompatActivity {
    private final String[] workStatusArray = {
            "Full Time",
            "Part Time",
            "Unemployment"
    };

    private Spinner spinnerWorkStatus;
    private CheckBox checkBoxAgreement;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerWorkStatus = findViewById(R.id.spinnerWorkStatus);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, workStatusArray);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerWorkStatus.setAdapter((dataAdapter));

        Toolbar toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);

        final Button btnSave = findViewById(R.id.buttonSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBoxAgreement = findViewById(R.id.checkBoxAgreement);

                if (!checkBoxAgreement.isChecked()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "You must agree to the terms", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }

                getInputs();
            }
        });
    }

    private void getInputs() {
        EditText nameInput = findViewById(R.id.inputName);
        EditText phoneInput = findViewById(R.id.inputPhone);
        EditText emailInput = findViewById(R.id.inputEmail);
        spinnerWorkStatus = findViewById(R.id.spinnerWorkStatus);

        String strName = nameInput.getText().toString();
        String strPhone = phoneInput.getText().toString();
        String strEmail = emailInput.getText().toString();
        String strWorkStatus = spinnerWorkStatus.getSelectedItem().toString();

        displayNextAlert(strName, strPhone, strEmail, strWorkStatus);
    }

    private void displayNextAlert(String strName, String strPhone, String strEmail, String strWork) {
        new AlertDialog.Builder(this).setTitle("Details entered").setMessage("Details entered: " +
                "\n" + strName +
                "\n" + strPhone +
                "\n" + strEmail +
                "\n" + strWork).setNeutralButton("Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).show();
    }

    @Override
    public boolean onOptionsItemSelected(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemNext:
                getInputs();
                return true;
            case R.id.itemExit:
                Toast.makeText(this, "You asked to exit, but why not start another app?", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}