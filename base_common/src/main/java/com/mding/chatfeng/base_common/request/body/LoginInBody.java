package com.mding.chatfeng.base_common.request.body;

public class LoginInBody {
    private String sno;
    private String password;
    private String modelName;
    private String machineCode;
    private String modified;

    public LoginInBody(String sno, String password, String modelName, String machineCode, String modified) {
        this.sno = sno;
        this.password = password;
        this.modelName = modelName;
        this.machineCode = machineCode;
        this.modified = modified;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getMachineCode() {
        return machineCode;
    }

    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }
}
