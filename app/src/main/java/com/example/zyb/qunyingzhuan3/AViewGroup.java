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

public class AViewGroup extends ViewGroup {

    private static final String TAG = "binbin";

    public AViewGroup(Context context) {
        this(context,null);
    }

    public AViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public AViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getContext(), "点击最外层的ViewGroup", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "dispatchTouchEvent: AViewGroup");
        return super.dispatchTouchEvent(ev);
    }

    //事件的拦截
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG, "onInterceptTouchEvent: AViewGroup");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent: AViewGroup");
        return super.onTouchEvent(event);
    }
}
