package com.example.zyb.qunyingzhuan3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

/**
 * 对现有的控件进行拓展
 * Created by zyb on 2017/4/26.
 */

public class TestView1 extends android.support.v7.widget.AppCompatTextView {

    private Paint mPaint1;
    private Paint mPaint2;

    public TestView1(Context context) {
        super(context);
        initView(context);
    }

    public TestView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public TestView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        mPaint1 = new Paint();
        mPaint1.setColor(ContextCompat.getColor(context, android.R.color.holo_blue_light));
        mPaint1.setStyle(Paint.Style.FILL);
        mPaint2 = new Paint();
        mPaint2.setColor(Color.YELLOW);
        mPaint2.setStyle(Paint.Style.FILL);
    }

    /**
     * 这里面的参数表示的是在相对应的坐标上的一条线，四条线所组成的图形就是该矩形
     *
     * @param canvas 画布
     */
    @Override
    protected void onDraw(Canvas canvas) {

        //绘制外层矩形（在super.onDraw之前：表示在绘制文本内容之前）
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint1);
        //绘制内层矩形（在super.onDraw之前：表示在绘制文本内容之前）
        canvas.drawRect(10, 10, getMeasuredWidth() - 10, getMeasuredHeight() - 10, mPaint2);
//        canvas.save();
        //绘制文字前平移10个像素
//        canvas.translate(10, 0);
        //父类完成的方法，即绘制文本
        super.onDraw(canvas);
//        canvas.restore();

    }
}
