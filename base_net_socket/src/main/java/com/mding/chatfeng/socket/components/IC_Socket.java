package com.mding.chatfeng.socket.components;

import android.util.Log;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.billy.cc.core.component.IComponent;
import com.billy.cc.core.component.IMainThread;
import com.mding.chatfeng.base_common.utils.AppConfig;
import com.mding.chatfeng.socket.components.task.IA_BindUid;
import com.mding.chatfeng.socket.components.task.IActionProcessor;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class IC_Socket implements IComponent, IMainThread {

    private AtomicBoolean initialized = new AtomicBoolean(false);
    private final HashMap<String, IActionProcessor> map = new HashMap<>(4);

    private void initProcessors() {
    }

    private void add(IActionProcessor processor) {
        map.put(processor.getActionName(), processor);
    }

    @Override
    public String getName() {
        return getClass().getPackage().getName()+"."+getClass().getSimpleName();
    }

    @Override
    public boolean onCall(CC cc) {
        if (initialized.compareAndSet(false, true)) {
            synchronized (map) {
                initProcessors();
            }
        }
        String actionName = cc.getActionName();

        IActionProcessor processor = map.get(actionName);

        if (processor != null) {
            Log.d("xx",processor.getActionName());
            return processor.onActionCall(cc);
        }
        CC.sendCCResult(cc.getCallId(), CCResult.errorUnsupportedActionName());
        return false;
    }

    @Override
    public Boolean shouldActionRunOnMainThread(String actionName, CC cc) {
        if (IA_BindUid.class.getSimpleName().equals(actionName)) {


            return false;
        }
        return null;
    }
}
