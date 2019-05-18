package debug;

import android.app.Application;
import android.util.Log;

import com.billy.cc.core.component.BuildConfig;
import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.billy.cc.core.component.IComponentCallback;
import com.mding.chatfeng.base_common.utils.AppConfig;
import com.mding.chatfeng.base_common.utils.CompentHelper;
import com.mding.chatfeng.base_interceptor.Base;
import com.mding.chatfeng.base_interceptor.Interceptor;
import com.mding.chatfeng.socket.components.IC_Socket;
import com.mding.chatfeng.socket.components.task.IA_BindUid;

public class DebugApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CC.enableDebug(BuildConfig.DEBUG);
        CC.enableVerboseLog(BuildConfig.DEBUG);
        CC.enableRemoteCC(BuildConfig.DEBUG);


    }
    }
