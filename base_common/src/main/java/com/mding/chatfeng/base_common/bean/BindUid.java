package com.mding.chatfeng.base_common.bean;

import java.util.List;

public class BindUid {

    /**
     * ctn : PersonCenter
     * mtn : bindUid
     * version : 3.0.0
     * data : [{"userId":"f8da-5b32-3a5","token":"B04B071F-29F1-C16B-5F48-32DFF2EC9041"}]
     */
    private String ctn="PersonCenter";
    private String mtn="bindUid";
    private String version="3.0.0";
    private List<DataBean> data;

    public String getCtn() {
        return ctn;
    }

    public void setCtn(String ctn) {
        this.ctn = ctn;
    }

    public String getMtn() {
        return mtn;
    }

    public void setMtn(String mtn) {
        this.mtn = mtn;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * userId : f8da-5b32-3a5
         * token : B04B071F-29F1-C16B-5F48-32DFF2EC9041
         */

        private String userId="f8da-5b32-3a5";
        private String token="B04B071F-29F1-C16B-5F48-32DFF2EC9041";

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

    @Override
    public String toString() {
        return "{" +
                "ctn='" + ctn + '\'' +
                ", mtn='" + mtn + '\'' +
                ", version='" + version + '\'' +
                ", data=" + data +
                '}';
    }
}
