package com.example.cloner93.time_project;

/**
 * Created by cloner93 on 6/16/16.
 */
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

public class AlarmReciever extends BroadcastReceiver {
    public static String comment;
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub

        Log.e("onReceive", "Alarm down!!!");
        Toast.makeText(context, "OnReceive alarm test", Toast.LENGTH_SHORT).show();

        NotificationCompat.Builder mBuilder =new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.ic_notifications_active)
                        .setContentTitle(comment).setContentText(comment);
        Intent resultIntent = new Intent(context, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(9011, mBuilder.build());
    }



}