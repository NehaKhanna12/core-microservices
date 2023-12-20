package com.dto.apdBalance;

public class ApdBalanceResponse {
    @Override
    public String toString() {
        return "ApdBalanceResponse{" +
                "apdBalance=" + apdBalance +
                '}';
    }

    public double getApdBalance() {
        return apdBalance;
    }

    public void setApdBalance(double apdBalance) {
        this.apdBalance = apdBalance;
    }

    double apdBalance;
}
