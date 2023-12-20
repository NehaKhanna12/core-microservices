package com.controller;

import com.dto.apdBalance.ApdBalanceRequest;
import com.dto.apdBalance.ApdBalanceResponse;
import com.dto.bulkUpload.*;
import com.exception.APIRequestException;
import com.exception.ServiceException;
import com.google.gson.Gson;
import com.service.apdBalance.IApdBalanceService;
import com.service.bulkUpload.IBulkUploadService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(path = "/entity")
@Controller
public class BulkUploadReceiptController {

    private static final Logger logger = LoggerFactory.getLogger(BulkUploadReceiptController.class);

    @Autowired
    IBulkUploadService iBulkUploadService;

    @PostMapping(path="/bulkUploadReceipt", produces = "application/json")
    public ResponseEntity<BulkUploadReceiptResponse> bulkUploadReceipt(@RequestBody BulkUploadReceiptRequest bulkUploadReceiptRequest)
    {
        BulkUploadReceiptResponse bulkUploadReceiptResponse = null;
        try {
            bulkUploadReceiptResponse = iBulkUploadService.receiptBulkUpload(bulkUploadReceiptRequest);
        } catch (ServiceException ex){
            logger.error(ex.getMessage());
            throw new APIRequestException("ESB Service Exception!", ex);
        }catch (Exception ex){
            logger.error(ex.toString());
            throw new APIRequestException("UnHandled Exception!", ex);
        }
        return new ResponseEntity<BulkUploadReceiptResponse>(bulkUploadReceiptResponse, HttpStatus.OK);
    }

    @PostMapping(path="/receiptStatus", produces = "application/json")
    public ResponseEntity<List<ReceiptStatusResponse>> receiptStatus(@RequestBody Map<String, String> uploadId)
    {
        List<ReceiptStatusResponse> receiptStatusResponse = null;
        try {
            receiptStatusResponse = iBulkUploadService.fetchReceiptStatus(uploadId);
        } catch (ServiceException ex){
            logger.error(ex.getMessage());
            throw new APIRequestException("ESB Service Exception!", ex);
        }catch (Exception ex){
            logger.error(ex.toString());
            throw new APIRequestException("UnHandled Exception!", ex);
        }
        return new ResponseEntity<List<ReceiptStatusResponse>>(receiptStatusResponse, HttpStatus.OK);
    }
}
