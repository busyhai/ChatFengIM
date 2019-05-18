package com.mding.chatfeng.socket.adapter;

import android.util.Log;

import com.xuhao.didi.core.iocore.interfaces.IPulseSendable;
import com.xuhao.didi.core.iocore.interfaces.ISendable;
import com.xuhao.didi.core.pojo.OriginalData;
import com.xuhao.didi.socket.client.sdk.client.ConnectionInfo;
import com.xuhao.didi.socket.client.sdk.client.OkSocketOptions;
import com.xuhao.didi.socket.client.sdk.client.action.SocketActionAdapter;
import com.xuhao.didi.socket.client.sdk.client.connection.NoneReconnect;

import java.nio.charset.Charset;
import java.util.Arrays;

public class SocketListenAdapter extends SocketActionAdapter{

    public SocketListenAdapter() {
        super();
    }

    @Override
    public void onSocketIOThreadStart(String action) {
        super.onSocketIOThreadStart(action);
    }

    @Override
    public void onSocketIOThreadShutdown(String action, Exception e) {
        super.onSocketIOThreadShutdown(action, e);
    }

    @Override
    public void onSocketDisconnection(ConnectionInfo info, String action, Exception e) {
        super.onSocketDisconnection(info, action, e);
    }

    @Override
    public void onSocketConnectionSuccess(ConnectionInfo info, String action) {
        super.onSocketConnectionSuccess(info, action);
    }

    @Override
    public void onSocketConnectionFailed(ConnectionInfo info, String action, Exception e) {
        super.onSocketConnectionFailed(info, action, e);
    }

    @Override
    public void onSocketReadResponse(ConnectionInfo info, String action, OriginalData data) {
        super.onSocketReadResponse(info, action, data);
    }

    @Override
    public void onSocketWriteResponse(ConnectionInfo info, String action, ISendable data) {
        super.onSocketWriteResponse(info, action, data);
    }

    @Override
    public void onPulseSend(ConnectionInfo info, IPulseSendable data) {
        super.onPulseSend(info, data);
    }
}
