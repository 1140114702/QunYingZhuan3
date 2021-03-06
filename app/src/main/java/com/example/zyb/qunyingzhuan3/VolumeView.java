package com.example.zyb.qunyingzhuan3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 音频条形图
 * Created by zyb on 2017/4/27.
 */

public class VolumeView extends View {

    private int mWidth;
    private int mRectWidth;
    private int mRectHeight;
    private Paint mPaint;
    private int mRectCount;
    private int offset = 5;
    private double mRandom;
    private LinearGradient mLinearGradient;

    public VolumeView(Context context) {
        super(context);
        initView();
    }

    public VolumeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public VolumeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLUE);
        mRectCount = 22;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = getWidth();
        mRectHeight = getHeight();
        mRectWidth = (int) (mWidth /** 0.6*/ / mRectCount);

        mLinearGradient = new LinearGradient(
                0, 0, mRectWidth, mRectHeight, Color.YELLOW, Color.BLUE, Shader.TileMode.CLAMP
        );
        mPaint.setShader(mLinearGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < mRectCount; i++) {
            mRandom = Math.random();
            float currentHeight = (float) (mRectHeight * mRandom);
            canvas.drawRect(
                    (float) (/*mWidth * 0.4 / 2 + */mRectWidth * i + offset),
                    currentHeight,
                    (float) (/*mWidth * 0.4 / 2 + */mRectWidth * (i + 1)),
                    mRectHeight,
                    mPaint);
        }
        postInvalidateDelayed(300);
    }
}
