package com.mding.chatfeng.base_common.request.base;

import android.util.Log;

import com.mding.chatfeng.base_common.request.info.BaseKeyName;

/**
 * wdh
 * 基础配置
 */
public class AppConfig extends BaseKeyName {
    protected String version="3.0.0";
    //集群IP收集中心
    private String clusterIp="111.111.111.111";
    //socket长链接的ip和端口
    public static  String baseIP="192.168.4.133",port="9090";
    //短连接请求的域名
    public static String baseUrl="api.chatfeng.com";
    //本地数据库的请求基础参数
    protected String dbPath="/local";
    //文件系统路径
    protected String filePath="/img/";


    public AppConfig() {
        //首次利用组件请求收集IP地址，如果请求不到，将尝试用上一次IP地址，如果没有地址或地址无效，将重试第一个步骤
        String ClusterInfo=clusterIp.concat("V2_0_0").concat("LoginController").concat("getClusterIp");
        logs(ClusterInfo);
    }

    public static void logs(String rs){
             Log.d("xf",rs);
    }

}
