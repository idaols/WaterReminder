package com.example.waterreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;

/**
 * @author Jenna, Ida and Henna
 * This main class implements the apps main screen, where user can add the amount of drunk water.
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Counter counterDrinkWater;

    private TextView textViewCurrentValue;
    private EditText editTextWaterAmount;
    private ImageButton buttonAddWater;
    private ImageButton buttonSettings;
    private Button buttonGraph;
    private ImageButton buttonGoCalendar;


    private SharedPreferences sharedPreferences;
    private final String sharePreferencesName = "weekdayStore";
    private final String weekDay = "weekDay";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("test", "water");
        setContentView(R.layout.activity_main);

        editTextWaterAmount = findViewById(R.id.editTextWaterAmount);
        textViewCurrentValue = findViewById(R.id.textViewCurrentValue);
        buttonGoCalendar = findViewById(R.id.buttonGoCalendar);
        buttonAddWater = findViewById(R.id.imageButtonAdd);
        buttonGraph = findViewById(R.id.buttonGraph);
        buttonSettings = findViewById(R.id.imageButtonSettings);


        /**
         * When calendar button is pressed, starts CalendarActivity
         */
        buttonGoCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalendarActivity.class);
                startActivity(intent);
            }
        });

        counterDrinkWater = new Counter();
        checkDate();
        updateUI();
    }

    /**
     * Method for add button. By pressing the button it will add the added number to
     * total amount
     * @param view
     */

    public void buttonAddWater(View view) {
        Log.d("test", "day");

        try {
            float value = Float.parseFloat(editTextWaterAmount.getText().toString());
            counterDrinkWater.addDrankWater(value);
        }
        catch (Exception e) {
            float value = 0;
            counterDrinkWater.addDrankWater(value);
        }
        updateUI();
    }

    /**
     * Method for settings button. By pressing this button it will start settings activity.
     * @param view
     */

    public void buttonSettings(View view) {
        Intent intent = new Intent(this, BackgroundSurveyActivity.class);
        startActivity(intent);
    }

    public void buttonGraph(View view) {

    }

    public void checkDate() {
        Calendar dateNow = Calendar.getInstance();
        int weekdayNow = dateNow.get(Calendar.DAY_OF_WEEK);

        sharedPreferences = getSharedPreferences(sharePreferencesName, Activity.MODE_PRIVATE);

        if (!sharedPreferences.contains(weekDay)) {
            SharedPreferences.Editor prefEditor = sharedPreferences.edit();
            prefEditor.putInt(weekDay, dateNow.get(Calendar.DAY_OF_WEEK));
            prefEditor.commit();
        } else {
            SharedPreferences.Editor prefEditor = sharedPreferences.edit();
            if (weekdayNow != sharedPreferences.getInt(weekDay, 0)) {
                resetCalculator();
                prefEditor.putInt(weekDay, dateNow.get(Calendar.DAY_OF_WEEK));
                prefEditor.commit();
            }
        }
    }

    public void resetCalculator() {
        counterDrinkWater.reset();
    }

    /**
     * Method for updating text view component.
     */

    private void updateUI() {
        TextView tv = findViewById(R.id.textViewCurrentValue);
        Float value = counterDrinkWater.getDrankWaterValue();
        if (value == -1) {
            tv.setText("You are drunk!");
        } else {
            tv.setText(Float.toString(counterDrinkWater.getDrankWaterValue()));
        }
    }
}