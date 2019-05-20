package com.mding.chatfeng.base_common.request.type;

import com.billy.cc.core.component.CCUtil;
import com.mding.chatfeng.base_common.request.base.RequestCtrlBase;

import java.util.ArrayList;

/**
 * wdh
 *  socket请求专用
 */
public class RequestSocket extends RequestCtrlBase {
    private ArrayList<Object> beanList=new ArrayList<>();

    /**
     * 心跳包
     * @return
     */
    public String heart(){
        return setApi(getCtnPersonCenter(),getMtnHeart(),null);
    }


    /**
     * 握手绑定
     * @param dataBean
     * @return
     */
    public String bindUid(Object... dataBean){
       return setApi(getCtnPersonCenter(),getMtnBindUid(),dataBean);
    }

    /**
     * 握手绑定
     * @param dataBean
     * @return
     */
    public String kickUid(Object... dataBean){
        return setApi(getCtnPersonCenter(),getMtnBindUid(),dataBean);
    }

    /**
     * 私聊
     * @param dataBean
     * @return
     */
    public String sendPrivateChat(Object... dataBean){
        return setApi(getCtnMyAMQPTask(),getMtnSendPrivateChat(),dataBean);
    }


    /**
     * 设置API的控制器，方法名，数据体
     * @param mtnName
     * @param dataBean
     * @return
     */
    public String setApi(String ctnName,String mtnName,Object... dataBean){
        //设置头部、控制器和方法
        maps =setCtns(ctnName);
        putMtns(mtnName);

        //设置数据体
        if(dataBean!=null)
        {
            maps.put(getVersion(),version);
            beanList.clear();
            for(Object obj:dataBean)
                beanList.add(obj);
            putDatas(beanList);
        }
        return CCUtil.convertToJson(maps).toString();
    }



}
