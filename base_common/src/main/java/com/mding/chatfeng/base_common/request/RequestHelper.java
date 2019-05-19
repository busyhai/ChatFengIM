package com.mding.chatfeng.base_common.request;

public class RequestHelper {
    public static RequestSocket mRequestSocket;
    public static RequestHttp mRequestHttp;
    public static RequestDb mRequestDb;


    public static RequestSocket getRequestSocket(){
        if (mRequestSocket==null)
            mRequestSocket=new RequestSocket();
        return mRequestSocket;
    }

    public static RequestHttp getRequestHttp(){
        if (mRequestHttp==null)
            mRequestHttp=new RequestHttp();
        return mRequestHttp;
    }


    public static RequestDb getRequestDb(){
        if (mRequestDb==null)
            mRequestDb=new RequestDb();
        return mRequestDb;
    }

}
