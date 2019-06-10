package com.mding.chatfeng.start;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.PowerManager;

import com.billy.cc.core.component.CC;

public class BaseApplication extends Application {
    //cpu常开，息屏保活
    private PowerManager pm;
    private PowerManager.WakeLock wakeLock;

    @SuppressLint("InvalidWakeLockTag")
    @Override
    public void onCreate() {
        super.onCreate();
        initCC(false);
//        QMUISwipeBackActivityManager.init(this);

        pm=(PowerManager)getSystemService(Context.POWER_SERVICE);
        wakeLock=pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,"CPUKeepRunning");
        wakeLock.acquire();


    }


    private void initCC(boolean state){
        CC.enableDebug(state);
        CC.enableVerboseLog(true);
        CC.enableRemoteCC(false);
    }
}