package com.example.a15017206.demonotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int requestCode = 123;
    int notificationID = 888;

    Button btnNotify1, btnNotify2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotify1 = (Button) findViewById(R.id.btnNotify1);
        btnNotify2 = (Button) findViewById(R.id.btnNotify2);

        btnNotify1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);

                PendingIntent pIntent = PendingIntent.getActivity(MainActivity.this, requestCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                // Build notification
                Notification.Builder builder = new Notification.Builder(MainActivity.this);
                builder.setContentTitle("Amazing Offer!");
                builder.setContentText("Subject");
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentIntent(pIntent);
                builder.setAutoCancel(true);

                //Adding sound to the notification
                Uri uri = RingtoneManager.getDefaultUri
                        (RingtoneManager.TYPE_NOTIFICATION);
                builder.setSound(uri);

                //Heads up notification, to grab user's attention
                builder.setPriority(Notification.PRIORITY_HIGH);

                Notification n = builder.build();
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                // A good to have id, in case you want to cancel it
                // programmatically later on
                notificationManager.notify(notificationID, n);
                finish();
            }
        });

        btnNotify2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);

                PendingIntent pIntent = PendingIntent.getActivity (MainActivity.this, requestCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                Notification.BigTextStyle bigText = new Notification.BigTextStyle();
                bigText.bigText(" Lorem ipsum dolor sit amet, \n consectetur adipiscing elit. Pellentesque porttitor facilisis ipsum, in consectetur elit tincidunt ac. Donec pretium sed libero sit amet ultrices. In sit amet venenatis lectus, nec malesuada nisl. Mauris ac iaculis nisi. Maecenas quam ex, dictum quis dapibus sit amet, tempor nec tortor. In hac habitasse platea dictumst. Morbi non eleifend orci. Praesent nulla sem, facilisis sit amet odio sit amet, ultricies rutrum nulla. Proin risus odio, pulvinar vel lorem non, commodo tristique elit. Morbi mi mauris, commodo sed ex nec, congue cursus justo. Phasellus ligula ipsum, convallis vitae dolor vel, sollicitudin fermentum mauris. Aliquam egestas nisl dolor, ut efficitur neque sagittis a. Donec malesuada placerat libero ac hendrerit. Nam non erat volutpat, sagittis neque ac, gravida tortor. ");
                bigText.setBigContentTitle("Big Text – Long Content.");
                bigText.setSummaryText("Reflection Journal?");




                // Build notification
                Notification.Builder builder = new Notification.Builder(MainActivity.this);
                builder.setContentTitle("Amazing Offer!");
                builder.setContentText("Subject");
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentIntent(pIntent);
                builder.setStyle(bigText);
                builder.setAutoCancel(true);
                builder.setPriority(Notification.PRIORITY_MAX);

                Uri uri= RingtoneManager.getDefaultUri
                        (RingtoneManager.TYPE_NOTIFICATION);
                builder.setSound(uri);

                Notification n = builder.build();

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                // This replaces the existing notification with the same ID
                notificationManager.notify(notificationID, n);
                finish();
            }
        });


    }
}