package com.acgb.greychainlabs.pikit;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class PinScreen extends AppCompatActivity {

    public String userPin = "8888";

    TextView titleView;
    TextView statusView;

    public ImageButton button;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    ImageButton buttonExit;
    ImageButton buttonDelete;
    ImageButton buttonEnter;
    EditText passwordInput;

    public String userEntered = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_screen);



        View.OnClickListener pinButtonHandler = new View.OnClickListener() {
            public void onClick(View v) {

                Button pressedButton = (Button) v;

                passwordInput = (EditText) findViewById(R.id.editText);

                    passwordInput.setText("", TextView.BufferType.EDITABLE);

                     userEntered = userEntered + pressedButton.getText();
                    Log.v("PinView", "User entered=" + userEntered);

                    passwordInput.setText(userEntered, TextView.BufferType.EDITABLE);
                    passwordInput.setSelection(userEntered.length());

                }

        };

        View.OnClickListener deletePass = new View.OnClickListener() {
            public void onClick(View v) {

                passwordInput = (EditText) findViewById(R.id.editText);

                String currentPass = passwordInput.getText().toString();

                if (currentPass.length() > 0) {

                    userEntered = currentPass.substring(0, currentPass.length() - 1);

                }
                else {
                    userEntered = "";
                }
                passwordInput.setSelection(userEntered.length());
                passwordInput.setText(userEntered, TextView.BufferType.EDITABLE);

            }

        };


        buttonDelete = (ImageButton) findViewById(R.id.buttonDelete);
        //button0.setTypeface(xpressive);
        buttonDelete.setOnClickListener(deletePass);

        button0 = (Button) findViewById(R.id.button0);
        //button0.setTypeface(xpressive);
        button0.setOnClickListener(pinButtonHandler);

        button1 = (Button) findViewById(R.id.button1);
        //button1.setTypeface(xpressive);
        button1.setOnClickListener(pinButtonHandler);

        button2 = (Button) findViewById(R.id.button2);
        //button2.setTypeface(xpressive);
        button2.setOnClickListener(pinButtonHandler);


        button3 = (Button) findViewById(R.id.button3);
        //button3.setTypeface(xpressive);
        button3.setOnClickListener(pinButtonHandler);

        button4 = (Button) findViewById(R.id.button4);
        //button4.setTypeface(xpressive);
        button4.setOnClickListener(pinButtonHandler);

        button5 = (Button) findViewById(R.id.button5);
        //button5.setTypeface(xpressive);
        button5.setOnClickListener(pinButtonHandler);

        button6 = (Button) findViewById(R.id.button6);
        //button6.setTypeface(xpressive);
        button6.setOnClickListener(pinButtonHandler);

        button7 = (Button) findViewById(R.id.button7);
        //button7.setTypeface(xpressive);
        button7.setOnClickListener(pinButtonHandler);

        button8 = (Button) findViewById(R.id.button8);
        //button8.setTypeface(xpressive);
        button8.setOnClickListener(pinButtonHandler);

        button9 = (Button) findViewById(R.id.button9);
        //button9.setTypeface(xpressive);
        button9.setOnClickListener(pinButtonHandler);

    }

    public void addListenerOnEnterButton(View v) {

        button = (ImageButton) findViewById(R.id.buttonEnter);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                try {

                    passwordInput = (EditText) findViewById(R.id.editText);

                    String usrEnteredPass = passwordInput.getText().toString();

                    if (usrEnteredPass.equals(userPin)) {
                        Toast.makeText(getApplicationContext(), "Correct Password", Toast.LENGTH_LONG).show();
                        MainActivityOnPikIt.sendData("1");


                        Toast.makeText(getApplicationContext(), "Wallet Unlocked", Toast.LENGTH_LONG).show();

                        finish();


                    } else {
                        passwordInput.setText("");
                        userEntered = "";
                        Toast.makeText(getApplicationContext(), "Wrong Password", Toast.LENGTH_LONG).show();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

        });


    }

    public void addListenerOnExitButton(View v) {

        button = (ImageButton) findViewById(R.id.buttonExit);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

//                Intent intent = new Intent(PinScreen.this, MainActivityOnPikIt.class);
//                startActivityForResult(intent, 0);
                finish();


            }

        });


    }


}
