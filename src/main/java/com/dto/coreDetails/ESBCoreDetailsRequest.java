package com.dto.coreDetails;


import java.io.Serializable;


public class ESBCoreDetailsRequest implements Serializable {
    private Arg0 arg0;

    @Override
    public String toString() {
        return "ESBCoreDetailsRequest{" +
                "arg0=" + arg0 +
                '}';
    }

    public Arg0 getArg0() {
        return arg0;
    }

    public void setArg0(Arg0 arg0) {
        this.arg0 = arg0;
    }
}
