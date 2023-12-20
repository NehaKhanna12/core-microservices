package com.dto.bulkUpload;

public class ReceiptStatusResponse {
    public String strApplnNbr;
    public String strPolNbr;
    public String strAcctId;
    public String status;
    public String strPisNbr;
    public String strErrorDesc;

    public String getStrApplnNbr() {
        return strApplnNbr;
    }

    public void setStrApplnNbr(String strApplnNbr) {
        this.strApplnNbr = strApplnNbr;
    }

    public String getStrPolNbr() {
        return strPolNbr;
    }

    public void setStrPolNbr(String strPolNbr) {
        this.strPolNbr = strPolNbr;
    }

    public String getStrAcctId() {
        return strAcctId;
    }

    public void setStrAcctId(String strAcctId) {
        this.strAcctId = strAcctId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStrPisNbr() {
        return strPisNbr;
    }

    public void setStrPisNbr(String strPisNbr) {
        this.strPisNbr = strPisNbr;
    }

    public String getStrErrorDesc() {
        return strErrorDesc;
    }

    public void setStrErrorDesc(String strErrorDesc) {
        this.strErrorDesc = strErrorDesc;
    }

    @Override
    public String toString() {
        return "ReceiptStatusResponse{" +
                "strApplnNbr='" + strApplnNbr + '\'' +
                ", strPolNbr='" + strPolNbr + '\'' +
                ", strAcctId='" + strAcctId + '\'' +
                ", status='" + status + '\'' +
                ", strPisNbr='" + strPisNbr + '\'' +
                ", strErrorDesc='" + strErrorDesc + '\'' +
                '}';
    }
}
