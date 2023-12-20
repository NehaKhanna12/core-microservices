package com.utility;

public enum ErrorCode {
    EntityNotFoundException (404),
    ESB_SERVICE_EXCEPTION (500),
    DATABASE_LEVEL_EXCEPTION (20000),
    OTHER_EXCEPTION (3000);

    private final int errorCode;

    ErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public  int getErrorCode() {
        return errorCode;
    }
}
