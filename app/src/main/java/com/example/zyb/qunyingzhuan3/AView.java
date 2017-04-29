package com.example.zyb.qunyingzhuan3;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * 事件分发机制
 * Created by bin on 2017/4/29.
 */

public class AView extends android.support.v7.widget.AppCompatButton {

    private static final String TAG = "binbin";

    public AView(Context context) {
        this(context, null);
    }

    public AView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getContext(), "点击了最里面的View", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e(TAG, "dispatchTouchEvent: AView");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent: AView");
        return super.onTouchEvent(event);
    }

}
