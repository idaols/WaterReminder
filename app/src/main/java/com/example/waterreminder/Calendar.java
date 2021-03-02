package com.example.waterreminder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

import com.google.android.material.tabs.TabLayout;

public class Calendar extends AppCompatActivity {

    private CalendarView calendarView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        //calendarView = findViewById(R.id.calendarView);

        Intent intent = getIntent();



    }
}