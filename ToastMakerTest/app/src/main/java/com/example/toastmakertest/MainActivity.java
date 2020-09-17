package com.example.toastmakertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;


public class MainActivity
        extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context = getApplicationContext();
        Handler newhandler= new Handler();

        newhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                CharSequence text = "This is first toast! Standart automatic generated toast!";
                Toast toast = Toast.makeText(context,
                        text,
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        },2000 );

        newhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast toast1=Toast.makeText(context,
                                            "This is changed place toast",
                                            Toast.LENGTH_SHORT);
                toast1.setGravity(Gravity.TOP|Gravity.LEFT,
                                  0,
                                  0);
                toast1.show();

            }
        },2000);

        newhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                LayoutInflater inflater=getLayoutInflater();
                View layout= inflater.inflate(R.layout.custom_toast,
                        (ViewGroup) findViewById(R.id.custom_toast_container)
                );
                TextView text=(TextView) layout.findViewById(R.id.text);
                text.setText("This is custom toast");

                Toast toast1 = new Toast(context);
                toast1.setGravity(Gravity.CENTER_VERTICAL,0,0);
                toast1.setDuration(Toast.LENGTH_LONG);
                toast1.setView(layout);
                toast1.show();

            }
        },2000);


    }
}