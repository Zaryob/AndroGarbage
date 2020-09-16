package com.example.linearlayouttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public TextView textView;
    public Button button[] = new Button[6];
    List clicked=new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView) findViewById(R.id.frameText);
        button[0]=(Button) findViewById(R.id.button1);
        button[1]=(Button) findViewById(R.id.button2);
        button[2]=(Button) findViewById(R.id.button3);
        button[3]=(Button) findViewById(R.id.button4);
        button[4]=(Button) findViewById(R.id.button5);
        button[5]=(Button) findViewById(R.id.button6);

        for(int i=0;i<6;i++){

            final int finalI = i;
            button[i].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (clicked.contains(finalI+1)) {
                        clicked.remove(clicked.indexOf(finalI+1));
                    }else {
                        clicked.add(finalI+1);
                    }
                    textView.setText("Pressed Buttons are " + clicked.toString());
                    System.gc();
                }
            });
        };


    }
}