package com.controller;

import com.exception.ServiceException;
import com.dto.proposalStatus.ProposalStatusRequest;
import com.dto.proposalStatus.ProposalStatusResponse;
import com.exception.APIRequestException;
import com.service.proposalStatus.IProposalStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping(path = "/entity")
@Controller
public class ProposalStatusController {

    private static final Logger logger = LoggerFactory.getLogger(ProposalStatusController.class);

    @Autowired
    IProposalStatusService iProposalStatusService;

    @PostMapping(path="/getProposalStatus", produces = "application/json")
    public ResponseEntity<Object> getEntityDetails(@Valid @RequestBody ProposalStatusRequest proposalStatusRequest)
    {
        ProposalStatusResponse proposalStatusResponse = new ProposalStatusResponse();
        try {

            if (StringUtils.isEmpty(proposalStatusRequest.getEntityType()) || StringUtils.isEmpty
                    (proposalStatusRequest.getEntityValue())) {
                proposalStatusResponse.setMessage("Entity type and entity value can not be null");
                return new ResponseEntity<Object>(proposalStatusResponse, HttpStatus.BAD_REQUEST);
            }
            if ("application".equalsIgnoreCase(proposalStatusRequest.getEntityType()) ||"proposal".equalsIgnoreCase(proposalStatusRequest.getEntityType()) || "policy".equalsIgnoreCase(proposalStatusRequest.getEntityType())) {
                proposalStatusResponse = iProposalStatusService.getProposalStatus(proposalStatusRequest);
                if("404".equalsIgnoreCase(proposalStatusResponse.getStatusCode())){
                    proposalStatusResponse.setMessage("Please provide correct proposal/application/policy number");
                    return new ResponseEntity<Object>(proposalStatusResponse, HttpStatus.NOT_FOUND);
                }
            } else {
                proposalStatusResponse.setMessage("Please check entity type.It must be application/proposal/policy");
                return new ResponseEntity<Object>(proposalStatusResponse, HttpStatus.BAD_REQUEST);
            }
        } catch (ServiceException ex){
            logger.error(ex.getMessage());
            throw new APIRequestException("ESB Service Exception!", ex);
        }catch (Exception ex){
            logger.error(ex.toString());
            throw new APIRequestException("UnHandled Exception!", ex);
        }
        return new ResponseEntity<Object>(proposalStatusResponse, HttpStatus.OK);
    }
}
