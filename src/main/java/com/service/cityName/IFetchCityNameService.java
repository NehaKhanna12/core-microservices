package com.service.cityName;

import com.dto.cityName.CityNameRequest;
import com.dto.cityName.CityNameResponse;
import com.exception.BusinessException;

import javax.validation.Valid;
import java.io.IOException;

public interface IFetchCityNameService {

    CityNameResponse fetchCityName(@Valid CityNameRequest cityNameRequest) throws BusinessException,IOException;
}
