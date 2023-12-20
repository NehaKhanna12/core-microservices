package com.dto.elixirUpdateEIA;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ElixirUpdateEIAResponse {

    private String policyNumber;

    @Override
    public String toString() {
        return "ElixirUpdateEIAResponse{" +
                "policyNumber='" + policyNumber + '\'' +
                ", status=" + status +
                '}';
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    private long status;
}
