package com.mding.chatfeng.login.components;

import android.text.TextUtils;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.billy.cc.core.component.IComponent;
import com.mding.chatfeng.login.util.Login;
import com.mding.chatfeng.login.util.LoginUserManager;

public class LoginComponent implements IComponent {
    @Override
    public String getName() {
        return Login.NAME;
    }

    @Override
    public boolean onCall(CC cc) {
        String actionName = cc.getActionName();
        switch (actionName) {
            //other cases...
            case Login.ACTION_ADD_LOGIN_OBSERVER: return addLoginObserver(cc);
            case Login.ACTION_DEL_LOGIN_OBSERVER: return delLoginObserver(cc);
            default: CC.sendCCResult(cc.getCallId(), CCResult.errorUnsupportedActionName());
        }
        return false;
    }

    private boolean addLoginObserver(CC cc) {
        String dyComponentName = cc.getParamItem(Login.KEY_OBSERVER_COMPONENT_NAME);
        String dyActionName = cc.getParamItem(Login.KEY_OBSERVER_ACTION_NAME);
        if (!TextUtils.isEmpty(dyComponentName)) {
            LoginUserManager.addObserver(dyComponentName, dyActionName);
            CC.sendCCResult(cc.getCallId(), CCResult.success());
        } else {
            CC.sendCCResult(cc.getCallId(), CCResult.error("no componentName"));
        }
        return false;
    }

    private boolean delLoginObserver(CC cc) {
        String dyComponentName = cc.getParamItem(Login.KEY_OBSERVER_COMPONENT_NAME);
        if (!TextUtils.isEmpty(dyComponentName)) {
            LoginUserManager.delObserver(dyComponentName);
            CC.sendCCResult(cc.getCallId(), CCResult.success());
        } else {
            CC.sendCCResult(cc.getCallId(), CCResult.error("no componentName"));
        }
        return false;
    }
}
