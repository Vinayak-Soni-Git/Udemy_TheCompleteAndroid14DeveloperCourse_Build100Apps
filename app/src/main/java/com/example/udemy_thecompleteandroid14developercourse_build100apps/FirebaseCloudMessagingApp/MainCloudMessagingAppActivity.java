package com.example.udemy_thecompleteandroid14developercourse_build100apps.FirebaseCloudMessagingApp;

import static android.content.ContentValues.TAG;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.udemy_thecompleteandroid14developercourse_build100apps.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainCloudMessagingAppActivity extends AppCompatActivity {
    
    Button subscribeToTopicsButton, readNotificationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cloud_messaging_app);
        
        subscribeToTopicsButton = findViewById(R.id.subscribeToTopicsButton);
        readNotificationButton = findViewById(R.id.readNotiticationButton);
        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            String channelId = getString(R.string.default_notification_channel_id);
            String channelName = getString(R.string.default_notification_channel_name);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(new NotificationChannel(channelId, channelName,
                    NotificationManager.IMPORTANCE_LOW));
        }
        
        if (getIntent().getExtras() != null){
            for (String key: getIntent().getExtras().keySet()){
                Object value = getIntent().getExtras().get(key);
                Log.d(TAG, "Key: "+key +" Value: "+value);
            }
        }
        
        subscribeToTopicsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseMessaging.getInstance().subscribeToTopic("weather")
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                String message = "Subscribed!";
                                if (!task.isSuccessful()){
                                    message = "Failed!";
                                }
                                Log.d(TAG, message);
                                Toast.makeText(MainCloudMessagingAppActivity.this, message, Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
        
        readNotificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()){
                            Log.w(TAG, "Failed to register Token", task.getException());
                            return;
                        }
                        String token = task.getResult();
                        String msg = getString(R.string.cloudMessageToken, token);
                        Log.d(TAG, msg);
                        Toast.makeText(MainCloudMessagingAppActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}