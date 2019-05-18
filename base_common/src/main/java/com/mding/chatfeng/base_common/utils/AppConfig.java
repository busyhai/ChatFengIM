package com.mding.chatfeng.base_common.utils;

public class AppConfig {



    public static String getComponName(Class clazz){
        return clazz.getPackage().getName()+"."+clazz.getSimpleName();
    }




}
