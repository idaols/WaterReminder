package com.example.waterreminder;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class BackgroundSurveyActivity extends AppCompatActivity {

    private EditText editTextAge;
    private EditText editTextWeight;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAge = findViewById(R.id.editTextAge);
        editTextWeight = findViewById(R.id.editTextWeight);
        buttonSave = findViewById(R.id.buttonSave);
    }


}
