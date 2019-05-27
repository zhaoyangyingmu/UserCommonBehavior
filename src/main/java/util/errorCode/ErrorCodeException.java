package util.errorCode;

public abstract class ErrorCodeException extends Exception {
    private int errCode;
    private String type;
    private String details;
    // protected String msg;
    // ErrorCode 放着类型和错误码信息， message放着详细信息。
    public ErrorCodeException(ErrorCode errorCode, String details) {
        this.details = details;
        this.errCode = errorCode.getErrorCode();
        this.type = errorCode.getType();
    }

    public int getErrCode() {
        return errCode;
    }

    public String getType() {
        return type;
    }

    public String getDetails() {
        return details;
    }
}
