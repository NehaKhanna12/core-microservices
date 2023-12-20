package com.dto.elixirUpdateEIA;
public class ElixirUpdateEIARequest {
    @Override
    public String toString() {
        return "ElixirUpdateEIARequest{" +
                "policyNumber='" + policyNumber + '\'' +
                ", eiaNumber='" + eiaNumber + '\'' +
                '}';
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getEiaNumber() {
        return eiaNumber;
    }

    public void setEiaNumber(String eiaNumber) {
        this.eiaNumber = eiaNumber;
    }

    private String policyNumber;
    private String eiaNumber;
}
