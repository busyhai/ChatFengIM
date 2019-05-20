package com.mding.chatfeng.base_common.request.info;

/**
 * API键名
 * wdh
 */
public class BaseKeyName extends Http{
    //{"ctn":"PersonCenter", "mtn":"bindUid","version":"3.0.0","data":[{"userId":"5d58-6c6e-dec","token":"D7CE0F88-4C23-10D1-6BD3-6E677CF95AC7"}]}

    //请求的版本键名
    private final String version="version";


    //请求的数据体键名
    private final String data="data";


    public String getVersion() {
        return version;
    }

    public String getData() {
        return data;
    }
}
