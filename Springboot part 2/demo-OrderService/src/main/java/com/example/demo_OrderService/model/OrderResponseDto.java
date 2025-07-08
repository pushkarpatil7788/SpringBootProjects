package com.example.demo_OrderService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {

    private long orderId;
    private long productId;
    private int quantity;
    private double totalPrice;

    private String productName;
    private double productPrice;

}