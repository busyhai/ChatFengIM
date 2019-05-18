package com.mding.chatfeng.socket.components.task;

import android.util.Log;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.billy.cc.core.component.CCUtil;
import com.mding.chatfeng.base_common.utils.AppConfig;


/**
 * 使用Toekn作为登入依据
 * 用在欢迎页&登入页
 */
public class IA_BindUid implements IActionProcessor{

    @Override
    public String getActionName() {
        return getClass().getSimpleName();
    }

    @Override
    public boolean onActionCall(CC cc) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d("xf","~````````````````IA_BindUid~");
        CC.sendCCResult(cc.getCallId(), CCResult.success());

        return false;
    }







}