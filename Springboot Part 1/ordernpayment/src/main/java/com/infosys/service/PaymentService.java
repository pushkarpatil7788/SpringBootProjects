package com.infosys.service;

import org.springframework.stereotype.Component;


@Component
public class PaymentService {

    public void processPayment() {
        System.out.println("Payment processed successfully!");
    }
}
