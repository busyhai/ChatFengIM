package com.mding.chatfeng.base_common.request;

import com.mding.chatfeng.base_common.bean.login.LoginInBean;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface  Api {

    /**
     * 通用接口
     * @param ctn
     * @param mtn
     * @param postData
     * @return
     */
    @POST("{pathVersion}/{ctn}/{mtn}")
    Call<ResponseBody> request(
            @Path("pathVersion") String pathVersion,
            @Path("ctn") String ctn,
            @Path("mtn") String mtn,
            @Body Object postData);


    /**
     * 获取集群接口
     * @param pathVersion
     * @param ctn
     * @param mtn
     * @param postData
     * @return
     */
    @GET("{pathVersion}/{ctn}/{mtn}")
    Call<ResponseBody> getClusterIp(
            @Url String url,
            @Path("pathVersion") String pathVersion,
            @Path("ctn") String ctn,
            @Path("mtn") String mtn,
            @Body Object postData);
}
