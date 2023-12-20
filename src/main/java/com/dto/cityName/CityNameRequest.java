package com.dto.cityName;


import java.io.Serializable;


public class CityNameRequest implements Serializable {

    private String stateCode;
    private String townCode;

    @Override
    public String toString() {
        return "CityNameRequest{" +
                "stateCode='" + stateCode + '\'' +
                ", townCode='" + townCode + '\'' +
                '}';
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getTownCode() {
        return townCode;
    }

    public void setTownCode(String townCode) {
        this.townCode = townCode;
    }
}
