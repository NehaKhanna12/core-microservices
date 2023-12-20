package com.dto.bulkUpload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.Instant;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BulkUploadReceiptResponse {

	private long uploadId;
	private String status;
	private String errorRemarks;


	public long getUploadId() {
		return uploadId;
	}

	public void setUploadId(long uploadId) {
		this.uploadId = uploadId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorRemarks() {
		return errorRemarks;
	}

	public void setErrorRemarks(String errorRemarks) {
		this.errorRemarks = errorRemarks;
	}

	@Override
	public String toString() {
		return "BulkUploadReceiptResponse{" +
				"uploadId=" + uploadId +
				", status='" + status + '\'' +
				", errorRemarks='" + errorRemarks + '\'' +
				'}';
	}
}
