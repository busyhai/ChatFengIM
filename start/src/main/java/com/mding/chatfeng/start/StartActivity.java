package com.mding.chatfeng.start;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.billy.cc.core.component.CCUtil;
import com.billy.cc.core.component.IComponentCallback;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

//或 异步调用，在主线程执行回调
        String callId = CC.obtainBuilder("home.Loading")
                .setActionName("loading")
                .build()
                .callAsyncCallbackOnMainThread(new IComponentCallback() {
                    @Override
                    public void onResult(CC cc, CCResult result) {
                        //此onResult在主线程中运行
                        String toast = "loading " + (result.isSuccess() ? "success" : "failed");
                        Toast.makeText(StartActivity.this, toast, Toast.LENGTH_SHORT).show();
                        Log.d("xx",result.isSuccess()+"");
                        finish();

                    }
                });



    }



}
