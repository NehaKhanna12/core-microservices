package com.persist.bulkUpload;

import com.dto.bulkUpload.*;
import com.dto.cityName.CityNameResponse;
import com.dto.elixirUpdateEIA.ElixirUpdateEIAResponse;
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
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.net.URI;
import java.util.*;

@Repository
public class BulkUploadPersist implements IBulkUploadPersist {

    Logger logger = LoggerFactory.getLogger(BulkUploadPersist.class);

    RestTemplate restTemplate;

    @Autowired
    public BulkUploadPersist(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
    }

    @Value("${esbBaseURL}")
    private String esbBaseURL;

    @Value("${esbBulkUploadReceipt}")
    private String esbBulkUploadReceipt;


    @HystrixCommand(fallbackMethod = "getFallBackReceiptBulkUploadFromESBService",threadPoolKey = "bulkUpload",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "30000")
    })

    @Override
    public BulkUploadReceiptResponse receiptBulkUploadFromESBService(BulkUploadReceiptRequest bulkUploadReceiptRequest) throws PersistentException {

        String url = null;
        BulkUploadReceiptResponse bulkUploadReceiptResponse =null;
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        List<ReceiptDTO> receiptRequest = new ArrayList<>();
        Map<String, String> response = new HashMap<String, String>();
        List<ReceiptDTO> uploadData = bulkUploadReceiptRequest.getPayload();
        Gson gson = new Gson();
        String requestLog =  gson.toJson(bulkUploadReceiptRequest);
        logger.info("Receipt BulkUpload++++++===========>"+requestLog);
        for(ReceiptDTO razorpayReceiptDto:uploadData){
            receiptRequest.add(razorpayReceiptDto);
        }
        headers.add(Constant.AUTHORIZATION, esbBulkUploadReceipt);
        headers.add(Constant.CONTENT_TYPE, Constant.APPLICATION_JSON);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        HttpEntity<Object> esbCoreDetailsRequestHttpEntity = new HttpEntity<>(uploadData, headers);
        try {
            logger.info("Fetch receipt BulkUpload From ESBService::::" +
                    "receiptBulkUploadFromESBService: Entity type:- " + requestLog);
            logger.info("Bulk upload thread details : " + Thread.currentThread().getName() +  "  Request Type :: " + requestLog);
            url = esbBaseURL + "elixir/bulkUpload/receiptBulkUpload";
            URI uri = new URI(url);
            Gson geson =  new Gson();
            String req = geson.toJson(esbCoreDetailsRequestHttpEntity);
            logger.warn(req);
            Object res = restTemplate.postForObject(uri, esbCoreDetailsRequestHttpEntity, Object.class);
            String response1 =geson.toJson(res);
            bulkUploadReceiptResponse = geson.fromJson(response1,BulkUploadReceiptResponse.class);
            logger.info("Receipt BulkUpload Response++++++===========>"+bulkUploadReceiptResponse.toString());
        } catch (PersistentException ex) {
            logger.error("receiptBulkUploadFromESBService : -" + ex.getMessage());
            throw new PersistentException("receiptBulkUploadFromESBService", ex);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("receiptBulkUploadFromESBService : -" + ex.getMessage());
            throw new PersistentException("receiptBulkUploadFromESBService", ex);
        }
        return bulkUploadReceiptResponse;
    }

    @Override
    @HystrixCommand(fallbackMethod = "getFallBackfetchReceiptStatus",threadPoolKey = "receiptStatus",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "30000")
    })
    public List<ReceiptStatusResponse> fetchReceiptStatus(Map<String, String> uploadId) {
        String url = null;
        Gson gson = new Gson();
        List<ReceiptStatusResponse> receiptStatusResponse =null;
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add(Constant.AUTHORIZATION, esbBulkUploadReceipt);
        headers.add(Constant.CONTENT_TYPE, Constant.APPLICATION_JSON);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        HttpEntity<Object> fetchReceiptStatusHttpEntity = new HttpEntity<>(uploadId, headers);
        try {
            logger.info("Fetch receipt Status From ESBService::::" +
                    "fetchReceiptStatus: " + uploadId);
            logger.info("Receipt status thread details : " + Thread.currentThread().getName() +  "  Request Type :: " + uploadId);
            url = esbBaseURL + "elixir/bulkUpload/receiptStatus";
            Object  postForObject = restTemplate.postForObject(url, fetchReceiptStatusHttpEntity, Object.class);
            String responseString = gson.toJson(postForObject);
            Type listType = new TypeToken<List>() {}.getType();
            List readFromJson = gson.fromJson(responseString, listType);
            readFromJson.forEach(System.out::println);
            receiptStatusResponse = gson.fromJson(responseString, listType);
            logger.info("Response for elixir/bulkUpload/receiptStatus:::"+receiptStatusResponse.toString());
        } catch (PersistentException ex) {
            logger.error("fetchReceiptStatus PersistentException : -" + ex.getMessage());
            throw new PersistentException("fetchReceiptStatus", ex);
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("fetchReceiptStatus Exception: -" + ex.getMessage());
            throw new PersistentException("fetchReceiptStatus", ex);
        }
        return receiptStatusResponse;
    }

    public BulkUploadReceiptResponse getFallBackReceiptBulkUploadFromESBService(BulkUploadReceiptRequest bulkUploadReceiptRequest){
        logger.info("Fallback Bulk upload thread details : " + Thread.currentThread().getName() +  "  Request Type :: " + bulkUploadReceiptRequest.toString());
        logger.info("HYSTRIX getFallBackReceiptBulkUploadFromESBService");
        return  new BulkUploadReceiptResponse();
    }

    public List<ReceiptStatusResponse> getFallBackfetchReceiptStatus(Map<String, String> receiptStatus){
        logger.info("Fallback Receipt status thread details : " + Thread.currentThread().getName() +  "  Request Type :: " + receiptStatus);
        logger.info("HYSTRIX getFallBackfetchReceiptStatus");
        return  new LinkedList<ReceiptStatusResponse>();
    }

}
