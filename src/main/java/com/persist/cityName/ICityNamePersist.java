package com.persist.cityName;

import com.dto.cityName.CityNameRequest;
import com.dto.cityName.CityNameResponse;
import com.exception.PersistentException;

import javax.validation.Valid;
import java.io.IOException;

public interface ICityNamePersist {

    CityNameResponse getCityNameFromESBService(@Valid CityNameRequest cityNameRequest) throws PersistentException,IOException;
}
