package com.persist.cityName;

import com.dto.apdBalance.ApdBalanceRequest;
import com.dto.apdBalance.ApdBalanceResponse;
import com.dto.cityName.CityDetails;
import com.dto.cityName.CityNameRequest;
import com.dto.cityName.CityNameResponse;
import com.exception.PersistentException;
import com.exception.RestTemplateResponseErrorHandler;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.utility.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class CityNamePersist implements ICityNamePersist {

    @Value("${esbBaseURL}")
    private String esbBaseURL;

    @Value("${esbCityToken}")
    private String esbCityToken;
    @Autowired
    RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(CityNamePersist.class);
    @Autowired
    public CityNamePersist(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
    }

    @HystrixCommand(fallbackMethod = "getFallBackFetchGetCityNameFromESBService", threadPoolKey = "cityStateGet", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "30000")
    })
    @Override
    public CityNameResponse getCityNameFromESBService(@Valid CityNameRequest cityNameRequest)
            throws PersistentException {
        logger.info("thread details : " + Thread.currentThread().getName() +  "  Request Type :: " + cityNameRequest.getStateCode() + "Request Value :: " + cityNameRequest.getTownCode());
        String url = null;
        Gson gson = new Gson();
        CityNameResponse cityNameResponse =null;
        HttpHeaders headers = new HttpHeaders();
        headers.set(Constant.AUTHORIZATION, esbCityToken);
        headers.set(Constant.CONTENT_TYPE, Constant.APPLICATION_JSON);
        Map<String, String> params = new HashMap<String, String>();
        params.put("stateCode", cityNameRequest.getStateCode());
        params.put("townCode", cityNameRequest.getTownCode());

        HttpEntity entity = new HttpEntity(headers);

        try {
            logger.info("Fetch city from core service"+
                    "getCityNameFromESBService: State Code : "+cityNameRequest.getStateCode() + " Town code: "+cityNameRequest.getTownCode(),params);
            url = esbBaseURL + "/claim/city?stateCode={stateCode}&townCode={townCode}";
            ResponseEntity<Object> cityNameResponseResponseEntity = restTemplate.exchange(url,  HttpMethod.GET,entity,Object.class,params);
            logger.warn(cityNameResponseResponseEntity.getBody().toString());
            if(cityNameResponseResponseEntity!=null && cityNameResponseResponseEntity.getBody()!=null ){
                String response = gson.toJson(cityNameResponseResponseEntity.getBody());
                cityNameResponse = gson.fromJson(response, CityNameResponse.class);

            }
            logger.info(cityNameResponse.toString());
        }catch(PersistentException ex){
            logger.error("PersistentException getCityNameFromESBService : -" + ex.getMessage());
            throw new PersistentException("getCityNameFromESBService", ex);
        }catch (Exception ex){
            ex.printStackTrace();
            logger.error("Exception getCityNameFromESBService : -" + ex.getMessage());
            throw new PersistentException("getCityNameFromESBService", ex);
        }
        return cityNameResponse;
    }
    public CityNameResponse getFallBackFetchGetCityNameFromESBService(@Valid CityNameRequest cityNameRequest)
            throws PersistentException {
        logger.info("HYSTRIX CITY NAME RESPONSE getFallBackFetchGetCityNameFromESBService");
        logger.info("fallback thread details : " + Thread.currentThread().getName() +  "  Request Type :: " + cityNameRequest.getStateCode() + "Request Value :: " + cityNameRequest.getTownCode());
        return new CityNameResponse();
    }
}
