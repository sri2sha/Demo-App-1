package com.example.demoapp1.broadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class AirplaneModeChangeReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        if (isAirplaneModeOn(context.getApplicationContext())){
            Toast.makeText(context, "Airplane Mode is on", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Airplane Mode is off", Toast.LENGTH_SHORT).show();
        }
    }

    public static boolean isAirplaneModeOn(Context context){
        return Settings.System.getInt(context.getContentResolver(),Settings.Global.AIRPLANE_MODE_ON,0) != 0;
    }
}


