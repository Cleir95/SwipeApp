package com.example.android.swipeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class Main3Activity extends AppCompatActivity {

    int score =0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        View myView = (View) findViewById(R.id.myView);
        myView.setOnTouchListener(new OnSlidingListener(this) {


            @Override
            public boolean onSwipeRight(){
                Log.d("right","" + score + "" );
                return true;}

            @Override
            public boolean onSwipeLeft(){ Log.v("swipe", "left" );return true;}

            @Override
            public boolean onSwipeTop(){  Log.v("swipe", "top");
            score++;
                Log.d("top","" + score + "" );
            return true;}

            @Override
            public boolean onSwipeBottom(){   Log.v("swipe", "down");
            score++;
            return true;}
        });
    }
}
