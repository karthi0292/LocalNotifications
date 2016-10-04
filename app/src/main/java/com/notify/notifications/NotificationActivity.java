package com.notify.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

public class NotificationActivity extends AppCompatActivity {

     NotificationManager notificationManager;
    private Notification notification;
    private NotificationCompat.Builder notifyBuilder;
    String name = "karthi";
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notification = new NotificationCompat.Builder(getApplicationContext()).setContentTitle(i + " New Msg").setSmallIcon(R.mipmap.ic_launcher).setGroup("Group").setContentText("Hai hello" + i).build();
                notificationManager.notify(i, notification);

                i++;
                handler.postDelayed(this, 60000);
            }
        };
        handler.post(runnable);
    }
}
