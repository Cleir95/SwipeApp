package com.example.android.swipeapp;

import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import static android.content.ContentValues.TAG;

/**
 * Created by xclei on 25/02/2018.
 */

public class OnSwipeListener implements  OnTouchListener {

    // method from the OnTouchListner Interface
    @Override
    public boolean onTouch(View view, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private final GestureDetector gestureDetector;

    //constructor
    public OnSwipeListener(Context context) {
        gestureDetector = new GestureDetector(context, new GestureListener());
    }

    private final class GestureListener extends SimpleOnGestureListener {

        private static final int SWIPE_THRESHOLD = 100;
        private static final int SLIDE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent e) {
           /* float x1= e.getX();
            float y1 =e.getY();

            Log.d("start","" + x1 + "" + y1);

            if ( e.getAction()== MotionEvent.ACTION_MOVE){

                float x2= e.getX();
                float y2 =e.getY();

                Log.d("current","" + x2 + "" + y2);

            }*/

            return true;
        }


        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            onSwipeRight();
                        } else {
                            onSwipeLeft();
                        }
                        result = true;
                    }
                } else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffY > 0) {
                        onSwipeBottom();
                    } else {
                        onSwipeTop();
                    }
                    result = true;
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }


        public void onSwipeRight() {
            Log.v("slideR", "right");
        }

        public void onSwipeLeft() {
            Log.v("slideR", "left");
        }

        public void onSwipeTop() {
            Log.v("slideR", "top");
        }

        public void onSwipeBottom() {
            Log.v("slideR", "down");
        }
    }


}