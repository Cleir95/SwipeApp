package com.example.android.swipeapp;

/**
 * Created by xclei on 25/02/2018.
 */

import android.content.Context;

import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class OnSlidingListener implements OnTouchListener {

    private final GestureDetector gestureDetector;
    int secondsleft;

    public OnSlidingListener(Context context){
        gestureDetector = new GestureDetector(context, new GestureListener());
    }



    public boolean onTouch(View v, MotionEvent event) {

        return gestureDetector.onTouchEvent(event);
    }

    private final class GestureListener extends SimpleOnGestureListener {



        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            return onClick();
        }

        @Override
        public void onLongPress(MotionEvent e) {
            onLongClick();
        }


        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try {
                float angle = (float) Math.toDegrees(Math.atan2(e2.getY() - e1.getY(), e2.getX() - e1.getX()));
                if (angle > 0) {
                    if (angle > 85 && angle <= 105) {
                        onSwipeTop();
                        result = true;
                        Log.d("angle", "  " + angle);
                    } else if (angle > 105 && angle <= 255) {
                        onSwipeLeft();
                        result = true;
                        Log.d("angle", "  " + angle);
                    } else if (angle > 255 && angle <= 285) {
                        onSwipeBottom();
                        result = true;
                        Log.d("angle", "  " + angle);
                    } else {
                        onSwipeRight();
                        result = true;
                        Log.d("angle", "  " + angle);
                    }

                }


                if (angle < 0) {
                    angle = angle+360;
                    if (angle > 85 && angle <= 105) {
                        onSwipeTop();
                        result = true;
                        Log.d("angle", "  " + angle);
                    } else if (angle > 105 && angle <= 255) {
                        onSwipeLeft();
                        result = true;
                        Log.d("angle", "  " + angle);
                    } else if (angle > 255 && angle <= 285) {
                        onSwipeBottom();
                        result = true;
                        Log.d("angle", "  " + angle);
                    } else {
                        onSwipeRight();
                        result = true;
                        Log.d("angle", "  " + angle);
                    }
                }


            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
    }

    public boolean onClick() {
        return false;
    }

    public boolean onLongClick() {
        return false;
    }


    public boolean onSwipeRight( ) { return false;}

    public boolean onSwipeLeft() {   return false;}

    public boolean onSwipeTop() {  return false;}

    public boolean onSwipeBottom() {  return false;}
}


// private final String TAG = GestureListener.class.getSimpleName();

//private static final int SWIPE_THRESHOLD = 100;
//private static final int SWIPE_VELOCITY_THRESHOLD = 100;


    /*  float diffY = e2.getY() - e1.getY();
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
                }*/