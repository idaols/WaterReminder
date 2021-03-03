package com.example.waterreminder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This class is for the background survey settings. Settings are saved with "Save"- button and will
 * appear when user goes back to setting. Info can be updated and saved again.
 * @author Jenna
 */

public class BackgroundSurveyActivity extends AppCompatActivity {

    private Counter counterEstimate;

    private TextView textViewEstimateAmount;
    private EditText editTextAge;
    private EditText editTextWeight;
    private Button buttonSave;

    public static final String SHARED_PREFS = "shared prefs";
    public static final String AGE_LOG = "saved age";
    public static final String WEIGHT_LOG = "saved weight";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background_survey);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //arrow back to home screen.

        Intent intent = getIntent();

        counterEstimate = new Counter();

        textViewEstimateAmount = findViewById(R.id.textViewEstimateAmount);
        editTextAge = findViewById(R.id.editTextAge);
        editTextWeight = findViewById(R.id.editTextWeight);
        buttonSave = findViewById(R.id.buttonSave);

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        int age = sharedPreferences.getInt(AGE_LOG, 0);
        editTextAge.setText(Integer.toString(age));
        int weight = sharedPreferences.getInt(WEIGHT_LOG, 0);
        editTextWeight.setText(Integer.toString(weight));
        counterEstimate.countWaterAmount(age, weight);

        updateUI();
    }

    /**
     * Method for save button. When user fills the info and presses the save button, it will
     * calculate the estimated water amount and save the data for later use.
     * @param view
     */

    public void buttonSave(View view) {
        Log.d("testi", "nappia painttu");

        EditText editAge = findViewById(R.id.editTextAge);
        Integer age = Integer.parseInt(editAge.getText().toString());
        EditText editWeight = findViewById(R.id.editTextWeight);
        Integer weight = Integer.parseInt(editTextWeight.getText().toString());

        counterEstimate.countWaterAmount(age, weight);
        updateUI();

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt(AGE_LOG, age);
        editor.putInt(WEIGHT_LOG, weight);
        editor.commit();
    }

    /**
     * Method for updating the text view component.
     */

    public void updateUI() {
        TextView textView = findViewById(R.id.textViewEstimateAmount);
        textView.setText(Float.toString(counterEstimate.getWaterAmount()));
    }


}
