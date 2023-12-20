package com.dto.apdBalance;



public class ApdBalanceRequest {
    String accountId;

    @Override
    public String toString() {
        return "ApdBalanceRequest{" +
                "accountId='" + accountId + '\'' +
                '}';
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
