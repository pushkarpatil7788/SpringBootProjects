package com.sanjay.beans;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    private String paymentId;
    private boolean paymentSuccess;
    private int paymentAmount;

    PaymentService(){
        setPaymentId("ewf46-vdcs56");
        setPaymentAmount(1200);
        setPaymentSuccess(true);
        System.out.println("---- Payment Successful -------");
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public boolean isPaymentSuccess() {
        return paymentSuccess;
    }

    public void setPaymentSuccess(boolean paymentSuccess) {
        this.paymentSuccess = paymentSuccess;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
