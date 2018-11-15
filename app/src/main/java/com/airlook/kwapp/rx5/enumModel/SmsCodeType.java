package com.airlook.kwapp.rx5.enumModel;

public enum SmsCodeType {

//    int SMSAPP = 4;          //4-app手机注册或者登录
//    int SMSUPDATEPHONE = 3;  //得到验证码  type修改手机号
//    int SMSUPDATEPWD = 2;      //重置密码
//

    SMSAPP(2, "重置密码"), SMSUPDATEPHONE(3, "修改手机号"), SMSUPDATEPWD(4, "app手机注册或者登录");

    private int type;
    private String name;

    SmsCodeType(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
