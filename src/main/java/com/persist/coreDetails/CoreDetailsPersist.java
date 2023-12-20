package com.persist.coreDetails;

import com.dto.coreDetails.CoreDetailsResponse;
import com.dto.coreDetails.ESBCoreDetailsRequest;
import com.exception.DatabaseException;
import com.exception.EntityNotFoundException;
import com.exception.RestTemplateResponseErrorHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.dto.coreDetails.Arg0;
import com.dto.coreDetails.CoreDetailsRequest;
import com.exception.PersistentException;
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
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Repository
public class CoreDetailsPersist implements ICoreDetailsPersist {

    @Value("${esbBaseURL}")
    private String esbBaseURL;

    @Value("${esbCoreToken}")
    private String esbCoreToken;

    @Autowired
    RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(CoreDetailsPersist.class);

    @Override
    @HystrixCommand(fallbackMethod = "getFallBackFetchGetCoreDetailsFromESBService",threadPoolKey = "policyDetails", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "30000")
    },ignoreExceptions = {EntityNotFoundException.class})
    public CoreDetailsResponse getCoreDetailsFromESBService(CoreDetailsRequest coreDetailsRequest) throws PersistentException {
        logger.info("thread details : " + Thread.currentThread().getName() +  "  Request Type :: " + coreDetailsRequest.getEntityType() + "Request Value :: " + coreDetailsRequest.getEntityValue());
        ESBCoreDetailsRequest esbCoreDetailsRequest = new ESBCoreDetailsRequest();
        Arg0 arg0 = new Arg0();
        arg0.setAction("Policy");
        arg0.setRequestType(coreDetailsRequest.getEntityType());
        arg0.setPolicyNumber(coreDetailsRequest.getEntityValue());
        esbCoreDetailsRequest.setArg0(arg0);

        String url = null;
        CoreDetailsResponse coreDetailsResponse = null;
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add(Constant.AUTHORIZATION, esbCoreToken);
        headers.add(Constant.CONTENT_TYPE, Constant.APPLICATION_JSON);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        HttpEntity<Object> esbCoreDetailsRequestHttpEntity = new HttpEntity<>(esbCoreDetailsRequest, headers);
        try {
            logger.info("Fetch policy or application details from core system" +
                    "getCoreDetailsFromESBService: Entity type:- " + coreDetailsRequest.getEntityType() + " Entity value is:- " + coreDetailsRequest.getEntityValue());
            url = esbBaseURL + "rest/website/getPolicyDetails";
            URI uri = new URI(url);
            Gson geson = new Gson();
            String req = geson.toJson(esbCoreDetailsRequestHttpEntity);
            logger.warn(req);
            Object res = restTemplate.postForObject(uri, esbCoreDetailsRequestHttpEntity, Object.class);
            String response = geson.toJson(res);
            if (response.contains("NB2048") || response.contains("NB2049")) {
                logger.info("here i am");
                throw new EntityNotFoundException(coreDetailsRequest.getEntityValue());
            }else if(response.contains("COM011")){
                logger.info("error in database access");
                throw new DatabaseException(coreDetailsRequest.getEntityValue());
            }
            coreDetailsResponse = geson.fromJson(response, CoreDetailsResponse.class);
            logger.info("Core details response:"+coreDetailsResponse.toString());
        }catch (PersistentException ex) {
            logger.error("getPolicyApplication : -" + ex.getMessage());
            throw new PersistentException("getPolicyApplication", ex);
        } catch (EntityNotFoundException ex) {
            logger.error("EntityNotFoundException getCoreDetailsFromESBService : -" + ex.getMessage());
            throw new EntityNotFoundException("EntityNotFoundException getCoreDetailsFromESBService", ex);
        }catch (Exception ex) {
            ex.printStackTrace();
            logger.error("getPolicyApplication getCoreDetailsFromESBService: -" + ex.getMessage());
            throw new PersistentException("getPolicyApplication", ex);
        }
        return coreDetailsResponse;
    }
    public CoreDetailsResponse getFallBackFetchGetCoreDetailsFromESBService(CoreDetailsRequest coreDetailsRequest) throws PersistentException {
        logger.warn("Falling back to circuit-breaker for getting policy {}", coreDetailsRequest.getEntityValue());
        logger.info("Fallback thread details : " + Thread.currentThread().getName() +  "  Request Type :: " + coreDetailsRequest.getEntityType() + "Request Value :: " + coreDetailsRequest.getEntityValue());
        throw new PersistentException(coreDetailsRequest.getEntityValue());
    }
}
