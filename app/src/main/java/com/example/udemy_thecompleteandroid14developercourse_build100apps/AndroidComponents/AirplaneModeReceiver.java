package com.example.udemy_thecompleteandroid14developercourse_build100apps.AndroidComponents;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
            boolean isAirplaneModeOn = intent.getBooleanExtra("State", false);

            String message = isAirplaneModeOn ? "Airplane mode is ON": "Airplane mode is OFF";
            Toast.makeText(context, ""+message, Toast.LENGTH_SHORT).show();
        }
    }
}
