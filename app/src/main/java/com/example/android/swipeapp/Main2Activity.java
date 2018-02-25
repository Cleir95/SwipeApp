package com.example.android.swipeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;


/**
 * Created by xclei on 25/02/2018.
 */

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        View myView = (View) findViewById(R.id.myView);
        myView.setOnTouchListener(new OnSwipeListener(this) {




        });
    }
}
