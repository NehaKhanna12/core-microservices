package com.dto.coreDetails;


public class Error {
    private String errorDescription;
    private String errorCode;

    @Override
    public String toString() {
        return "Error{" +
                "errorDescription='" + errorDescription + '\'' +
                ", errorCode='" + errorCode + '\'' +
                '}';
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
