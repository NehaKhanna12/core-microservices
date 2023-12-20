package com.dto.coreDetails;

import com.dto.proposalStatus.Err;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CoreDetailsResponse implements Serializable {
    @SerializedName("return")
    private Return returnPolicyDetails;
    @SerializedName("return")
    public Return getReturnPolicyDetails() {
        return returnPolicyDetails;
    }
    private String message;

    @SerializedName("error")
    private List<Err> error;

    public List<Err> getError() {
        return error;
    }

    @Override
    public String toString() {
        return "CoreDetailsResponse{" +
                "returnPolicyDetails=" + returnPolicyDetails +
                ", message='" + message + '\'' +
                ", error=" + error +
                '}';
    }

    public void setError(List<Err> error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

   @SerializedName("return")
    public void setReturnPolicyDetails(Return returnPolicyDetails) {
        this.returnPolicyDetails = returnPolicyDetails;
    }
}
