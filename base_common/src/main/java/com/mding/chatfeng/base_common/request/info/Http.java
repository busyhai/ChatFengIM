package com.mding.chatfeng.base_common.request.info;

/**
 * Http请求控制器名
 * wdh
 */
public class Http extends Ctn{
    //短链接控制器名称
    private final String LoginController="/LoginController";


    private String LoginController(String name){
        return LoginController.concat("/").concat(name).concat("?");
    };


    /**
     * 获取集群ip接口
     * @return
     */
    protected final String getClusterIp(){
        return LoginController("getClusterIp");
    }

    /**
     * 用户注册接口
     * @return
     */
    protected final String register(){
        return LoginController("register");
    }

    /**
     * 登录接口
     * @return
     */
    protected final String loginIn(){
        return LoginController("loginIn");
    }

    /**
     * 短信验证码登录接口
     * @return
     */
    protected final String smsLogin(){
        return LoginController("smsLogin");
    }

    /**
     * 短信验证码登录接口
     * @return
     */
    protected final String getSmsCode(){
        return LoginController("getSmsCode");
    }

    /**
     * 版本检测
     * @return
     */
    protected final String appUpdate(){
        return LoginController("appUpdate");
    }

    /**
     * 注册设置头像昵称
     * @return
     */
    protected final String setHeadImg(){
        return LoginController("setHeadImg");
    }






}
