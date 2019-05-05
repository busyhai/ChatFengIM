package com.mding.chatfeng.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class LoginActivity extends BaseActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //开启登录状态监听
        startListenLoginState();
        //...
    }

    @Override
    public void refreshLoginUser(String userId) {
        //开启登录监听时和登录状态改变时会调用此方法
        //demo: 在主线程Toast当前userId
        boolean isLogin = userId != null;
        Toast.makeText(this, "userId=" + userId
                + ", isLogin=" + isLogin, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean isRefreshLoginUserRunOnMainThread() {
        //指定refreshLoginUser方法在主线程运行
        return true;
    }
}
