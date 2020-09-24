package com.example.tipcalculator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.NumberFormat;


public class Main extends Activity {
    private EditText Amount;
    private EditText People;
    private EditText Tip;

    private TextView TipAmount;
    private TextView TotalToPay;
    private TextView TipPerPerson;

    private RadioGroup radioGroup;
    private Button buttonCalculate;
    private Button buttonReset;

    private int radioCheckedId = -1;
    final static NumberFormat formatter =
            NumberFormat.getCurrencyInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        Amount=(EditText) findViewById(R.id.textAmount);
        Amount.requestFocus();

        People=(EditText) findViewById(R.id.textPeople);
        Tip=(EditText) findViewById(R.id.textTipOther);

        radioGroup=(RadioGroup) findViewById(R.id.radioGroup);

        buttonCalculate=(Button) findViewById(R.id.buttonCalculate);
        buttonCalculate.setEnabled(false);

        buttonReset=(Button) findViewById(R.id.buttonReset);

        TipAmount=(TextView) findViewById(R.id.tipAmount);
        TotalToPay=(TextView) findViewById(R.id.textTotal);
        TipPerPerson=(TextView) findViewById(R.id.textPerPerson);
        Tip.setEnabled(false);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.radioFifteen ||
                   checkedId==R.id.radioTwenty){
                    Tip.setEnabled(false);
                    buttonCalculate.setEnabled(
                            Amount.getText().length()>0 &&
                            People.getText().length()>0
                    );
                }
                if(checkedId==R.id.radioOther){
                    Tip.setEnabled(true);
                    Tip.requestFocus();

                    buttonCalculate.setEnabled(
                            Amount.getText().length() > 0 &&
                            People.getText().length() > 0 &&
                            Tip.getText().length() > 0
                    );

                }
                radioCheckedId=checkedId;
            }
        });


        Amount.setOnKeyListener(KeyListener);
        People.setOnKeyListener(KeyListener);
        Tip.setOnKeyListener(KeyListener);

        buttonCalculate.setOnClickListener(ClickListener);
        buttonReset.setOnClickListener(ClickListener);

    };

    private void reset(){
        Amount.setText("");
        People.setText("");
        Tip.setText("");
        TipAmount.setText("");
        TotalToPay.setText("");
        TipPerPerson.setText("");
        radioGroup.clearCheck();
        radioGroup.check(R.id.radioFifteen);
        Amount.requestFocus();
    };

    private void calculate() {
        Double billAmount = Double.parseDouble(
                Amount.getText().toString());
        Double totalPeople = Double.parseDouble(
                People.getText().toString());
        Double percentage = null;
        boolean isError = false;
        if (billAmount < 1.0) {
            showErrorAlert("Enter a valid Total Amount.",
                    Amount.getId());
            isError = true;
        }

        if (totalPeople < 1.0) {
            showErrorAlert("Enter a valid number of people.",
                    People.getId());
            isError = true;
        }


        if (radioCheckedId == -1) {
            radioCheckedId = radioGroup.getCheckedRadioButtonId();
        }
        if (radioCheckedId == R.id.radioFifteen) {
            percentage = 15.00;
        } else if (radioCheckedId == R.id.radioTwenty) {
            percentage = 20.00;
        } else if (radioCheckedId == R.id.radioOther) {
            percentage = Double.parseDouble(
                    Tip.getText().toString());
            if (percentage < 1.0) {
                showErrorAlert("Enter a valid Tip percentage",
                        Tip.getId());
                isError = true;
            }
        }

        if (!isError) {
            double tipAmount = ((billAmount * percentage) / 100);
            double totalToPay = billAmount + tipAmount;
            double perPersonPays = totalToPay / totalPeople;

            TipAmount.setText(formatter.format(tipAmount));
            TotalToPay.setText(formatter.format(totalToPay));
            TipPerPerson.setText(formatter.format(perPersonPays));
        }
    }


    private void showErrorAlert(String errorMessage, final int fieldId) {
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(errorMessage)
                .setNeutralButton("Close",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                findViewById(fieldId).requestFocus();
                            }
                        }).show();
    }

    private View.OnKeyListener KeyListener = new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {

            switch (v.getId()) {
                case R.id.tipAmount:
                case R.id.textPeople:
                    buttonCalculate.setEnabled(Amount.getText().length() > 0
                            && People.getText().length() > 0);
                    break;
                case R.id.textTipOther:
                    buttonCalculate.setEnabled(Amount.getText().length() > 0
                            && People.getText().length() > 0
                            && Tip.getText().length() > 0);
                    break;
            }
            return false;
        }

    };

    private View.OnClickListener ClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.buttonCalculate) {
                calculate();
            } else {
                reset();
            }
        }
    };
}
