package debug;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.billy.cc.core.component.CCUtil;
import com.billy.cc.core.component.IComponentCallback;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mding.chatfeng.base_common.utils.AppConfig;
import com.mding.chatfeng.base_common.utils.CompentHelper;
import com.mding.chatfeng.base_interceptor.Interceptor;
import com.mding.chatfeng.socket.R;
import com.mding.chatfeng.socket.RedirectException;
import com.mding.chatfeng.socket.components.IC_Socket;
import com.mding.chatfeng.socket.components.task.IA_BindUid;
import com.mding.chatfeng.socket.data.HandShakeBean;
import com.mding.chatfeng.socket.data.MsgDataBean;
import com.mding.chatfeng.socket.data.ProtocolReceive;
import com.mding.chatfeng.socket.data.PulseBean;
import com.xuhao.didi.core.iocore.interfaces.IPulseSendable;
import com.xuhao.didi.core.iocore.interfaces.ISendable;
import com.xuhao.didi.core.pojo.OriginalData;
import com.xuhao.didi.socket.client.impl.client.action.ActionDispatcher;
import com.xuhao.didi.socket.client.sdk.OkSocket;
import com.xuhao.didi.socket.client.sdk.client.ConnectionInfo;
import com.xuhao.didi.socket.client.sdk.client.OkSocketOptions;
import com.xuhao.didi.socket.client.sdk.client.action.SocketActionAdapter;
import com.xuhao.didi.socket.client.sdk.client.connection.IConnectionManager;
import com.xuhao.didi.socket.client.sdk.client.connection.NoneReconnect;


import java.nio.charset.Charset;
import java.util.Arrays;

