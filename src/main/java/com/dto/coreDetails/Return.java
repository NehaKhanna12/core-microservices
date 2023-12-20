package com.dto.coreDetails;


import java.io.Serializable;


public class Return  implements Serializable {
    private Policy policy;

    @Override
    public String toString() {
        return "Return{" +
                "policy=" + policy +
                '}';
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }
}
