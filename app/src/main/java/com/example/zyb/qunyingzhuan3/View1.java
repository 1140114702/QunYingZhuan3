package com.example.zyb.qunyingzhuan3;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * View的测量和绘制
 * Created by zyb on 2017/4/26.
 */

public class View1 extends View {


    private static final String TAG = "binbin";

    public View1(Context context) {
        super(context);
    }

    public View1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public View1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //测量
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    //自定义高度
    private int measureHeight(int heightMeasureSpec) {
        int result;
        int mode = MeasureSpec.getMode(heightMeasureSpec);
        int size = MeasureSpec.getSize(heightMeasureSpec);

        if (mode == MeasureSpec.EXACTLY) {
            //精确值模式
            result = size;
        }else {
            result = 200;
            if (mode == MeasureSpec.AT_MOST) {
                //最大模式（wrap_content）
                result = Math.min(result,size);  //取其中最小的值
            }
        }
        return result;
    }

    //自定义宽度
    private int measureWidth(int widthMeasureSpec) {
        int result;
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);

        if (mode == MeasureSpec.EXACTLY) {
            //精确值模式
            result = size;
        }else {
            result = 200;
            if (mode == MeasureSpec.AT_MOST) {
                //最大模式（自适应模式）
                result = Math.min(result,size);  //取其中最小的值
            }
        }
        return result;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }

    //绘制
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        int width = getWidth();
        int height = getHeight();
    }

}
