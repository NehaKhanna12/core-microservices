package com.dto.cityName;



import java.util.List;


public class CityNameResponse {
    @Override
    public String toString() {
        return "CityNameResponse{" +
                "CityDetails=" + CityDetails +
                '}';
    }

    public List<com.dto.cityName.CityDetails> getCityDetails() {

        return CityDetails;
    }

    public void setCityDetails(List<com.dto.cityName.CityDetails> cityDetails) {
        CityDetails = cityDetails;
    }

    private List<CityDetails> CityDetails;
}
