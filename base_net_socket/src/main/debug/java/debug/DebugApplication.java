package debug;

import android.app.Application;

import com.billy.cc.core.component.BuildConfig;
import com.billy.cc.core.component.CC;
import com.mding.chatfeng.base_common.request.bean.PrivateChatBean;
import com.mding.chatfeng.base_common.request.bean.UserBean;
import com.mding.chatfeng.base_common.request.Create;
import com.mding.chatfeng.base_common.request.base.AppConfig;

public class DebugApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CC.enableDebug(BuildConfig.DEBUG);
        CC.enableVerboseLog(BuildConfig.DEBUG);
        CC.enableRemoteCC(BuildConfig.DEBUG);


    AppConfig.logs(Create.getRequestSocket().bindUid(new UserBean("fwwf111111111111fw","fwfw")));

    PrivateChatBean mPrivateChatBean=new PrivateChatBean("@@@@@@@@","$$23");
    mPrivateChatBean.setFriendsId("wd");
    mPrivateChatBean.setMessage("你对我的的hi海沃德");
    AppConfig.logs(Create.getRequestSocket().sendPrivateChat(mPrivateChatBean));
    AppConfig.logs(Create.getRequestSocket().heart());


    }


    }
