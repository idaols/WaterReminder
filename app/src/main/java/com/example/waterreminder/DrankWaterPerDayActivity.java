package com.example.waterreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DrankWaterPerDayActivity extends AppCompatActivity {

    private TextView dailyAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drank_water_per_day);

        dailyAmount = findViewById(R.id.textViewTheDate);
        dailyAmount.setText("Kukkuu");

        Intent intent = getIntent();



    }
}