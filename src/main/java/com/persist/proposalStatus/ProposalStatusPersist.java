package com.persist.proposalStatus;

import com.dto.proposalStatus.Arg0;
import com.dto.proposalStatus.ESBProposalStatusRequest;
import com.dto.proposalStatus.ProposalStatusRequest;
import com.dto.proposalStatus.ProposalStatusResponse;
import com.exception.PersistentException;
import com.google.gson.Gson;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.utility.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Repository
public class ProposalStatusPersist implements IProposalStatusPersist {

    @Value("${esbBaseURL}")
    private String esbBaseURL;
    @Autowired
    RestTemplate restTemplate;
    @Value("${esbProposalStatusToken}")
    private String esbProposalStatusToken;

    private static final Logger logger = LoggerFactory.getLogger(ProposalStatusPersist.class);

    @Override
    @HystrixCommand(fallbackMethod = "getFallBackProposalStatusFromESBService", threadPoolKey = "proposalStatus", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "50000")
    })
    public ProposalStatusResponse getProposalStatusFromESBService(ProposalStatusRequest proposalStatusRequest) throws PersistentException {
        logger.info("thread details : " + Thread.currentThread().getName() +  "  Request Type :: " + proposalStatusRequest.getEntityType() + "Request Value :: " + proposalStatusRequest.getEntityValue());

        ESBProposalStatusRequest esbProposalStatusRequest = new ESBProposalStatusRequest();
        Arg0 arg0 = new Arg0();
        Gson gson =  new Gson();
        if("application".equalsIgnoreCase(proposalStatusRequest.getEntityType())){
            arg0.setApplicationNumber(proposalStatusRequest.getEntityValue().trim());
        }else if("proposal".equalsIgnoreCase(proposalStatusRequest.getEntityType())) {
            arg0.setProposalNumber(proposalStatusRequest.getEntityValue().trim());
        }else if("policy".equalsIgnoreCase(proposalStatusRequest.getEntityType())) {
            arg0.setPolicyNumber(proposalStatusRequest.getEntityValue().trim());
        }
        esbProposalStatusRequest.setArg0(arg0);
        String url = null;
        ProposalStatusResponse proposalStatusResponse =new ProposalStatusResponse();
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add(Constant.AUTHORIZATION, esbProposalStatusToken);
        headers.add(Constant.CONTENT_TYPE, Constant.APPLICATION_JSON);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        HttpEntity<ESBProposalStatusRequest> proposalStatusRequestHttpEntity = new HttpEntity<>(esbProposalStatusRequest, headers);
        try {
            logger.info("Entity type is:::" + proposalStatusRequest.getEntityType() + ":::Entity value : " + proposalStatusRequest.getEntityValue());
            url = esbBaseURL + "rest/ssp/GetProposalStatus";
            Object response = restTemplate.postForObject(url, proposalStatusRequestHttpEntity, Object.class);
            String responseString = gson.toJson(response);
            proposalStatusResponse = gson.fromJson(responseString, ProposalStatusResponse.class);
            proposalStatusResponse.setStatusCode("200");
            logger.info("Response for proposal number::::"+proposalStatusRequest.getEntityValue()+"::::is::::"+proposalStatusResponse.toString());
        }catch(HttpStatusCodeException exception) {
            int statusCode = exception.getStatusCode().value();
            logger.info("status code::::" + statusCode);
            if(statusCode==500){
                proposalStatusResponse.setStatusCode("404");}
            return proposalStatusResponse;
        }catch(PersistentException ex){
            logger.error("PersistentException ::::getProposalStatusFromESBService : -" + ex.getMessage());
            throw new PersistentException("getProposalStatusFromESBService", ex);
        }catch (Exception ex){
            ex.printStackTrace();
            logger.error("Exception getProposalStatusFromESBService : -" + ex.getMessage());
            throw new PersistentException("getProposalStatusFromESBService", ex);
        }
        return proposalStatusResponse;
    }
    public ProposalStatusResponse getFallBackProposalStatusFromESBService(ProposalStatusRequest proposalStatusRequest) throws PersistentException {
        logger.info("INSIDE HYSTRIX getFallBackProposalStatusFromESBService");
        logger.info("fallback thread details : " + Thread.currentThread().getName() +  "  Request Type :: " + proposalStatusRequest.getEntityType() + "Request Value :: " + proposalStatusRequest.getEntityValue());
        return  new ProposalStatusResponse();
    }
}
