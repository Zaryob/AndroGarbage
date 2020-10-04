package com.example.detailedintent;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends Activity {
    Button button;
    EditText editText;
    Handler handler;
    Context context;
    public void onCreate() {

        super.onStart();
        setContentView(R.layout.layout);
        this.button=findViewById(R.id.button);
        this.editText=findViewById(R.id.editText);
        this.context=getApplicationContext();
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
