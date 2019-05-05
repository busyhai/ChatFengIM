package com.mding.chatfeng.start;

import android.app.Application;

import com.billy.cc.core.component.CC;
import com.qmuiteam.qmui.arch.QMUISwipeBackActivityManager;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initCC(false);
        QMUISwipeBackActivityManager.init(this);
    }


    private void initCC(boolean state){
        CC.enableDebug(state);
        CC.enableVerboseLog(state);
        CC.enableRemoteCC(state);
    }
}