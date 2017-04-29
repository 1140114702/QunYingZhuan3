package com.example.zyb.qunyingzhuan3;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;

/**
 * 事件分发机制
 * Created by bin on 2017/4/29.
 */

public class BViewGroup extends ViewGroup {

    private static final String TAG = "binbin";

    public BViewGroup(Context context) {
        super(context);
    }

    public BViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "dispatchTouchEvent: BViewGroup");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG, "onInterceptTouchEvent: BViewGroup");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent: BViewGroup");
        return super.onTouchEvent(event);
    }
}
