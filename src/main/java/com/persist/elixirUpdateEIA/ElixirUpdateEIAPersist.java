package com.persist.elixirUpdateEIA;

import com.dto.elixirUpdateEIA.ElixirUpdateEIARequest;
import com.dto.elixirUpdateEIA.ElixirUpdateEIAResponse;
import com.exception.PersistentException;
import com.exception.RestTemplateResponseErrorHandler;
import com.google.gson.Gson;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.utility.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Repository
public class ElixirUpdateEIAPersist implements IElixirUpdateEIAPersist {

    @Value("${esbBaseURL}")
    private String esbBaseURL;

    @Value("${esbElixirUpdateEiaNumber}")
    private String esbElixirUpdateEiaNumber;

    private static final Logger logger = LoggerFactory.getLogger(ElixirUpdateEIAPersist.class);
    RestTemplate restTemplate;
    @Autowired
    public ElixirUpdateEIAPersist(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
    }
    @HystrixCommand(fallbackMethod = "getFallBackFetchUpdateEiaNumber",threadPoolKey = "eiaUpdate",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "30000")
    })
    @Override
    public ElixirUpdateEIAResponse updateEiaNumber(ElixirUpdateEIARequest elixirUpdateEIARequest) throws PersistentException {
        Gson gson = new Gson();
        String url = null;
        ElixirUpdateEIAResponse coreDetailsResponse = null;
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add(Constant.AUTHORIZATION, esbElixirUpdateEiaNumber);
        headers.add(Constant.CONTENT_TYPE, Constant.APPLICATION_JSON);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        HttpEntity<ElixirUpdateEIARequest> elixirUpdateEIARequestHttpEntity = new HttpEntity<>(elixirUpdateEIARequest, headers);
        try {
            logger.info("updateEiaNumber thread details : " + Thread.currentThread().getName() +  "  Request Type :: " + elixirUpdateEIARequest.getEiaNumber() + "Request Value :: " + elixirUpdateEIARequest.getPolicyNumber());
            logger.info("Update Eia number in core system" +
                    "updateEiaNumber: EIA Number :- " + elixirUpdateEIARequest.getEiaNumber() + "Policy number:-" + elixirUpdateEIARequest.getPolicyNumber());
            url = esbBaseURL + "eiadetails/updateEIANumber";
            Object  postForObject = restTemplate.postForObject(url, elixirUpdateEIARequestHttpEntity, Object.class);
            String responseString = gson.toJson(postForObject);
            coreDetailsResponse = gson.fromJson(responseString,ElixirUpdateEIAResponse.class);
            logger.info("UPdate EIA NUMBER RESPONSE::::"+coreDetailsResponse.toString());
        } catch (PersistentException ex) {
            logger.error("PersistentException updateEiaNumber : -" + ex.getMessage());
            throw new PersistentException("updateEiaNumber", ex);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("Exception updateEiaNumber : -" + ex.getMessage());
            throw new PersistentException("updateEiaNumber", ex);
        }
        return coreDetailsResponse;
    }
    public ElixirUpdateEIAResponse getFallBackFetchUpdateEiaNumber(ElixirUpdateEIARequest elixirUpdateEIARequest) throws PersistentException {
        logger.info("fallback updateEiaNumber thread details : " + Thread.currentThread().getName() +  "  Request Type :: " + elixirUpdateEIARequest.getEiaNumber() + "Request Value :: " + elixirUpdateEIARequest.getPolicyNumber());
        logger.info("HYSTRIX getFallBackFetchUpdateEiaNumber");
        return new ElixirUpdateEIAResponse();
    }
}
