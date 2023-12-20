package com.dto.coreDetails;


import java.lang.Error;
import java.util.List;


public class PolicyElixirException {
    private List<Error> error;

    @Override
    public String toString() {
        return "PolicyElixirException{" +
                "error=" + error +
                '}';
    }

    public List<Error> getError() {
        return error;
    }

    public void setError(List<Error> error) {
        this.error = error;
    }
}
