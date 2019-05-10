package com.mding.chatfeng.start;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.billy.cc.core.component.CCUtil;
import com.billy.cc.core.component.IComponentCallback;
import com.billy.cc.core.component.IDynamicComponent;
import com.billy.cc.core.component.IMainThread;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

     /*   //注册动态组件
        CC.registerComponent(new LoginUserObserverComponent());


//或 异步调用，在主线程执行回调
        String callId = CC.obtainBuilder("login.IC_CheckLogin")
                .setActionName("IA_LoginByToken")
                .build()
                .callAsyncCallbackOnMainThread(new IComponentCallback() {
                    @Override
                    public void onResult(CC cc, CCResult result) {
                        //此onResult在主线程中运行
                        String toast = "IA_LoginByToken " + (result.isSuccess() ? "success" : "failed");
                        Toast.makeText(StartActivity.this, toast, Toast.LENGTH_SHORT).show();
                        Log.d("xx",result.isSuccess()+"");
//                        finish();

                    }
                });
*/

        CC.obtainBuilder("login.IC_CheckLogin")
                .setActionName("IA_FindTokenAndLogin")
                .build()
                .callAsync(new IComponentCallback() {
                    @Override
                    public void onResult(CC loginCC, CCResult result) {
                        String toast = "IA_LoginByToken " + (result.isSuccess() ? "success" : "failed");


              /*          //跳转至登入页
                        CC.obtainBuilder("login.IC_CheckLogin")
                                .setActionName("IA_FindTokenAndLogin").addParam("toAct",true)
                                .build()
                                .call();*/
                    }
                });



    }




/*
     CC.obtainBuilder("base_common.IC_CheckLogin")
             .setActionName("IA_GetTokenAndSave")
                .build()
                .callAsync(new IComponentCallback() {
        @Override
        public void onResult(CC loginCC, CCResult result) {
            String toast = "IA_LoginByToken " + (result.isSuccess() ? "success" : "failed");


              *//*          //跳转至登入页
                        CC.obtainBuilder("login.IC_CheckLogin")
                                .setActionName("IA_FindTokenAndLogin").addParam("toAct",true)
                                .build()
                                .call();*//*
        }
    });*/


    /**
     * 监听用户登录状态的动态组件
     */
    class LoginUserObserverComponent implements IDynamicComponent, IMainThread {

        @NonNull
        String observerComponentName;
        static final String OBSERVER_ACTION_NAME = "loginUserState";

        LoginUserObserverComponent() {
            //指定此动态组件的ComponentName为一个唯一值，不会因为activity有多个对象而出现重复
            this.observerComponentName = "mainActivityUserObserver_";
        }

        @Override
        public String getName() {
            return observerComponentName;
        }

        @Override
        public boolean onCall(CC cc) {
            Log.d("xx","~~~~~~~~~~~~~~~~~~~~~~~~");
            String actionName = cc.getActionName();
            if (OBSERVER_ACTION_NAME.equals(actionName)) {
                //在进入此处时，当前线程一定为主线程（是在shouldActionRunOnMainThread方法中指定的）
                return onLoginUserChanged(cc);
            }
            CC.sendCCResult(cc.getCallId(), CCResult.errorUnsupportedActionName());
            return false;
        }

        private boolean onLoginUserChanged(CC cc) {

            CC.sendCCResult(cc.getCallId(), CCResult.success());
            return false;
        }

        @Override
        public Boolean shouldActionRunOnMainThread(String actionName, CC cc) {
            if (OBSERVER_ACTION_NAME.equals(actionName)) {
                //指定observerActionName被调用时，onCall方法在主线程运行
                Log.d("xx","~~~~~~~~~~~111~~~~~~~~~~~~~");
                return true;
            }
            return null;
        }
    }

}
