package com.example.liyanqiang.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.liyanqiang.myapplication.R;

public class SignActivity extends BasicActivity implements View.OnClickListener {
    /**
     * 用户名

     */
    private EditText username;
    private EditText idcard;
    private EditText phone;
    private EditText pwd;
    private EditText pwd1;

    /**
     * 注册按钮
     */
    private Button sign;

    /**
     * 同意注册条件按钮
     * @param savedInstanceState
     */
    private RadioButton radio;
    //判断radioButton是否被选中
    private boolean flag=false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        init();
        setTitle(R.string.app_name);
        setBack();
    }
    /**
     * 初始化方法
     */
    public void init(){
        username=(EditText)findViewById(R.id.username);
        idcard=(EditText)findViewById(R.id.idcard);
        phone=(EditText)findViewById(R.id.phone);
        pwd=(EditText)findViewById(R.id.pwd);
        pwd1=(EditText)findViewById(R.id.pwd1);

        sign=(Button)findViewById(R.id.sign);
        sign.setOnClickListener(this);

        radio=(RadioButton)findViewById(R.id.radio);
        radio.setOnClickListener(this);



    }
    /**
     * 禁止EditText输入空格
     * @param editText
     */
    public static void setEditTextInhibitInputSpace(EditText editText){
        InputFilter filter=new InputFilter() {
            /**
             * @param source 输入的文字
             * @param start 输入-0，删除-0
             * @param end 输入-文字的长度，删除-0
             * @param dest 原先显示的内容
             * @param dstart 输入-原光标位置，删除-光标删除结束位置
             * @param dend  输入-原光标位置，删除-光标删除开始位置
             * @return
             */
            @Override public CharSequence filter(CharSequence source, int start, int end,
                                                 Spanned dest, int dstart, int dend) {
                if(source.equals(" "))return ""; else return null;
            }
        };
        editText.setFilters(new InputFilter[]{filter});
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.radio://是否同意注册
                if(flag){
                    radio.setChecked(flag);
                    flag=false;
                }else {
                    radio.setChecked(flag);
                    flag=true;
                }
                break;
            case R.id.sign://注册按钮
                if(radio.isChecked()){
                    setEditTextInhibitInputSpace(username);

                    if(username.getText().toString().isEmpty()
                            || username.getText().toString().trim().equals("")
                            || username.getText().toString().length()<2){
                        Toast.makeText(SignActivity.this,
                                "注册名不能为空或小于两字符",
                                Toast.LENGTH_SHORT).show();
                    }else if(idcard.getText().toString().isEmpty()||
                            idcard.getText().toString().trim().equals("")
                            //|| idcard.length()!=18
                            ){
                        Toast.makeText(SignActivity.this,
                                "请输入符合规范的身份证号",
                                Toast.LENGTH_SHORT).show();


                        }
                        else if(phone.getText().toString().isEmpty()||
                            phone.getText().toString().trim().equals("")
                            //|| phone.length()!=11
                            ){
                        Toast.makeText(SignActivity.this,
                                "请输入符合规范的手机号",
                                Toast.LENGTH_SHORT).show();


                    }
                        else {
                        Toast.makeText(SignActivity.this,
                                "注册成功",
                                Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent();
                        intent.setClass(this,LoginActivity.class);

                        startActivity(intent);
                    }

                }else {
                    Toast.makeText(SignActivity.this,
                            "必需同意注册协议后才能点击注册",
                            Toast.LENGTH_SHORT).show();
                }

                break;
        }

    }
}
