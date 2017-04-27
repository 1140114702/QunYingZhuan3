package com.example.zyb.qunyingzhuan3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * 弧线展示图
 * Created by zyb on 2017/4/27.
 */

public class CircleProgressView extends View {

    private int mMeasureWidth; //该view的宽度
    private int mMeasureHeight; //该view的高度

    //内圆
    private Paint mCirclePaint; //画笔
    private float mCircleXY; //圆心的坐标
    private float mRadius; //半径

    //外圆弧
    private Paint mArcPaint; //画笔
    private RectF mArcRectF; //外接矩形
    private float mSweepAngle; //弧度（开始到结束的角度）
    private float mSweepValue = 270; //自己定义的弧度（一般是从外部获取）

    //内圆里面的内容
    private Paint mTextPaint; //画笔
    private String mShowText; //内容
    private float mShowTextSize; //大小
    private Paint.FontMetricsInt fontMetricsInt;

    public CircleProgressView(Context context) {
        super(context);
        initView();
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public CircleProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {

        //初始化内圆参数
        float length = Math.min(mMeasureWidth, mMeasureHeight);//根据长宽取较小的那个(圆的直径)
        mCircleXY = length / 2;
        mRadius = (float) (mCircleXY * 0.5);
        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setColor(ContextCompat.getColor(getContext(), android.R.color.holo_blue_bright));

        //初始化外圆弧参数
        mArcRectF = new RectF(
                (float) (length * 0.1),
                (float) (length * 0.1),
                (float) (length * 0.9),
                (float) (length * 0.9));
        mArcPaint = new Paint();
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setAntiAlias(true);
        mArcPaint.setColor(ContextCompat.getColor(getContext(), android.R.color.holo_blue_bright));
        mArcPaint.setStrokeWidth((float) (length * 0.1));

        //初始化内圆字体内容参数
        mShowText = setShowText();
        mShowTextSize = setShowTextSize();
        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setTextSize(mShowTextSize);
        mTextPaint.setTextAlign(Paint.Align.CENTER);

        fontMetricsInt = mTextPaint.getFontMetricsInt();
    }

    private String setShowText() {
        this.invalidate();
        return "自定义的Text";
    }

    private float setShowTextSize() {
        this.invalidate();
        return 35;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mMeasureWidth = MeasureSpec.getSize(widthMeasureSpec);
        mMeasureHeight = MeasureSpec.getSize(heightMeasureSpec);
        initView();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画内圆
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);

        //画外圆弧
        canvas.drawArc(mArcRectF, 270, mSweepValue, false, mArcPaint);

        //画内圆的字体内容
        //获取字体中间的y坐标（如果不做操作将会在字体的下边）
        float baseLine = (mMeasureHeight - fontMetricsInt.bottom - fontMetricsInt.top) / 2;
        canvas.drawText(mShowText, 0, mShowText.length(), mCircleXY, baseLine, mTextPaint);
    }

    public void forceInvalidate() {
        this.invalidate();
    }

    public void setSweepValue(float sweepValue) {
        if (sweepValue != 0) {
            mSweepValue = sweepValue;
        } else {
            mSweepValue = 25;
        }
        this.invalidate();
    }
}
