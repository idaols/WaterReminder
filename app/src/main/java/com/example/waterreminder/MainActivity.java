package com.example.waterreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Jenna
 * This main class implements the apps main screen, where can be added the amount of drunk water.
 */
public class MainActivity extends AppCompatActivity {

    //private Counter counterDrinkWater;

    private TextView textViewWaterTotal;
    private Number numberWater;
    private Button buttonAddWater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //textViewWaterTotal = findViewById(R.id.counterDrinkWater);
        //counterDrinkWater = new Counter();
        //updateUI;
    }

    /**
     * This is a method for the button. By pressing the button it will add the added number to
     * total amount.
     * @param view
     */

    public void buttonAddWater(View view) {
        //counterDrinkWater.plus();
        //updateUI();
    }

    /**
     * This is a method for updating text view component.
     */

    private void updateUI() {
        TextView textView = findViewById(R.id.textViewWaterTotal);
        //textView.setText(Integer.toString(counterDrinkWater.getValue()));
    }



}