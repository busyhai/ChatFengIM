package com.mding.chatfeng.home.component;

import android.util.Log;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.billy.cc.core.component.CCUtil;
import com.billy.cc.core.component.IComponent;
import com.mding.chatfeng.home.HomeActivity;

public class Loading implements IComponent {
    @Override
    public String getName() {
        return "home.Loading";
    }

    @Override
    public boolean onCall(CC cc) {
        String actionName = cc.getActionName();
        switch (actionName) {
            case "loading":
                onLoading(cc);
                break;
            case "getLifecycleFragment":
                //demo for provide fragment object to other component

                break;
            case "lifecycleFragment.addText":

                break;
            case "getInfo":

                break;
            default:
                //这个逻辑分支上没有调用CC.sendCCResult(...),是一种错误的示例
                //并且方法的返回值为false，代表不会异步调用CC.sendCCResult(...)
                //在LocalCCInterceptor中将会返回错误码为-10的CCResult
                break;
        }
        return false;
    }



    private void onLoading(CC cc) {
        //此处写异步加载数据函数
        Log.d("xx","此处写异步加载数据函数");

        openActivity(cc);
    }

    private void openActivity(CC cc) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CCUtil.navigateTo(cc, HomeActivity.class);
        CC.sendCCResult(cc.getCallId(), CCResult.success());

    }
}
