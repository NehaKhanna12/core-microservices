package com.dto.coreDetails;



import java.io.Serializable;


public class Address implements Serializable {
    private String town;

    private String countryCode;

    @Override
    public String toString() {
        return "Address{" +
                "town='" + town + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", stateCode='" + stateCode + '\'' +
                ", addressLine3='" + addressLine3 + '\'' +
                '}';
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    private String pinCode;

    private String addressLine1;

    private String addressLine2;

    private String stateCode;

    private String addressLine3;
}
