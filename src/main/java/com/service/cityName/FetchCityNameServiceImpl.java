package com.service.cityName;

import com.dto.cityName.CityNameRequest;
import com.dto.cityName.CityNameResponse;
import com.exception.ServiceException;
import com.exception.BusinessException;
import com.exception.PersistentException;
import com.persist.cityName.ICityNamePersist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.io.IOException;

@Service
public class FetchCityNameServiceImpl implements IFetchCityNameService {

    private static final Logger logger = LoggerFactory.getLogger(FetchCityNameServiceImpl.class);

    @Autowired
    ICityNamePersist iCityNamePersist;

    @Override
    public CityNameResponse fetchCityName(@Valid CityNameRequest cityNameRequest) throws BusinessException, IOException {
        CityNameResponse cityNameResponse = null;
        try {
            cityNameResponse =  iCityNamePersist.getCityNameFromESBService(cityNameRequest);
        }catch(PersistentException |IOException ex){
            logger.error("Persistent Exception FetchCityNameServiceImpl : -" + ex.getMessage());
            throw new ServiceException("fetchCityName", ex);
        }
        return cityNameResponse;
    }
}
