package com.dto.coreDetails;



import java.io.Serializable;


public class Policy implements Serializable {
    private String commencementDate;

    @Override
    public String toString() {
        return "Policy{" +
                "commencementDate='" + commencementDate + '\'' +
                ", agent=" + agent +
                ", application=" + application +
                ", endDate='" + endDate + '\'' +
                ", fullPolicyNumber='" + fullPolicyNumber + '\'' +
                ", contCovBenEligibility='" + contCovBenEligibility + '\'' +
                ", policyNumber='" + policyNumber + '\'' +
                ", client=" + client +
                ", issueDate='" + issueDate + '\'' +
                ", paymentDetails=" + paymentDetails +
                ", policyStatus='" + policyStatus + '\'' +
                ", brandCode='" + brandCode + '\'' +
                ", productCode='" + productCode + '\'' +
                '}';
    }

    public String getCommencementDate() {
        return commencementDate;
    }

    public void setCommencementDate(String commencementDate) {
        this.commencementDate = commencementDate;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getFullPolicyNumber() {
        return fullPolicyNumber;
    }

    public void setFullPolicyNumber(String fullPolicyNumber) {
        this.fullPolicyNumber = fullPolicyNumber;
    }

    public String getContCovBenEligibility() {
        return contCovBenEligibility;
    }

    public void setContCovBenEligibility(String contCovBenEligibility) {
        this.contCovBenEligibility = contCovBenEligibility;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public String getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(String policyStatus) {
        this.policyStatus = policyStatus;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    private Agent agent;

    private Application application;

    private String endDate;

    private String fullPolicyNumber;

    private String contCovBenEligibility;

    private String policyNumber;

    private Client client;

    private String issueDate;

    private PaymentDetails paymentDetails;

    private String policyStatus;

    private String brandCode;

    private String productCode;
}
