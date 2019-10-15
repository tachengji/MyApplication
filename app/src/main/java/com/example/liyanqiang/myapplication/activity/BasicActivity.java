package com.example.liyanqiang.myapplication.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liyanqiang.myapplication.R;


public  class BasicActivity extends FragmentActivity {

    /**
     * 左侧返回
     * @param savedInstanceState
     */
    private ImageView left;

    /**
     * 标题头
     * @param savedInstanceState
     */private TextView title;

    /**
     * 右侧设置
     * @param savedInstanceState
     */
    private ImageView set;
    private Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context=this;

        //init();
        //setTitle("");
        }



    /**
     * 返回
     */
    public void setBack(){
        left=(ImageView)findViewById(R.id.head_left);
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });


    }

    /**
     * 设置标题头
     * @param name
     */

    public void setTitle(String name){
        title=(TextView)findViewById(R.id.head_title);
        title.setText(name);
    }
    public void setTitle(int name){
        title=(TextView)findViewById(R.id.head_title);
        title.setText(name);
    }
    public void setTitle(){
        title=(TextView)findViewById(R.id.head_title);
        title.setText("");//或隐藏掉
        //title.setVisibility();
    }



}
