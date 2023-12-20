package com.service.bulkUpload;

import com.dto.bulkUpload.BulkUploadReceiptRequest;
import com.dto.bulkUpload.BulkUploadReceiptResponse;
import com.dto.bulkUpload.ReceiptStatusRequest;
import com.dto.bulkUpload.ReceiptStatusResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IBulkUploadService {

    BulkUploadReceiptResponse receiptBulkUpload(BulkUploadReceiptRequest bulkUploadReceiptRequest) throws IOException;

    List<ReceiptStatusResponse> fetchReceiptStatus(Map<String, String> receiptStatus);
}
