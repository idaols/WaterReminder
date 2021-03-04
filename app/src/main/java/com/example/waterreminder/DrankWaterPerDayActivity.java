package com.example.waterreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DrankWaterPerDayActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drank_water_per_day);



        /**
         * Returns the drank water amount from CalendarView when that day is pressed
         */
        Intent intent = getIntent();



    }
}