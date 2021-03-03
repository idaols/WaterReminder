package com.example.waterreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author Jenna
 * This main class implements the apps main screen, where user can add the amount of drunk water.
 */
public class MainActivity extends AppCompatActivity {

    private Counter counterDrinkWater;

    private TextView textViewCurrentValue;
    private EditText editTextWaterAmount;
    private Button buttonAddWater;
    private Button buttonGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("test", "water");
        setContentView(R.layout.activity_main);

        editTextWaterAmount = findViewById(R.id.editTextWaterAmount);
        textViewCurrentValue = findViewById(R.id.textViewCurrentValue);
        buttonAddWater = findViewById(R.id.buttonAddWater);
        buttonGraph = findViewById(R.id.buttonGraph);

        counterDrinkWater = new Counter();
        updateUI();
    }

    /**
     * Method for add button. By pressing the button it will add the added number to
     * total amount
     * @param view
     */

    public void buttonAddWater(View view) {
        float value = Float.parseFloat(editTextWaterAmount.getText().toString());
        counterDrinkWater.addDrankWater(value);
        updateUI();
    }

    public void buttonSettings(View view) {
        Intent intent = new Intent(this, BackgroundSurveyActivity.class);
        startActivity(intent);

    }

    public void buttonGraph(View view) {


    }

    /**
     * Method for updating text view component.
     */

    private void updateUI() {
        TextView tv = findViewById(R.id.textViewCurrentValue);
        tv.setText(Float.toString(counterDrinkWater.getDrankWaterValue()));

    }
}