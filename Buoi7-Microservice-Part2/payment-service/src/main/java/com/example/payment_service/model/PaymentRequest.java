package com.example.payment_service.model;

import lombok.Data;

@Data
public class PaymentRequest {
    private double amount;
    private String orderId;
}