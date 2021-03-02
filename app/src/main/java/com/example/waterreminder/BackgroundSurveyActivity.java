package com.example.waterreminder;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This class is for the background survey. It will appear only once when user downloads and opens
 * the app for the first time.
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
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        counterEstimate = new Counter();

        textViewEstimateAmount = findViewById(R.id.textViewEstimateAmount);
        editTextAge = findViewById(R.id.editTextAge);
        editTextWeight = findViewById(R.id.editTextWeight);
        buttonSave = findViewById(R.id.buttonSave);

        updateUI();
    }

    /**
     * Method for save button. When user fills the info and presses the save button, it will
     * calculate the estimated water amount and save the data for later usage.
     * @param view
     */

    public void buttonSave(View view) {

        EditText editAge = findViewById(R.id.editTextAge);
        Integer age = Integer.parseInt(editAge.getText().toString());
        Integer weight = Integer.parseInt(editTextWeight.getText().toString());

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
