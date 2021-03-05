package com.example.waterreminder;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;
import java.util.prefs.Preferences;
import java.util.prefs.PreferencesFactory;

public class CalendarActivity extends AppCompatActivity {

    private static final String TAG = "CalendarActivity";

    private CalendarView mCalendarView;
    private TextView theDate;

    public static final String SHARED_PREFS_WATER = "shared prefs water";

    /**
     * Shows calendar view and current day
     * when pressed any day on calendar it shows another activity which shows drank water amount that day
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_layout);

        mCalendarView = (CalendarView) findViewById(R.id.calendarView);

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                String date = (i1) + "/" + i2 + "/" + i;
                Log.d(TAG, "onSelectedDayChange: mm/dd/yyyy " + date);

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_WATER, MODE_PRIVATE);
                //SharedPreferences.Editor editor = sharedPreferences.edit();


                theDate = findViewById(R.id.textViewDate);
                theDate.setText(Float.toString(sharedPreferences.getFloat(date, 0)));



                //Intent intent = new Intent(CalendarActivity.this, DrankWaterPerDayActivity.class);
                //startActivity(intent);
            }


        });

    }
}
