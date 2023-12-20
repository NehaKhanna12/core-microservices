package com.dto.proposalStatus;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProposalStatusResponse  implements Serializable {

    @SerializedName("return")
    private Return returnProposalDetails;

    @SerializedName("error")
    private List<Err> errors;

    private String message;
    private String statusCode;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Return getReturnProposalDetails() {
        return returnProposalDetails;
    }

    public void setReturnProposalDetails(Return returnProposalDetails) {
        this.returnProposalDetails = returnProposalDetails;
    }

    public List<Err> getErrors() {
        return errors;
    }

    public void setErrors(List<Err> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "ProposalStatusResponse{" +
                "returnProposalDetails=" + returnProposalDetails +
                ", errors=" + errors +
                ", message='" + message + '\'' +
                ", statusCode='" + statusCode + '\'' +
                '}';
    }
}
