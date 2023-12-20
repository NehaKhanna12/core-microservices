package com.service.bulkUpload;

import com.dto.apdBalance.ApdBalanceRequest;
import com.dto.apdBalance.ApdBalanceResponse;
import com.dto.bulkUpload.*;
import com.exception.BusinessException;
import com.exception.PersistentException;
import com.exception.ServiceException;
import com.google.gson.Gson;
import com.persist.apdBalance.IApdBalancePersist;
import com.persist.bulkUpload.IBulkUploadPersist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class BulkUploadServiceImpl implements IBulkUploadService {

    private static final Logger logger = LoggerFactory.getLogger(BulkUploadServiceImpl.class);

    @Autowired
    IBulkUploadPersist iBulkUploadPersist;

    @Override
    public BulkUploadReceiptResponse receiptBulkUpload(BulkUploadReceiptRequest  bulkUploadReceiptRequest) throws IOException {
        BulkUploadReceiptResponse bulkUploadReceiptResponse = null;
        try {
            bulkUploadReceiptResponse =  iBulkUploadPersist.receiptBulkUploadFromESBService(bulkUploadReceiptRequest);
        }catch(PersistentException ex){
            logger.error("Persistent Exception BulkUploadServiceImpl : -" + ex.getMessage());
            throw new ServiceException("receiptBulkUpload", ex);
        }
        return bulkUploadReceiptResponse;
    }

    @Override
    public List<ReceiptStatusResponse> fetchReceiptStatus(Map<String, String> receiptStatus) {
        List<ReceiptStatusResponse> receiptStatusResponse = null;
        try {
            receiptStatusResponse =  iBulkUploadPersist.fetchReceiptStatus(receiptStatus);
        }catch(PersistentException ex){
            logger.error("Persistent Exception BulkUploadServiceImpl : -" + ex.getMessage());
            throw new ServiceException("fetchReceiptStatus", ex);
        }
        return receiptStatusResponse;
    }
}
