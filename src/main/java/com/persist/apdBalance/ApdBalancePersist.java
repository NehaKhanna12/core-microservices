package com.persist.apdBalance;
import com.dto.apdBalance.ApdBalanceRequest;
import com.dto.apdBalance.ApdBalanceResponse;
import com.exception.PersistentException;;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.utility.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;

@Repository
public class ApdBalancePersist implements IApdBalancePersist {
    Logger logger = LoggerFactory.getLogger(ApdBalancePersist.class);
    @Autowired
    RestTemplate restTemplate;
    @Value("${esbBaseURL}")
    private String esbBaseURL;
    @Value("${esbApdBalance}")
    private String apdBalanceToken;
    @Override
    @HystrixCommand(fallbackMethod = "getFallBackFetchApdBalanceFromESBService",threadPoolKey = "apdBalance",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "30000")
    })
    public ApdBalanceResponse fetchApdBalanceFromESBService(ApdBalanceRequest apdBalanceRequest) {
        String url = null;
        ApdBalanceResponse policyResponse =null;
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add(Constant.AUTHORIZATION, apdBalanceToken);
        headers.add(Constant.CONTENT_TYPE, Constant.APPLICATION_JSON);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        HttpEntity<ApdBalanceRequest> apdBalanceRequestHttpEntity = new HttpEntity<>(apdBalanceRequest, headers);
        try {
            logger.info("Fetch apd balance from core service"+
                    "fetchApdBalanceFromESBService:"+apdBalanceRequest.getAccountId());
            logger.info("Fetch apd balance thread details : " + Thread.currentThread().getName() +  "  Request Type :: " + apdBalanceRequest.getAccountId());
            url = esbBaseURL + "/apd/apdBal";
            policyResponse = restTemplate.postForObject(url, apdBalanceRequestHttpEntity, ApdBalanceResponse.class);
        }catch(PersistentException ex){
            logger.error("getPolicyApplication : -" + ex.getMessage());
            throw new PersistentException("getPolicyApplication", ex);
        }catch (Exception ex){
            ex.printStackTrace();
            logger.error("getPolicyApplication : -" + ex.getMessage());
            throw new PersistentException("getPolicyApplication", ex);
        }
        return policyResponse;
    }
    public ApdBalanceResponse getFallBackFetchApdBalanceFromESBService(ApdBalanceRequest apdBalanceRequest){
        logger.info("Fallback apd balance thread details : " + Thread.currentThread().getName() +  "  Request Type :: " + apdBalanceRequest.getAccountId());
        return  new ApdBalanceResponse();
    }
}
