package com.dto.proposalStatus;


import java.util.List;

public class ApplicationData {
    private String proposerName;

    private String applicationNumber;

    @Override
    public String toString() {
        return "ApplicationData{" +
                "proposerName='" + proposerName + '\'' +
                ", applicationNumber='" + applicationNumber + '\'' +
                ", productData=" + productData +
                ", proposalReceivedDate='" + proposalReceivedDate + '\'' +
                ", applicationDate='" + applicationDate + '\'' +
                ", prospectNumber='" + prospectNumber + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getProposerName() {
        return proposerName;
    }

    public void setProposerName(String proposerName) {
        this.proposerName = proposerName;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public List<ProductData> getProductData() {
        return productData;
    }

    public void setProductData(List<ProductData> productData) {
        this.productData = productData;
    }

    public String getProposalReceivedDate() {
        return proposalReceivedDate;
    }

    public void setProposalReceivedDate(String proposalReceivedDate) {
        this.proposalReceivedDate = proposalReceivedDate;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getProspectNumber() {
        return prospectNumber;
    }

    public void setProspectNumber(String prospectNumber) {
        this.prospectNumber = prospectNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private List<ProductData> productData;

    private String proposalReceivedDate;

    private String applicationDate;

    private String prospectNumber;

    private String status;
}
