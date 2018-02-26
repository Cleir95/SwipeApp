package com.example.android.swipeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class GameOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpop);
        Bundle b = getIntent().getExtras();
       int score = b.getInt("score");
        Log.d("stupid timer", "I am so stupid"+ score);
          displayScore(score);

    }






    public void displayScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.result);
        scoreView.setText(String.valueOf(score));


    }





}








   /* Main3Activity hi = new Main3Activity();
    int score= hi.score;




    public void displayScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.result);
        scoreView.setText(String.valueOf(score));


    }*/
