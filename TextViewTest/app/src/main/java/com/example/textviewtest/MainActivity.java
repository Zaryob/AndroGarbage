package com.example.textviewtest;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text2 = (TextView) findViewById(R.id.text2);

        text2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Clicked to text showing link",
                        Toast.LENGTH_LONG).show();
                text2.setText("That is my github profile: https://github.com/Zaryob");

                if(text2.getLinksClickable() == true) {
                    text2.setLinkTextColor(Color.BLUE);
                }
            }

        });
    }

}