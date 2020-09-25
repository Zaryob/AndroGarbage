package com.example.batterystatus;

import android.app.Activity;
import android.app.ApplicationErrorReport;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        this.registerReceiver(this.myBatteryReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

    }

    private BroadcastReceiver myBatteryReceiver =new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
          int bLevel=intent.getIntExtra("level",0);
          Log.i("BatteryMon", "Level now " + bLevel);
          Toast.makeText(getApplicationContext(),
                  "Battery Level:" + bLevel,
                  Toast.LENGTH_LONG).show();

        }
    };
}

