package com.example.android.swipeapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Main3Activity extends AppCompatActivity {

    public int score = 0;
    int secondsleft;
    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        View myView = (View) findViewById(R.id.myView);
        textView = (TextView) this.findViewById(R.id.time);

        final CountDownTimer timer;
        {
            timer = new CountDownTimer(1000, 1000) {

                @Override
                public void onTick(long timeleft) {
                    secondsleft = (int) (timeleft / 1000);

                }

                @Override
                public void onFinish() {
                    Log.v("stupid timer", "I am so stupid");


                  //startActivity (new Intent(Main3Activity.this, MainActivity.class));
                    startActivity (new Intent(Main3Activity.this, GameOver.class));





                }
            };

        }



        myView.setOnTouchListener(new OnSlidingListener(this) {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    timer.start();
                }
                return super.onTouch(v, event);
            }


            @Override
            public boolean onSwipeRight() {
                Log.d("right", "" + score + "");
                return true;
            }

            @Override
            public boolean onSwipeLeft() {
                Log.v("swipe", "left");
                return true;
            }

            @Override
            public boolean onSwipeTop() {
                Log.v("swipe", "top");
                score++;
                displayScore(score);
                Log.d("top", "" + score + "");
                return true;
            }

            @Override
            public boolean onSwipeBottom() {
                Log.v("swipe", "down");
                score++;
                displayScore(score);
                return true;
            }
        });
    }



    public void displayScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.score);
        scoreView.setText(String.valueOf(score));

    }






}
