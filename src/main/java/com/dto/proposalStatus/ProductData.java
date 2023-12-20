package com.dto.proposalStatus;


public class ProductData {
    private String sumAssured;

    private String productVersion;

    private String productCode;

    @Override
    public String toString() {
        return "ProductData{" +
                "sumAssured='" + sumAssured + '\'' +
                ", productVersion='" + productVersion + '\'' +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                '}';
    }

    public String getSumAssured() {
        return sumAssured;
    }

    public void setSumAssured(String sumAssured) {
        this.sumAssured = sumAssured;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    private String productName;

    private String productType;
}
