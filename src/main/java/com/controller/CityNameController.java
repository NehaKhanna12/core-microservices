package com.controller;

import com.exception.ServiceException;
import com.dto.cityName.CityNameRequest;
import com.dto.cityName.CityNameResponse;
import com.exception.APIRequestException;
import com.service.cityName.IFetchCityNameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(path = "/entity")
@Controller
public class CityNameController {

    private static final Logger logger = LoggerFactory.getLogger(CityNameController.class);

    @Autowired
    IFetchCityNameService iFetchCityNameService;

    @PostMapping(path="/getCityName", produces = "application/json")
    public ResponseEntity<CityNameResponse> getCityName(@Valid @RequestBody CityNameRequest cityNameRequest)
    {
        CityNameResponse cityNameResponse = null;
        try {
            cityNameResponse = iFetchCityNameService.fetchCityName(cityNameRequest);
        } catch (ServiceException ex){
            logger.error(ex.getMessage());
            throw new APIRequestException("ESB Service Exception!", ex);
        }catch (Exception ex){
            logger.error(ex.toString());
            throw new APIRequestException("UnHandled Exception!", ex);
        }
        return new ResponseEntity<CityNameResponse>(cityNameResponse, HttpStatus.OK);
    }
}
