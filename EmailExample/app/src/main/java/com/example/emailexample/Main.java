package com.example.emailexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends Activity implements View.OnClickListener {
    Button emailButton;

    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.layout);
        this.emailButton=findViewById(R.id.button);
        this.emailButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == this.emailButton){
            Intent emailIntent= new Intent();
            emailIntent.setType("text/html");
            emailIntent.putExtra(Intent.EXTRA_TITLE, "My Title");
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "My Subject");
            emailIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.email_text));
            startActivity(emailIntent);
        }

    }
}
