package com.controller;

import com.exception.ServiceException;
import com.dto.apdBalance.ApdBalanceRequest;
import com.dto.apdBalance.ApdBalanceResponse;
import com.exception.APIRequestException;
import com.service.apdBalance.IApdBalanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping(path = "/entity")
@Controller
public class ApdBalanceController {

    private static final Logger logger = LoggerFactory.getLogger(ApdBalanceController.class);

    @Autowired
    IApdBalanceService iApdBalanceService;

    @PostMapping(path="/getApdBalance", produces = "application/json")
    public ResponseEntity<ApdBalanceResponse> getApdBalance(@Valid @RequestBody ApdBalanceRequest apdBalanceRequest)
    {
        ApdBalanceResponse apdBalanceResponse = null;
        try {
            apdBalanceResponse = iApdBalanceService.getApdBalance(apdBalanceRequest);
        } catch (ServiceException ex){
            logger.error(ex.getMessage());
            throw new APIRequestException("ESB Service Exception!", ex);
        }catch (Exception ex){
            logger.error(ex.toString());
            throw new APIRequestException("UnHandled Exception!", ex);
        }
        return new ResponseEntity<ApdBalanceResponse>(apdBalanceResponse, HttpStatus.OK);
    }
}
