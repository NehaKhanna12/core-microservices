package com.dto.bulkUpload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BulkUploadReceiptRequest {

    private List<ReceiptDTO> payload;

    public List<ReceiptDTO> getPayload() {
        return payload;
    }

    public void setPayload(List<ReceiptDTO> payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "BulkUploadReceiptRequest{" +
                "payload=" + payload +
                '}';
    }
}
