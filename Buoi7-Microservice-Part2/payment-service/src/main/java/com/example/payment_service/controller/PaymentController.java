package com.example.payment_service.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.payment_service.model.PaymentRequest;
import com.example.payment_service.model.PaymentResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    // Original endpoint with all fault tolerance mechanisms
    @PostMapping("/process")
    @CircuitBreaker(name = "paymentService", fallbackMethod = "fallback")
    @Retry(name = "paymentService")
    @RateLimiter(name = "paymentService")
    @TimeLimiter(name = "paymentService")
    public CompletableFuture<PaymentResponse> processPayment(@RequestBody PaymentRequest request) {
        if (request.getAmount() <= 0) {
            throw new RuntimeException("Invalid payment amount");
        }
        return CompletableFuture.supplyAsync(() -> {
            PaymentResponse response = new PaymentResponse();
            response.setTransactionId("TXN_" + System.currentTimeMillis());
            response.setStatus("SUCCESS");
            return response;
        });
    }

    // Test Circuit Breaker only
    @PostMapping("/test-circuit-breaker")
    @CircuitBreaker(name = "circuitBreakerTest", fallbackMethod = "fallback")
    public CompletableFuture<PaymentResponse> testCircuitBreaker(@RequestBody PaymentRequest request) {
        // Simulate intermittent failure
        if (Math.random() > 0.5) {
            throw new RuntimeException("Simulated failure for Circuit Breaker");
        }
        return CompletableFuture.supplyAsync(() -> {
            PaymentResponse response = new PaymentResponse();
            response.setTransactionId("TXN_CB_" + System.currentTimeMillis());
            response.setStatus("SUCCESS");
            return response;
        });
    }

    // Test Retry only
    @PostMapping("/test-retry")
    @Retry(name = "retryTest")
    public CompletableFuture<PaymentResponse> testRetry(@RequestBody PaymentRequest request) {
        // Simulate intermittent failure
        if (Math.random() > 0.7) {
            throw new RuntimeException("Simulated failure for Retry");
        }
        return CompletableFuture.supplyAsync(() -> {
            PaymentResponse response = new PaymentResponse();
            response.setTransactionId("TXN_RETRY_" + System.currentTimeMillis());
            response.setStatus("SUCCESS");
            return response;
        });
    }

    // Test Rate Limiter only
    @PostMapping("/test-rate-limiter")
    @RateLimiter(name = "rateLimiterTest")
    public CompletableFuture<PaymentResponse> testRateLimiter(@RequestBody PaymentRequest request) {
        return CompletableFuture.supplyAsync(() -> {
            PaymentResponse response = new PaymentResponse();
            response.setTransactionId("TXN_RL_" + System.currentTimeMillis());
            response.setStatus("SUCCESS");
            return response;
        });
    }

    // Test Time Limiter only
    @PostMapping("/test-time-limiter")
    @TimeLimiter(name = "timeLimiterTest")
    public CompletableFuture<PaymentResponse> testTimeLimiter(@RequestBody PaymentRequest request) {
        // Simulate long-running operation
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000); // Delay longer than Time Limiter's timeout (2s)
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            PaymentResponse response = new PaymentResponse();
            response.setTransactionId("TXN_TL_" + System.currentTimeMillis());
            response.setStatus("SUCCESS");
            return response;
        });
    }

    public CompletableFuture<PaymentResponse> fallback(PaymentRequest request, Throwable t) {
        PaymentResponse response = new PaymentResponse();
        response.setStatus("FAILED");
        response.setTransactionId("N/A");
        return CompletableFuture.completedFuture(response);
    }
}