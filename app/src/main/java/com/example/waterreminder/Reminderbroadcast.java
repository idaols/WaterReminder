package com.example.waterreminder;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

/**
 *BroadcastReceiver class
 * @author Henna
 */

public class Reminderbroadcast extends BroadcastReceiver {

    /**
     *BroadcastReceiver set for running the code to display the notification
     * @param context
     * @param intent
     */

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "notifyLemubit")
                .setSmallIcon(R.drawable.ic_baseline_add_alert_24)
                .setContentTitle("WaterPal reminder")
                .setContentText("Hey, remember to drink water and update it to your calendar!")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);


        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        notificationManager.notify( 200, builder.build());

    }
}
