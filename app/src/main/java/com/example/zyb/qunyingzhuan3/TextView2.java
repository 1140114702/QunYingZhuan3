package com.example.zyb.qunyingzhuan3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;

/**
 * 有动态效果的TextView
 * Created by zyb on 2017/4/26.
 */

public class TextView2 extends android.support.v7.widget.AppCompatTextView {

    private int mViewWidth = 0;
    private TextPaint mPaint;
    private LinearGradient mLinearGradient;
    private Matrix mGradientMatrix;
    private int mTranslate = 0;

    public TextView2(Context context) {
        super(context);
    }

    public TextView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TextView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();
            if (mViewWidth > 0) {
                mPaint = getPaint();
                mLinearGradient = new LinearGradient(0, 0, mViewWidth, 0,
                        new int[]{Color.BLACK, 0xffffffff, Color.BLACK},
                        null, Shader.TileMode.CLAMP);
                mPaint.setShader(mLinearGradient);
                mGradientMatrix = new Matrix();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mGradientMatrix != null) {
            mTranslate += mViewWidth / 5;
            if (mTranslate > 2 * mViewWidth) {
                mTranslate = -mViewWidth;
            }
            mGradientMatrix.setTranslate(mTranslate, 0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            postInvalidateDelayed(100);
        }
    }

}
