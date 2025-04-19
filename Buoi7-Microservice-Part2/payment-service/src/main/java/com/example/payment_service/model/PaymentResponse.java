package com.example.payment_service.model;

import lombok.Data;

@Data
public class PaymentResponse {
    private String transactionId;
    private String status;
}