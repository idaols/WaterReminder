package com.example.waterreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This main class implements the apps main screen, where user can add the amount of drunk water,
 * change setting, view calendar and info page.
 *
 * For the alert dialogue box we used YouTube tutorial: https://www.youtube.com/watch?v=7vWoi8j5vL4
 * @author Jenna, Ida and Henna
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Counter counterDrinkWater;

    private TextView textViewCurrentValue;
    private EditText editTextWaterAmount;
    private ImageButton buttonAddWater;
    private ImageButton buttonSettings;
    private ImageButton buttonReset;
    private ImageButton buttonGoCalendar;
    private ImageButton buttonInfo;

    public SharedPreferences sharedPreferences;
    private final String sharePreferencesName = "weekdayStore";
    private final String weekDay = "weekDay";

    public static final String SHARED_PREFS_WATER = "shared prefs water";
    public static final String WATER_LOG = "saved added water";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("test", "water");
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        counterDrinkWater = new Counter();

        editTextWaterAmount = findViewById(R.id.editTextWaterAmount);
        textViewCurrentValue = findViewById(R.id.textViewCurrentValue);
        buttonGoCalendar = findViewById(R.id.buttonGoCalendar);
        buttonAddWater = findViewById(R.id.imageButtonAdd);
        buttonSettings = findViewById(R.id.imageButtonSettings);
        buttonReset = findViewById(R.id.imageButtonReset);
        buttonInfo = findViewById(R.id.imageButtonInfo);

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_WATER, MODE_PRIVATE);
        float water = sharedPreferences.getFloat(getDate(), 0);
        editTextWaterAmount.setHint("Add water in ml");
        counterDrinkWater.addDrankWater(water);


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

        checkDate();
        updateUI();
    }

    /**
     * Method for add button. By pressing the button it will add the added number to
     * total amount and saves it.
     * @param view
     */

    public void buttonAddWater(View view) {
        Log.d("test", "day");

        EditText editTextWaterAmount = findViewById(R.id.editTextWaterAmount);

        try {
            float value = Float.parseFloat(editTextWaterAmount.getText().toString());
            float total_value = counterDrinkWater.getDrankWaterValue();
            if (value > 6000 || total_value + value >= 7000){
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setCancelable(true);
                builder.setTitle("Wait a minute");
                builder.setMessage("You shouldn't drink that much at a time!\nIf you really did, please contact your doctor.");

                builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();
            }
            else{
                counterDrinkWater.addDrankWater(value);
                Toast.makeText(MainActivity.this, "Good job!", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e) {
            float value = 0;
            counterDrinkWater.addDrankWater(value);
        }

        updateUI();

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_WATER, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        Log.d(TAG, "TimeDisplay: mm/dd/yyyy " + getDate());
        editor.putFloat(getDate(), counterDrinkWater.getDrankWaterValue());
        editor.commit();
    }

    /**
     * Method for getting the current date
     * @return reference to date
     */

    public String getDate() {
        Calendar dateNow = Calendar.getInstance();
        String date = dateNow.get(Calendar.MONTH) + "/" + dateNow.get(Calendar.DAY_OF_MONTH) + "/" + dateNow.get(Calendar.YEAR);
        return date;
    }

    /**
     * Method for settings button. By pressing this button it will start settings activity.
     * @param view
     */

    public void buttonSettings(View view) {
        Intent intent = new Intent(this, BackgroundSurveyActivity.class);
        startActivity(intent);
    }

    /**
     * Method for info button. By pressing this button it will display info activity.
     * @param view
     */

    public void buttonInfo (View view) {
        Intent intent = new Intent(this, InfoText.class);
        startActivity(intent);
    }

    /**
     * Method for reset button. By pressing this button it will reset the drank water calculator.
     * @param view
     */
    public void buttonReset(View view) {
        counterDrinkWater.reset();

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_WATER, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putFloat(getDate(), 0);
        editor.commit();

        updateUI();
    }

    /**
     * Method for checking which weekday it currently is so calculator can reset itself for the next day.
     * Resetting happens at midnight when the day changes.
     */

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

    /**
     * Method for resetting the main calculator.
     */

    public void resetCalculator() {
        counterDrinkWater.reset();
        updateUI();
    }

    /**
     * Method for updating text view component.
     */

    private void updateUI() {
        TextView tv = findViewById(R.id.textViewCurrentValue);
        Float value = counterDrinkWater.getDrankWaterValue();
        if (value == -1) {
            ;
        } else {
            tv.setText(Float.toString(counterDrinkWater.getDrankWaterValue()));
        }
    }
}