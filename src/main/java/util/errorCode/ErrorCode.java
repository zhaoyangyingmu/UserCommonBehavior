package util.errorCode;

public enum ErrorCode {
    SUCCESS(0, "成功！"),

    // 用户部分
    INFO_NOT_COMPLETE(1001, "缺失参数"),
    REGISTER_FAILED(1002, "注册失败");


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
