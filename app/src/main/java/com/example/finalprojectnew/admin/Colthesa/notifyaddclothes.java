package com.example.finalprojectnew.admin.Colthesa;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class notifyaddclothes extends Application {
    final static String CHANNEL_ID = "MyChannelID";

    @Override
    public void onCreate() {
        super.onCreate();
        //Create Notification Channel
        createNotificationChannel();
    }

    private void createNotificationChannel() {
        //create channel for only API 26 and Higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel myChannel = new NotificationChannel(CHANNEL_ID, "My Channel",
                    NotificationManager.IMPORTANCE_DEFAULT);
            myChannel.setDescription("This is my  channel");

            //get the service of Notifications App
            NotificationManager manager = getSystemService(NotificationManager.class);

            //create the notification channel in the Notifications App
            manager.createNotificationChannel(myChannel);
        }
    }
}
