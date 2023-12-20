package com.dto.coreDetails;



import java.io.Serializable;


public class PaymentDetails implements Serializable {
    private String paymentMode;

    @Override
    public String toString() {
        return "PaymentDetails{" +
                "paymentMode='" + paymentMode + '\'' +
                ", paymentFrequeny='" + paymentFrequeny + '\'' +
                '}';
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPaymentFrequeny() {
        return paymentFrequeny;
    }

    public void setPaymentFrequeny(String paymentFrequeny) {
        this.paymentFrequeny = paymentFrequeny;
    }

    private String paymentFrequeny;
}
