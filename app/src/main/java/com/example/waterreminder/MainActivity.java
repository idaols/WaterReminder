package com.example.waterreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static android.provider.Settings.System.DATE_FORMAT;

/**
 * @author Jenna
 * This main class implements the apps main screen, where user can add the amount of drunk water.
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Counter counterDrinkWater;

    private TextView textViewCurrentValue;
    private TextView theDate;
    private EditText editTextWaterAmount;
    private Button buttonAddWater;
    private Button buttonGraph;
    private Button buttonCalendar;

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
        buttonAddWater = findViewById(R.id.buttonAddWater);
        buttonGraph = findViewById(R.id.buttonGraph);
        theDate = (TextView) findViewById(R.id.date);
        buttonCalendar = (Button) findViewById(R.id.buttonCalendar);



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
        Log.d("moro", "day");

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

    public void buttonGraph(View view) {

    }

    public void goToCalendar (View view) {
        Intent intent = new Intent(this, Calendar.class);
        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
        startActivity(intent);
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