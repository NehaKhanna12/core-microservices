package com.dto.proposalStatus;


public class Arg0 {
    private String applicationNumber;
    private String proposalNumber;
    private String policyNumber;

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getProposalNumber() {
        return proposalNumber;
    }

    public void setProposalNumber(String proposalNumber) {
        this.proposalNumber = proposalNumber;
    }


    @Override
    public String toString() {
        return "Arg0{" +
                "applicationNumber='" + applicationNumber + '\'' +
                ", proposalNumber='" + proposalNumber + '\'' +
                ", policyNumber='" + policyNumber + '\'' +
                '}';
    }
}
