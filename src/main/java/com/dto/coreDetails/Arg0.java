package com.dto.coreDetails;

;

import java.io.Serializable;


public class Arg0  implements Serializable {
    private String policyNumber;

    @Override
    public String toString() {
        return "Arg0{" +
                "policyNumber='" + policyNumber + '\'' +
                ", action='" + action + '\'' +
                ", userID='" + userID + '\'' +
                ", requestType='" + requestType + '\'' +
                '}';
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    private String action;
    private String userID;
    private String requestType;
}
