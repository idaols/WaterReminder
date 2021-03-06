package com.example.waterreminder;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;
import java.util.prefs.Preferences;
import java.util.prefs.PreferencesFactory;

/**
 * This class is for calendar, user can see daily water consumption day by day and set
 * alarm to remember to drink.
 *
 * For the notifications system we used YouTube tutorial: 
 *
 * @author Henna
 */

public class CalendarActivity extends AppCompatActivity {

    private static final String TAG = "CalendarActivity";

    private CalendarView mCalendarView;
    private TextView theDate;


    public static final String SHARED_PREFS_WATER = "shared prefs water";

    /**
     * Shows calendar view and current day
     * when pressed any day on calendar it shows the drank water amount of that day under the calendar
     */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_layout);
        createNotificationChannel();

        ImageButton remindMe = findViewById(R.id.imageButtonReminder);

        mCalendarView = (CalendarView) findViewById(R.id.calendarView);

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                String date = (i1) + "/" + i2 + "/" + i;
                Log.d(TAG, "onSelectedDayChange: mm/dd/yyyy " + date);

                SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS_WATER, MODE_PRIVATE);

                theDate = findViewById(R.id.textViewDate);
                theDate.setText(Float.toString(sharedPreferences.getFloat(date, 0)) + " ml");

            }


        });

        /**
         * When reminder button pressed, pops up toast message and alarm set in 10 seconds
         * time is set to 10 seconds because we can show it on emulator presentation
         * normally it would be set to 100000 * 72 = 2 hours
         */

        remindMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CalendarActivity.this, "Reminder Set!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(CalendarActivity.this, Reminderbroadcast.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(CalendarActivity.this, 0, intent, 0);

                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                long timeAtButtonClick = System.currentTimeMillis();

                long tenSecondsInMillis = 1000 * 10;

                /**
                 * RTC_WAKEUP wakes up the device to fire the pending intent at the specific time
                  */
                alarmManager.set(AlarmManager.RTC_WAKEUP, timeAtButtonClick + tenSecondsInMillis, pendingIntent);
            }
        });
    }

    /**
     * Method for creating notification channel
     * Channel id from Lemubit youtube tutorial
     */
    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "LemubitReminderChannel";
            String description = "Channel for WaterPal reminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notifyLemubit", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }





}


