package com.example.liyanqiang.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.liyanqiang.myapplication.R;

public class LoginActivity extends BasicActivity implements View.OnClickListener{
    /**
     *
     * 立即注册
     * @param savedInstanceState
     */
    private TextView tosign;
    private TextView forgetpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        setTitle(R.string.login);
        setBack();
    }
    public void init(){
        tosign=(TextView)findViewById(R.id.tosign);
        tosign.setOnClickListener(this);

        forgetpwd=(TextView)findViewById(R.id.forgetpwd);
        forgetpwd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.tosign://立即注册
                Intent intent=new Intent();
                intent.setClass(LoginActivity.this,SignActivity.class);
                startActivity(intent);
                break;
            case R.id.forgetpwd:
                Intent intent1=new Intent();
                intent1.setClass(LoginActivity.this,ForgetpwdActivity.class);
                startActivity(intent1);
        }
    }
}
