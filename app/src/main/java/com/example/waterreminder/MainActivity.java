package com.example.waterreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author Jenna
 * This main class implements the apps main screen, where user can add the amount of drunk water.
 */
public class MainActivity extends AppCompatActivity {

    //Laskuri puuttuu
    //private Counter counterDrinkWater;

    private TextView textViewWaterTotal;
    private Number numberWater;
    private Button buttonAddWater;

    public static final String EXTRA_MESSAGE = "com.example.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Laskuri puuttuu
        //textViewWaterTotal = findViewById(R.id.counterDrinkWater);
        //counterDrinkWater = new Counter();
        //updateUI;
    }

    /**
     * This method is for background survey. It will appear only once when the user opens the app
     * for the first time.
     * @param view
     */
    public void okSurvey(View view) {
        Intent intent = new Intent(this, BackgroundSurveyActivity.class);
        EditText editAge = (EditText) findViewById(R.id.editTextAge);
        String age = editAge.getText().toString();
        EditText editWeight = (EditText) findViewById(R.id.editTextWeight);
        String weight = editWeight.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, "");
        startActivity(intent);

    }

    /**
     * This is a method for the button. By pressing the button it will add the added number to
     * total amount.
     * @param view
     */

    public void buttonAddWater(View view) {
        //Laskuri puuttuu
        //counterDrinkWater.plus();
        //updateUI();
    }

    /**
     * This is a method for updating text view component.
     */

    private void updateUI() {

        //Laskuri puuttuu
        TextView textView = findViewById(R.id.textViewWaterTotal);
        //textView.setText(Integer.toString(counterDrinkWater.getValue()));
    }





}