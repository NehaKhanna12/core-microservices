package com.dto.bulkUpload;

import java.io.Serializable;

public class ReceiptStatusRequest implements Serializable {

    private String uploadId;

    public String getUploadId() {
        return uploadId;
    }

    public void setUploadId(String uploadId) {
        this.uploadId = uploadId;
    }

    @Override
    public String toString() {
        return "ReceiptStatusRequest{" +
                "uploadId='" + uploadId + '\'' +
                '}';
    }
}
