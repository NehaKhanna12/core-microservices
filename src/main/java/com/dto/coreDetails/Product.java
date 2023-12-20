package com.dto.coreDetails;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Product implements Serializable {
    @SerializedName("SACCode")
    private String SACCode;
    @SerializedName("SACCounter")
    private String SACCounter;
    @SerializedName("discountAmount")
    private String discountAmount;
    private String productName;
    @SerializedName("loadingAmount")
    private String loadingAmount;
    @SerializedName("productLine")
    private String productLine;
    @SerializedName("sumAssured")
    private String sumAssured;

    @Override
    public String toString() {
        return "Product{" +
                "SACCode='" + SACCode + '\'' +
                ", SACCounter='" + SACCounter + '\'' +
                ", discountAmount='" + discountAmount + '\'' +
                ", productName='" + productName + '\'' +
                ", loadingAmount='" + loadingAmount + '\'' +
                ", productLine='" + productLine + '\'' +
                ", sumAssured='" + sumAssured + '\'' +
                ", basePremiumAmount='" + basePremiumAmount + '\'' +
                ", productVersion='" + productVersion + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productGroup='" + productGroup + '\'' +
                ", clientCode='" + clientCode + '\'' +
                ", grossPremiumAmount='" + grossPremiumAmount + '\'' +
                ", taxAmount='" + taxAmount + '\'' +
                ", CBAmount='" + CBAmount + '\'' +
                ", productType='" + productType + '\'' +
                ", sourceCode='" + sourceCode + '\'' +
                '}';
    }

    public String getSACCode() {
        return SACCode;
    }

    public void setSACCode(String SACCode) {
        this.SACCode = SACCode;
    }

    public String getSACCounter() {
        return SACCounter;
    }

    public void setSACCounter(String SACCounter) {
        this.SACCounter = SACCounter;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getLoadingAmount() {
        return loadingAmount;
    }

    public void setLoadingAmount(String loadingAmount) {
        this.loadingAmount = loadingAmount;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getSumAssured() {
        return sumAssured;
    }

    public void setSumAssured(String sumAssured) {
        this.sumAssured = sumAssured;
    }

    public String getBasePremiumAmount() {
        return basePremiumAmount;
    }

    public void setBasePremiumAmount(String basePremiumAmount) {
        this.basePremiumAmount = basePremiumAmount;
    }

    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getGrossPremiumAmount() {
        return grossPremiumAmount;
    }

    public void setGrossPremiumAmount(String grossPremiumAmount) {
        this.grossPremiumAmount = grossPremiumAmount;
    }

    public String getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(String taxAmount) {
        this.taxAmount = taxAmount;
    }

    public String getCBAmount() {
        return CBAmount;
    }

    public void setCBAmount(String CBAmount) {
        this.CBAmount = CBAmount;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    @SerializedName("basePremiumAmount")
    private String basePremiumAmount;
    @SerializedName("productVersion")
    private String productVersion;
    @SerializedName("productCode")
    private String productCode;
    @SerializedName("productGroup")
    private String productGroup;
    @SerializedName("clientCode")
    private String clientCode;
    @SerializedName("grossPremiumAmount")
    private String grossPremiumAmount;
    @SerializedName("taxAmount")
    private String taxAmount;
    @SerializedName("CBAmount")
    private String CBAmount;
    @SerializedName("productType")
    private String productType;
    @SerializedName("sourceCode")
    private String sourceCode;
}
