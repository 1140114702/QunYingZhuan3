package com.example.zyb.qunyingzhuan3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyToolBar toolBar = (MyToolBar) findViewById(R.id.my_toolbar);

        toolBar.setToolBarClickListener(new MyToolBar.ToolBarClickListener() {
            @Override
            public void leftOnClick() {
                show("点击了左边按钮");
            }

            @Override
            public void rightOnClick() {
               show("点击了右边按钮");
            }
        });

        toolBar.setBtnVisibility(0,true);
        toolBar.setBtnVisibility(1,false);
    }

    private void show(String makeText) {
        if (TextUtils.isEmpty(makeText)) {
            return;
        }
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(this, makeText,Toast.LENGTH_SHORT);
        toast.show();
    }

}
