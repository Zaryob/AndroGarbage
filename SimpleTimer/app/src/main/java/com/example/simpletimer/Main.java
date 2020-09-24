package com.example.simpletimer;

import android.app.Activity;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main extends Activity implements View.OnClickListener {
    private MalibuCountDownTimer countDownTimer;
    private long timeElapsed;
    private boolean timerHasStarted=false;
    private Button startButton;
    private TextView text;
    private TextView textTimeElapsed;

    private final long startTime = 50*1000;
    private final long interval = 1*1000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        startButton=(Button) this.findViewById(R.id.button1);
        startButton.setOnClickListener(this);
        text= (TextView) this.findViewById(R.id.timer);
        textTimeElapsed=(TextView) this.findViewById(R.id.timeElapsed);
        countDownTimer=new MalibuCountDownTimer(startTime, interval);

        text.setText(text.getText() + String.valueOf(startTime));
    }
    @Override
    public void onClick(View v) {
        if (!timerHasStarted){
            countDownTimer.start();
            timerHasStarted = true;
            startButton.setText("Stop!");

        } else {
            countDownTimer.cancel();
            timerHasStarted=false;
            startButton.setText("RESET?");
        }

    }
    public class MalibuCountDownTimer extends CountDownTimer{

        public MalibuCountDownTimer(long startTime, long interval){
            super(startTime, interval);
        }
        @Override
        public void onTick(long millisUntilFinished) {
            text.setText("Time remain:"+ (millisUntilFinished)/1000);
            timeElapsed = startTime-millisUntilFinished;
            textTimeElapsed.setText("Time Elapsed: " + String.valueOf(timeElapsed/1000));
        }

        @Override
        public void onFinish() {
            text.setText("Time's up!");
            textTimeElapsed.setText("Time Elapsed: " + String.valueOf(startTime));
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
            r.play();
        }
    }
}
