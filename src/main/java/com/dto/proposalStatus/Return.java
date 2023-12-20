package com.dto.proposalStatus;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Return {
    private String policyNumber;

    @Override
    public String toString() {
        return "Return{" +
                "policyNumber='" + policyNumber + '\'' +
                '}';
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }
}
