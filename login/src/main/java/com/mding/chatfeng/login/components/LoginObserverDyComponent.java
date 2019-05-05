package com.mding.chatfeng.login.components;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.billy.cc.core.component.IDynamicComponent;
import com.billy.cc.core.component.IMainThread;
import com.mding.chatfeng.login.util.Login;

/**
 * 监听登录状态的动态组件
 */
public class LoginObserverDyComponent implements IDynamicComponent, IMainThread {

    private static final String ACTION_REFRESH_STATUS = "refreshStatus";
    private String dynamicComponentName;
    private ILoginObserver loginObserver;
    private volatile boolean listening;

    public interface ILoginObserver {
        /**
         * 登录状态切换的回调
         * @param userId 登录用户的id，若为null则为未登录或退出登录
         */
        void refreshLoginUser(String userId);

        /**
         * refreshLoginUser(userId)方法是否在主线程运行
         * @return true:是，false:否
         */
        boolean isRefreshLoginUserRunOnMainThread();
    }

    public LoginObserverDyComponent(ILoginObserver observer) {
        this.loginObserver = observer;
        //为了确保动态组件类的多个不同的对象被准确调用到
        //每个组件对象的名称不重复
        dynamicComponentName = "login_observer_" + System.currentTimeMillis();
    }

    @Override
    public String getName() {
        return dynamicComponentName;
    }

    @Override
    public boolean onCall(CC cc) {
        String actionName = cc.getActionName();
        if (ACTION_REFRESH_STATUS.equals(actionName)) {
            String userId = cc.getParamItem(Login.KEY_USER_ID);
            final ILoginObserver listener = this.loginObserver;
            if (listener != null) {
                listener.refreshLoginUser(userId);
            }
        }
        CC.sendCCResult(cc.getCallId(), CCResult.success());
        return false;
    }

    @Override
    public Boolean shouldActionRunOnMainThread(String actionName, CC cc) {
        if (loginObserver != null) {
            return loginObserver.isRefreshLoginUserRunOnMainThread();
        }
        return null;
    }

    public void start() {
        if (listening) {
            return;
        }
        listening = true;
        //将自身注册到CC框架中
        CC.registerComponent(this);
        //将自身注册到登录组件的监听列表中
        CC.obtainBuilder(Login.NAME)
                .setActionName(Login.ACTION_ADD_LOGIN_OBSERVER)
                .addParam(Login.KEY_OBSERVER_COMPONENT_NAME, dynamicComponentName)
                .addParam(Login.KEY_OBSERVER_ACTION_NAME, ACTION_REFRESH_STATUS)
                .build().callAsync();
    }

    public void stop() {
        //将自身从登录组件的监听列表中移除
        CC.obtainBuilder(Login.NAME)
                .setActionName(Login.ACTION_DEL_LOGIN_OBSERVER)
                .addParam(Login.KEY_OBSERVER_COMPONENT_NAME, dynamicComponentName)
                .addParam(Login.KEY_OBSERVER_ACTION_NAME, ACTION_REFRESH_STATUS)
                .build().callAsync();
        //将自身从CC框架中注销
        CC.unregisterComponent(this);
        listening = false;
    }
}