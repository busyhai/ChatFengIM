package com.mding.chatfeng.socket.data;

/**
 * Created by xuhao on 2017/5/22.
 */

public class HandShakeBean extends ProtocolSend {
String userId,token;
    public HandShakeBean() {
        if(false)
        {
            //A用户
            userId="f8da-5b32-3a5";
            token="B04B071F-29F1-C16B-5F48-32DFF2EC9041";
        }else
        {
            userId="5d58-6c6e-dec";
            token="D7CE0F88-4C23-10D1-6BD3-6E677CF95AC7";
        }

        com.alibaba.fastjson.JSONObject params = new com.alibaba.fastjson.JSONObject();

        com.alibaba.fastjson.JSONObject parameters = new com.alibaba.fastjson.JSONObject();
        com.alibaba.fastjson.JSONArray objects = new com.alibaba.fastjson.JSONArray();
        try {

            parameters.put("userId",userId);
            parameters.put("token",token);
            objects.add(parameters);

            params.put("ctn", "PersonCenter");
            params.put("mtn", "bindUid");
            params.put("version", "3.0.0");
            params.put("data", objects);

            content = params.toJSONString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


