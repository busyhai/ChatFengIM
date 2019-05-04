package debug;

import android.app.Application;

import com.billy.cc.core.component.BuildConfig;
import com.billy.cc.core.component.CC;

public class DebugApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CC.enableDebug(false);
        CC.enableVerboseLog(false);
        CC.enableRemoteCC(false);
    }
}