package com.example.intentexample;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    Button button;
    EditText editText;
    Context context;
    Handler handler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.button = findViewById(R.id.button);
        this.editText = findViewById(R.id.editText);
        this.context = getApplicationContext();
        this.handler = new Handler();
        onclicklistener();
    }

    private void onclicklistener(){

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //try:
                final String url=editText.getText().toString();
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);

                } catch (ActivityNotFoundException exception) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(context,
                                    "Url: \"" + url.toString() + "\" is not starts with http:// or https://",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }, 200);

                    onclicklistener();
                }
            }
        });
    }
}