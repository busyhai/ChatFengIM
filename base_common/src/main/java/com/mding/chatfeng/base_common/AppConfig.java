package com.mding.chatfeng.base_common;

import android.util.Log;

import com.mding.chatfeng.base_common.request.base.BaseKeyName;

/**
 * wdh
 * 基础配置
 */
public class AppConfig extends BaseKeyName {
    public static final String version="V3_0_0";

    //集群IP请求地址
    public static String clusterIp="http://www.xm6leefun.cn:5052";
    //短连接请求的地址
    public static  String httpProtocolIp/*="http://www.xm6leefun.cn:5052"*/;
    //ws长链接的请求的地址
    public static  String wsProtocolIp_1/*="www.xm6leefun.cn:5055"*/;
    //ws长链接的请求的地址
    public static  String wsProtocolIp_2/*="www.xm6leefun.cn:5055"*/;
    //sk长链接的请求的地址1
    public static  String skProtocolIp_1/*="www.xm6leefun.cn"*/;
    //sk长链接的请求的地址2
    public static  String skProtocolIp_2/*="www.xm6leefun.cn"*/;

//    public static  int skProtocolPort/*=5055*/;
    //设置socket心跳频率
    public static final String setPulseFrequency="270000";



    //本地数据库的请求基础参数
    protected String dbPath="/local";
    //文件系统路径
    protected String filePath="/img/";



    public static void logs(String rs){
             Log.d("xf",rs);
    }

}
