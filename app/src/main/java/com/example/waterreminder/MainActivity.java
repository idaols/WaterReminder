package com.example.waterreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
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

    private float waterAmount;
    private Counter counterDrinkWater;
    private TextView textViewCurrentValue;
    private EditText editTextWaterAmount;
    private Button buttonAddWater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("test", "water");

        setContentView(R.layout.activity_main);

        editTextWaterAmount = findViewById(R.id.editTextWaterAmount);
        textViewCurrentValue = findViewById(R.id.textViewCurrentValue);
        buttonAddWater = (Button) findViewById(R.id.buttonAddWater);

        counterDrinkWater = new Counter();
        updateUI();
    }

    /**
     * This is a method for the button. By pressing the button it will add the added number to
     * total amount.
     * @param view
     */

    public void buttonAddWater(View view) {
        float value = Float.parseFloat(editTextWaterAmount.getText().toString());

        counterDrinkWater.addDrankWater(value);
        updateUI();
    }



    /**
     * This is a method for updating text view component.
     */

    private void updateUI() {
        TextView textView = findViewById(R.id.textViewCurrentValue);
        textView.setText(Float.toString(counterDrinkWater.getDrankWaterValue()));

    }





}