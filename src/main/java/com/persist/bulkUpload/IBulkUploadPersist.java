package com.persist.bulkUpload;

import com.dto.bulkUpload.BulkUploadReceiptRequest;
import com.dto.bulkUpload.BulkUploadReceiptResponse;
import com.dto.bulkUpload.ReceiptStatusRequest;
import com.dto.bulkUpload.ReceiptStatusResponse;

import java.util.List;
import java.util.Map;

public interface IBulkUploadPersist {

    BulkUploadReceiptResponse receiptBulkUploadFromESBService(BulkUploadReceiptRequest bulkUploadReceiptRequest);

    List<ReceiptStatusResponse> fetchReceiptStatus(Map<String, String> uploadId);
}
