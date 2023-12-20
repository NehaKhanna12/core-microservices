package com.dto.proposalStatus;


import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ProposalStatusRequest implements Serializable {

    @NotNull
    private String entityType;
    @NotNull
    private String entityValue;

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getEntityValue() {
        return entityValue;
    }

    public void setEntityValue(String entityValue) {
        this.entityValue = entityValue;
    }
}
