package com.example.waterreminder;

import androidx.appcompat.app.AppCompatActivity;

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
    private EditText editTextAddWater;
    private Button buttonAddWater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("test", "water");
        setContentView(R.layout.activity_main);

        editTextAddWater = findViewById(R.id.editTextAddWater);
        textViewCurrentValue = findViewById(R.id.textViewCurrentValue);
        buttonAddWater = findViewById(R.id.buttonAddWater);

        counterDrinkWater = new Counter();
        updateUI();
    }

    /**
     * Method for add button.
     * @param view
     */

    public void addWaterButton(View view) {
        counterDrinkWater.addDrankWater();
        updateUI();
    }

    /**
     * Method for updating the amount of water.
     */

    private void updateUI() {
        TextView tv = findViewById(R.id.textViewCurrentValue);
        tv.setText(Float.toString(counterDrinkWater.getDrankWaterValue()));

    }
}