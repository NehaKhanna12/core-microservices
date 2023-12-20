package com.dto.coreDetails;


import javax.validation.constraints.NotNull;
import java.io.Serializable;


public class CoreDetailsRequest implements Serializable {
    @Override
    public String toString() {
        return "CoreDetailsRequest{" +
                "entityType='" + entityType + '\'' +
                ", entityValue='" + entityValue + '\'' +
                '}';
    }

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

    @NotNull
    private String entityType;
    @NotNull
    private String entityValue;
}
