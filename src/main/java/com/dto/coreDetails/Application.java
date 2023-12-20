package com.dto.coreDetails;



import java.io.Serializable;


public class Application implements Serializable {
    private String ruralFlag;

    private Proposer proposer;

    private String TPANameCode;

    private String paymentMethod;

    @Override
    public String toString() {
        return "Application{" +
                "ruralFlag='" + ruralFlag + '\'' +
                ", proposer=" + proposer +
                ", TPANameCode='" + TPANameCode + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", PDO='" + PDO + '\'' +
                ", relationToNomineeCode='" + relationToNomineeCode + '\'' +
                ", applicationNumber='" + applicationNumber + '\'' +
                '}';
    }

    public String getRuralFlag() {
        return ruralFlag;
    }

    public void setRuralFlag(String ruralFlag) {
        this.ruralFlag = ruralFlag;
    }

    public Proposer getProposer() {
        return proposer;
    }

    public void setProposer(Proposer proposer) {
        this.proposer = proposer;
    }

    public String getTPANameCode() {
        return TPANameCode;
    }

    public void setTPANameCode(String TPANameCode) {
        this.TPANameCode = TPANameCode;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPDO() {
        return PDO;
    }

    public void setPDO(String PDO) {
        this.PDO = PDO;
    }

    public String getRelationToNomineeCode() {
        return relationToNomineeCode;
    }

    public void setRelationToNomineeCode(String relationToNomineeCode) {
        this.relationToNomineeCode = relationToNomineeCode;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    private String PDO;

    private String relationToNomineeCode;

    private String applicationNumber;
}
