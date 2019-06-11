package com.mding.chatfeng.login;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.mding.chatfeng.base_common.ui.BaseActivity;


public class LoginActivity extends BaseActivity {

   public TextView loginUserTextView;

//    private LoginUserObserverComponent loginUserObserverComponent;
    private TextView loginUserButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


/*        loginUserButton = (TextView) findViewById(R.id.login_user_state_observer);
        loginUserButton.setOnClickListener(this);
        loginUserTextView = (TextView) findViewById(R.id.textView);
        loginUserTextView.setOnClickListener(this);
        loginUserButton.setText("注销用户动态组件");*/
    }

/*
    *//**
     * 添加组件到字典监听列表成功
     *//*
    @Override
    protected void addSucess() {

    }

    *//**
     * 远程数据返回时候，调用  UserStateManager.setLoginUser(new User(1, "wdh"));此方法 触发所有监听组件
     *//*
    @Override
    protected void listenData() {

        if (loginUserTextView != null) {

            AppConfig.logs(user == null ? "null" : user.getUserName());

           loginUserTextView.setText(getString(R.string.show_login_user, user == null ? "null" : user.getUserName()));
    }
    }*/
}