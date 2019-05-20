package com.mding.chatfeng.base_common.request.info;

/**
 * Socket请求控制器
 * wdh
 */
public class Ctn extends Mtn{
    private final String ctnPersonCenter="PersonCenter";
    private final String ctnMyAMQPTask="MyAMQPTask";



    public String getCtnPersonCenter() {
        return ctnPersonCenter;
    }

    public String getCtnMyAMQPTask() {
        return ctnMyAMQPTask;
    }

    public String ctnKey(){
        return Ctn.class.getSimpleName().toLowerCase();
    }

}
