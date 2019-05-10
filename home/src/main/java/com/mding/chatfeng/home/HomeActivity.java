package com.mding.chatfeng.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.billy.cc.core.component.CCUtil;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



   /*     new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                        CC.obtainBuilder("mainActivityUserObserver_")
                                .setActionName("loginUserState")
                                .build().callAsync();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

            }
        }).start();*/




    }
}
