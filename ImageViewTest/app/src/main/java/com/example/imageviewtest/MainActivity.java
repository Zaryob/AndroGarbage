package com.example.imageviewtest;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

    Button button;
    ImageView image;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        image = (ImageView) findViewById(R.id.image);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                image.setImageResource(R.mipmap.ic_launcher);
            }
        });
    }
}