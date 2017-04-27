package com.example.zyb.qunyingzhuan3;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 头部toolbar
 * Created by zyb on 2017/4/27.
 */

public class MyToolBar extends RelativeLayout {


    private String title; //标题
    private float titleTextSize; //标题大小
    private int titleTextColor; //标题颜色
    private String leftTitle; //左边的标题
    private int leftTextColor; //左边的标题颜色
    private Drawable leftBackground; //左边的标题背景
    private String rightTitle; //右边的标题
    private int rightTextColor; //右边的标题颜色
    private Drawable rightBackground; //右边的标题背景
    private Button mLeftBtn;
    private TextView mTitle;
    private Button mRightBtn;

    public MyToolBar(Context context) {
        super(context);
        initView(context);
    }

    public MyToolBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(context, attrs);
    }

    public MyToolBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        // 通过这个方法，将你在attrs.xml中定义的declare-styleable
        // 的所有属性的值存储到TypedArray中
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MyToolBar);
        if (array != null) {
            // 从TypedArray中取出对应的值来为要设置的属性赋值
            title = array.getString(R.styleable.MyToolBar_title);
            titleTextSize = array.getDimension(R.styleable.MyToolBar_titleTextSize, 18);
            titleTextColor = array.getColor(R.styleable.MyToolBar_titleTextColor, 0);
            leftTitle = array.getString(R.styleable.MyToolBar_leftText);
            leftTextColor = array.getColor(R.styleable.MyToolBar_leftTextColor, 0);
            leftBackground = array.getDrawable(R.styleable.MyToolBar_leftBackground);
            rightTitle = array.getString(R.styleable.MyToolBar_rightText);
            rightTextColor = array.getColor(R.styleable.MyToolBar_rightTextColor, 0);
            rightBackground = array.getDrawable(R.styleable.MyToolBar_rightBackground);
            // 获取完TypedArray的值后，一般要调用
            // recycle方法来避免重新创建的时候的错误
            array.recycle();
        }

        initView(context);
    }

    private void initView(Context context) {

        //设置背景颜色
        setBackgroundColor(0xFFF59563);

        mLeftBtn = new Button(context);
        mTitle = new TextView(context);
        mRightBtn = new Button(context);

        // 为创建的组件元素赋值
        // 值就来源于我们在引用的xml文件中给对应属性的赋值
        mLeftBtn.setText(leftTitle);
        mLeftBtn.setTextColor(leftTextColor);
        mLeftBtn.setBackground(leftBackground);
        mTitle.setText(title);
        mTitle.setTextColor(titleTextColor);
        mTitle.setTextSize(titleTextSize);
        mTitle.setGravity(Gravity.CENTER);
        mRightBtn.setText(rightTitle);
        mRightBtn.setTextColor(rightTextColor);
        mRightBtn.setBackground(rightBackground);

        //添加左边的按钮
        LayoutParams leftParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        addView(mLeftBtn, leftParams);

        //添加中间的标题
        LayoutParams titleParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(mTitle, titleParams);

        //添加右边的按钮
        LayoutParams rightParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(mRightBtn, rightParams);

        // 按钮的点击事件，不需要具体的实现，
        // 只需调用接口的方法，回调的时候，会有具体的实现
        mLeftBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toolBarClickListener != null) {
                    toolBarClickListener.leftOnClick();
                }
            }
        });

        mRightBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toolBarClickListener != null) {
                    toolBarClickListener.rightOnClick();
                }
            }
        });
    }

    private ToolBarClickListener toolBarClickListener;

    // 暴露一个方法给调用者来注册接口回调
    // 通过接口来获得回调者对接口方法的实现
    public void setToolBarClickListener(ToolBarClickListener toolBarClickListener) {
        this.toolBarClickListener = toolBarClickListener;
    }

    // 接口对象，实现回调机制，在回调方法中
    // 通过映射的接口对象调用接口中的方法
    // 而不用去考虑如何实现，具体的实现由调用者去创建
    interface ToolBarClickListener {
        // 左按钮点击事件
        void leftOnClick();

        // 右按钮点击事件
        void rightOnClick();
    }

    /**
     * 设置按钮的显示与否 通过id区分按钮，flag区分是否显示
     *
     * @param id   id
     * @param flag 是否显示
     */
    public void setBtnVisibility(int id, boolean flag) {
        if (flag) {
            if (id == 0) {
                mLeftBtn.setVisibility(VISIBLE);
            } else {
                mRightBtn.setVisibility(VISIBLE);
            }
        } else {
            if (id == 0) {
                mLeftBtn.setVisibility(GONE);
            } else {
                mRightBtn.setVisibility(GONE);
            }
        }
    }

}
