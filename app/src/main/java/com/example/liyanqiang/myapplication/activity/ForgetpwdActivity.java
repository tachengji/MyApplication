package com.example.liyanqiang.myapplication.activity;

import android.os.Bundle;
import android.view.View;

import com.example.liyanqiang.myapplication.R;

public  class ForgetpwdActivity extends BasicActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpwd);
        setTitle(R.string.forgetpwd);
        setBack();
    }

    @Override
    public void onClick(View v) {

    }
}
