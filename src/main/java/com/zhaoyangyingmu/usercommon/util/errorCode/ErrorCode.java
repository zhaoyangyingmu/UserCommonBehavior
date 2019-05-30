package com.zhaoyangyingmu.usercommon.util.errorCode;

public enum ErrorCode {
    SUCCESS(0, "成功！"),

    // 用户部分
    INFO_NOT_COMPLETE(1001, "缺失参数"),
    REGISTER_FAILED(1002, "注册失败"),
    DUPLICATE_USERNAME(1003, "重复的用户名"),
    LOGIN_FAILED(1004, "登陆失败"),
    HAVENT_LOGINED(1005, "需要先登陆");


    private int errorCode;
    private String type;
    ErrorCode(int errorCode, String type) {
        this.errorCode = errorCode;
        this.type = type;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getType() {
        return type;
    }
}
