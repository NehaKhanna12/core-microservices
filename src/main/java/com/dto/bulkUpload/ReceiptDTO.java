package com.dto.bulkUpload;

public class ReceiptDTO {

    private String cashBankCode;
    private String ifscCode;
    private String bankAccountNumber;
    private String instrumentorPaymentDate;
    private String paymentRefNumber;
    private String paymentAmount;
    private String chequeClass;
    private String ccNumber;
    private String ccHolderName;
    private String bankBranchCode;
    private String payorName;
    private int payorRelation;
    private String applicationNumber;
    private String policyNumber;
    private String accountId;
    private String productCode;
    private String businessType;
    private String strPisNbr;
    private String dtCreated;
    private String userId;
    private String dtUpdated;
    private String strUpdatedBy;

    public String getCashBankCode() {
        return cashBankCode;
    }

    public void setCashBankCode(String cashBankCode) {
        this.cashBankCode = cashBankCode;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getInstrumentorPaymentDate() {
        return instrumentorPaymentDate;
    }

    public void setInstrumentorPaymentDate(String instrumentorPaymentDate) {
        this.instrumentorPaymentDate = instrumentorPaymentDate;
    }

    public String getPaymentRefNumber() {
        return paymentRefNumber;
    }

    public void setPaymentRefNumber(String paymentRefNumber) {
        this.paymentRefNumber = paymentRefNumber;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getChequeClass() {
        return chequeClass;
    }

    public void setChequeClass(String chequeClass) {
        this.chequeClass = chequeClass;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getCcHolderName() {
        return ccHolderName;
    }

    public void setCcHolderName(String ccHolderName) {
        this.ccHolderName = ccHolderName;
    }

    public String getBankBranchCode() {
        return bankBranchCode;
    }

    public void setBankBranchCode(String bankBranchCode) {
        this.bankBranchCode = bankBranchCode;
    }

    public String getPayorName() {
        return payorName;
    }

    public void setPayorName(String payorName) {
        this.payorName = payorName;
    }

    public int getPayorRelation() {
        return payorRelation;
    }

    public void setPayorRelation(int payorRelation) {
        this.payorRelation = payorRelation;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getStrPisNbr() {
        return strPisNbr;
    }

    public void setStrPisNbr(String strPisNbr) {
        this.strPisNbr = strPisNbr;
    }

    public String getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(String dtCreated) {
        this.dtCreated = dtCreated;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDtUpdated() {
        return dtUpdated;
    }

    public void setDtUpdated(String dtUpdated) {
        this.dtUpdated = dtUpdated;
    }

    public String getStrUpdatedBy() {
        return strUpdatedBy;
    }

    public void setStrUpdatedBy(String strUpdatedBy) {
        this.strUpdatedBy = strUpdatedBy;
    }

    @Override
    public String toString() {
        return "RazorpayReceiptDto{" +
                "cashBankCode='" + cashBankCode + '\'' +
                ", ifscCode='" + ifscCode + '\'' +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                ", instrumentorPaymentDate='" + instrumentorPaymentDate + '\'' +
                ", paymentRefNumber='" + paymentRefNumber + '\'' +
                ", paymentAmount='" + paymentAmount + '\'' +
                ", chequeClass='" + chequeClass + '\'' +
                ", ccNumber='" + ccNumber + '\'' +
                ", ccHolderName='" + ccHolderName + '\'' +
                ", bankBranchCode='" + bankBranchCode + '\'' +
                ", payorName='" + payorName + '\'' +
                ", payorRelation=" + payorRelation +
                ", applicationNumber='" + applicationNumber + '\'' +
                ", policyNumber='" + policyNumber + '\'' +
                ", accountId='" + accountId + '\'' +
                ", productCode='" + productCode + '\'' +
                ", businessType='" + businessType + '\'' +
                ", strPisNbr='" + strPisNbr + '\'' +
                ", dtCreated='" + dtCreated + '\'' +
                ", userId='" + userId + '\'' +
                ", dtUpdated='" + dtUpdated + '\'' +
                ", strUpdatedBy='" + strUpdatedBy + '\'' +
                '}';
    }
}
