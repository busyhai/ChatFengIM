package com.mding.chatfeng.base_common.bean.login;

import com.mding.chatfeng.base_common.bean.BaseBean;

/**
 * 短信验证码登录
 * wdh
 */
public class SmsLoginBean extends BaseBean {


    private int code;
    private String msg;
    private String method;
    private RecordBean record;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public RecordBean getRecord() {
        return record;
    }

    public void setRecord(RecordBean record) {
        this.record = record;
    }

    public static class RecordBean {
        /**
         * nickName : 杰克
         * userId : cfa4-6337-6e4
         * mobile : 18150960007
         * wxSno : 8ef25d1f506e97bd456b5c1e4
         * userToken : 996343CB-1172-CC9B-A4F7-819ACA6C9FFA
         * isFirstLogin : 2
         * headImg : data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAQAAAAEACAYAAABccqhmAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyZpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMTM4IDc5LjE1OTgyNCwgMjAxNi8wOS8xNC0wMTowOTowMSAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIDIwMTcgKFdpbmRvd3MpIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOjg5NTRDNzc2RTg3QTExRTg4NEUxQkJDMTJEOTI3Njc4IiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOjg5NTRDNzc3RTg3QTExRTg4NEUxQkJDMTJEOTI3Njc4Ij4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6ODk1NEM3NzRFODdBMTFFODg0RTFCQkMxMkQ5Mjc2NzgiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6ODk1NEM3NzVFODdBMTFFODg0RTFCQkMxMkQ5Mjc2NzgiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz7ZQ2pHAABCz0lEQVR42uy9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
         * qrcode : 1_xm6leefun_cfa4-6337-6e4
         * personaSignature :
         * modified : 1553932319
         * isUpdate : 1
         * serverIpWs : ws://127.0.0.1:5053
         * upSnoNum : 1
         * serverIpHttp : 127.0.0.1:5052
         */

        private String nickName;
        private String userId;
        private String mobile;
        private String wxSno;
        private String userToken;
        private int isFirstLogin;
        private String headImg;
        private String qrcode;
        private String personaSignature;
        private String modified;
        private int isUpdate;
        private String serverIpWs;
        private String upSnoNum;
        private String serverIpHttp;

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getWxSno() {
            return wxSno;
        }

        public void setWxSno(String wxSno) {
            this.wxSno = wxSno;
        }

        public String getUserToken() {
            return userToken;
        }

        public void setUserToken(String userToken) {
            this.userToken = userToken;
        }

        public int getIsFirstLogin() {
            return isFirstLogin;
        }

        public void setIsFirstLogin(int isFirstLogin) {
            this.isFirstLogin = isFirstLogin;
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public String getQrcode() {
            return qrcode;
        }

        public void setQrcode(String qrcode) {
            this.qrcode = qrcode;
        }

        public String getPersonaSignature() {
            return personaSignature;
        }

        public void setPersonaSignature(String personaSignature) {
            this.personaSignature = personaSignature;
        }

        public String getModified() {
            return modified;
        }

        public void setModified(String modified) {
            this.modified = modified;
        }

        public int getIsUpdate() {
            return isUpdate;
        }

        public void setIsUpdate(int isUpdate) {
            this.isUpdate = isUpdate;
        }

        public String getServerIpWs() {
            return serverIpWs;
        }

        public void setServerIpWs(String serverIpWs) {
            this.serverIpWs = serverIpWs;
        }

        public String getUpSnoNum() {
            return upSnoNum;
        }

        public void setUpSnoNum(String upSnoNum) {
            this.upSnoNum = upSnoNum;
        }

        public String getServerIpHttp() {
            return serverIpHttp;
        }

        public void setServerIpHttp(String serverIpHttp) {
            this.serverIpHttp = serverIpHttp;
        }
    }
}
