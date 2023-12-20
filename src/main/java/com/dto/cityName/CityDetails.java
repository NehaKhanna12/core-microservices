package com.dto.cityName;
;

public class CityDetails {

    private String townName;
    private String townCode;
    private String stateId;

    @Override
    public String toString() {
        return "CityDetails{" +
                "townName='" + townName + '\'' +
                ", townCode='" + townCode + '\'' +
                ", stateId='" + stateId + '\'' +
                '}';
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getTownCode() {
        return townCode;
    }

    public void setTownCode(String townCode) {
        this.townCode = townCode;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }
}
