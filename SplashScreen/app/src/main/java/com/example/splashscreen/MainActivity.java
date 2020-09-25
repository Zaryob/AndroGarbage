package com.example.splashscreen;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends Activity {
    private class StateSaver {
        private boolean showSplashScreen = true;
    }
    private Dialog splashDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StateSaver data = (StateSaver) getLastNonConfigurationInstance();
        if (data != null) {
            if (data.showSplashScreen ) {
                showSplashScreen();
            }
            setContentView(R.layout.main);
        } else {
            showSplashScreen();
            setContentView(R.layout.main);
        }
    }

    @Override
    public Object onRetainNonConfigurationInstance() {
        StateSaver data = new StateSaver();

        if (splashDialog != null) {
            data.showSplashScreen = true;
            removeSplashScreen();
        }
        return data;
    }

    private void removeSplashScreen() {
        if (splashDialog != null) {
            splashDialog.dismiss();
            splashDialog = null;
        }
    }

    private void showSplashScreen() {
        splashDialog = new Dialog(this);
        splashDialog.setContentView(R.layout.layout);
        splashDialog.setCancelable(false);
        splashDialog.show();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                removeSplashScreen();
            }
        },  10000); // 10 seconds
    }
}