public class SocketActivity extends AppCompatActivity {
    private ConnectionInfo mInfo;
    private IConnectionManager mManager;
    private SocketActionAdapter adapter = new SocketActionAdapter() {

        @Override
        public void onSocketConnectionSuccess(ConnectionInfo info, String action) {
            logRece("连接成功(Connecting Successful)");

            mManager.send(new HandShakeBean());

            initSwitch();
            mManager.getPulseManager().setPulseSendable(new PulseBean());
//            mManager.getPulseManager().trigger();.pulse()

        }

        private void initSwitch() {
            OkSocketOptions okSocketOptions = mManager.getOption();

        }

        @Override
        public void onSocketDisconnection(ConnectionInfo info, String action, Exception e) {
            if (e != null) {
                if (e instanceof RedirectException) {
                    logSend("正在重定向连接(Redirect Connecting)...");
                    mManager.switchConnectionInfo(((RedirectException) e).redirectInfo);
                    mManager.connect();

                } else {
                    logSend("异常断开(Disconnected with exception):" + e.getMessage());

                }
            } else {
                logSend("正常断开(Disconnect Manually)");

            }


        }

        @Override
        public void onSocketConnectionFailed(ConnectionInfo info, String action, Exception e) {
            logSend("连接失败(Connecting Failed)");


        }

        @Override
        public void onSocketReadResponse(ConnectionInfo info, String action, OriginalData data) {
            String str = new String(data.getBodyBytes(), Charset.forName("utf-8"));
            JsonObject jsonObject = new JsonParser().parse(str).getAsJsonObject();

            String mtn = jsonObject.get("method").getAsString();

            if (mtn.equals("bindUid")) {
                //绑定成功
                String handshake = jsonObject.get("msg").getAsString();
                logRece("握手成功! 握手信息(Handshake Success):" + handshake + ". 开始心跳(Start Heartbeat)..");

            } else if (mtn.equals("cdx")) {//切换,重定向.(暂时无法演示,如有疑问请咨询github)
                String ip = jsonObject.get("data").getAsString().split(":")[0];
                int port = Integer.parseInt(jsonObject.get("data").getAsString().split(":")[1]);
                ConnectionInfo redirectInfo = new ConnectionInfo(ip, port);
                redirectInfo.setBackupInfo(mInfo.getBackupInfo());
                mManager.getReconnectionManager().addIgnoreException(RedirectException.class);
                mManager.disconnect(new RedirectException(redirectInfo));
            } else if (mtn.equals("heart")) {//心跳
                logRece("收到心跳,喂狗成功(Heartbeat Received,Feed the Dog)");
                mManager.getPulseManager().feed();
            } else if (mtn.equals("receivePrivateChat")) {
                logRece("收到一条消息:"+jsonObject.toString());

            } else {
                logRece("未收到心跳");
                logRece(str);
            }
        }

        @Override
        public void onSocketWriteResponse(ConnectionInfo info, String action, ISendable data) {
            byte[] bytes = data.parse();

            bytes = Arrays.copyOfRange(bytes, 4, bytes.length);

            String str = new String(bytes, Charset.forName("utf-8"));

            JsonElement mJsonParserss=  new JsonParser().parse(str);


        /*    if (mJsonParserss.isJsonArray())
            { */
            JsonObject jsonObject = mJsonParserss.getAsJsonObject();

           String mtn = jsonObject.get("mtn").getAsString();
            switch (mtn) {
                case "bindUid": {
                    String handshake = jsonObject.get("mtn").getAsString();
                    logSend("发送握手绑定数据成功，启动心跳:" + handshake);
                    mManager.getPulseManager().pulse();
                    break;
                }
                default:
                    logSend(str);
            }
         /*   }else {
                logSend(str);
            }*/

        }

        @Override
        public void onPulseSend(ConnectionInfo info, IPulseSendable data) {
            byte[] bytes = data.parse();
            bytes = Arrays.copyOfRange(bytes, 4, bytes.length);
            String str = new String(bytes, Charset.forName("utf-8"));
            JsonObject jsonObject = new JsonParser().parse(str).getAsJsonObject();
            logSend("onPulseSend:"+jsonObject.toString());
            String method = jsonObject.get("mtn").getAsString();
            if (method.equals("heart")) {
//                mManager.getPulseManager().trigger();
                logSend("发送心跳包(Heartbeat Sending)");
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket);

        initData();
        setListener();
        mManager.connect();




    }


    private void initData(){
        mInfo = new ConnectionInfo("192.168.4.133", 5055);

        final Handler handler = new Handler(Looper.getMainLooper());
        OkSocketOptions.Builder builder = new ProtocolReceive().ProtocolByReceive();

            builder.setReconnectionManager(new NoneReconnect());
//      builder.setReconnectionManager(OkSocketOptions.getDefault().getReconnectionManager());
        builder.setCallbackThreadModeToken(new OkSocketOptions.ThreadModeToken() {
            @Override
            public void handleCallbackEvent(ActionDispatcher.ActionRunnable runnable) {
                handler.post(runnable);
            }
        });
        mManager = OkSocket.open(mInfo).option(builder.build());

        //设置心跳频率
        OkSocketOptions okOptions = new OkSocketOptions.Builder(mManager.getOption())
                .setPulseFrequency(Long.parseLong("270000"))
                .build();
        mManager.option(okOptions);
    }



    private void setListener() {
        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MsgDataBean msgDataBean = new MsgDataBean();
                mManager.send(msgDataBean);
               logRece(msgDataBean.toString());
            }
        });
        mManager.registerReceiver(adapter);




        CompentHelper.create(IC_Socket.class, IA_BindUid.class).addInterceptor(new Interceptor()).build().callAsync(new IComponentCallback() {
            @Override
            public void onResult(CC loginCC, CCResult result) {
                AppConfig.logs(result.toString());

//                button.setText("ddddddddddddddddddd");
            }
        });

    }




    private void logSend(String log) {
        Log.d("xf",log);
    }


    private void logRece(String log) {
        Log.d("xf",log);
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mManager != null) {
            mManager.disconnect();
            mManager.unRegisterReceiver(adapter);
        }
    }

}
