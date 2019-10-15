package com.example.liyanqiang.myapplication.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liyanqiang.myapplication.R;
import com.example.liyanqiang.myapplication.activity.ForgetpwdActivity;
import com.example.liyanqiang.myapplication.activity.LoginActivity;
import com.example.liyanqiang.myapplication.activity.SignActivity;


public class PersonFragment extends BaseFragment implements View.OnClickListener {

    private ImageView head;
    private TextView name;
    private View registerView;
    private View loginView;
    private View forgetView;
    private Button exitBtn;

    @Override
    public View initView() {
        View view=View.inflate(context, R.layout.fragment_person,null);

        head=(ImageView)view.findViewById(R.id.fragment_person_head);
        name=(TextView)view.findViewById(R.id.fragment_person_name);
        registerView=(View)view.findViewById(R.id.fragmet_person_sign);
        registerView.setOnClickListener(this);

        loginView=(View)view.findViewById(R.id.fragment_person_login);
        loginView.setOnClickListener(this);

        forgetView=(View)view.findViewById(R.id.fragment_person_forgetpwd);
        forgetView.setOnClickListener(this);

        exitBtn=(Button)view.findViewById(R.id.fragment_person_exit);
        exitBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        Intent intent=new Intent();

        switch (v.getId()) {
            case R.id.fragmet_person_sign://注册
                intent.setClass(getContext(),SignActivity.class);
                startActivity(intent);
                break;

            case R.id.fragment_person_login:
                intent.setClass(getContext(),LoginActivity.class);
                startActivity(intent);
                break;

            case R.id.fragment_person_forgetpwd:
                intent.setClass(getContext(),ForgetpwdActivity.class);
                startActivity(intent);
                break;

            case R.id.fragment_person_exit:
                getActivity().finish();
                break;

        }

    }
}
