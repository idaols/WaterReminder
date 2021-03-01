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
     * This is a method for the button. By pressing the button it will add the added number to
     * total amount.
     */

    public void setEditTextAddWater() {
        EditText editWater = findViewById(R.id.editTextAddWater);
        String water = editWater.getText().toString();
    }
    public void buttonAddWater(View view) {
        setEditTextAddWater();
        counterDrinkWater.addDrankWater();
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