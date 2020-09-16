package com.example.framelayouttest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public FrameLayout frame;
    public ImageView image;
    public TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frame= (FrameLayout) findViewById(R.id.framelayout);
        image=(ImageView) findViewById(R.id.frameImage);
        text=(TextView) findViewById(R.id.frameText);

        TextView newText=new TextView(this);
        newText.setText("FrameLayoutTest: Click button to change color");
        newText.setTextColor(Color.GREEN);
        newText.setTextSize(20);
        frame.addView(newText);

        image.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if(text.getVisibility() == View.GONE) {
                    text.setVisibility(View.VISIBLE);
                    frame.setBackgroundColor(Color.MAGENTA);
                } else {
                    text.setVisibility(View.GONE);
                    frame.setBackgroundColor(Color.WHITE);
                }

            }
        });

    }
}