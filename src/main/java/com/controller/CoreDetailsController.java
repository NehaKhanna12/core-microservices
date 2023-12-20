package com.controller;

import com.exception.EntityNotFoundException;
import com.exception.ServiceException;
import com.dto.coreDetails.CoreDetailsRequest;
import com.dto.coreDetails.CoreDetailsResponse;
import com.exception.APIRequestException;
import com.service.coreDetails.ICoreDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(path = "/entity")
@Controller
public class CoreDetailsController {

    private static final Logger logger = LoggerFactory.getLogger(CoreDetailsController.class);

    @Autowired
    ICoreDetailsService iCoreDetailsService;

    @PostMapping(path="/getCoreDetails", produces = "application/json")
    public ResponseEntity<Object> getEntityDetails(@Valid @RequestBody CoreDetailsRequest coreDetailsRequest)
    {
        CoreDetailsResponse coreDetailsResponse = new CoreDetailsResponse();
        if (StringUtils.isEmpty(coreDetailsRequest.getEntityType()) || StringUtils.isEmpty
                (coreDetailsRequest.getEntityValue())) {
            coreDetailsResponse.setMessage("Entity type and entity value can not be null");
            return new ResponseEntity<Object>(coreDetailsResponse, HttpStatus.BAD_REQUEST);
        }
        try {
            coreDetailsResponse = iCoreDetailsService.getCoreDetails(coreDetailsRequest);
        } catch (ServiceException ex){
            logger.error(ex.getMessage());
            throw new APIRequestException("ESB Service Exception!", ex);
        }catch (EntityNotFoundException ex){
            logger.error(ex.getMessage());
            throw new EntityNotFoundException("EntityNotFoundException!", ex);
        }catch (Exception ex){
            logger.error(ex.toString());
            throw new APIRequestException("UnExpected Exception!", ex);
        }
        return new ResponseEntity<Object>(coreDetailsResponse, HttpStatus.OK);
    }
}
