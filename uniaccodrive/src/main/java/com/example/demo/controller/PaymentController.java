package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    // Record a payment
    @PostMapping
    public ResponseEntity<Payment> recordPayment(@RequestBody PaymentRequestDto paymentRequest) {
        Payment payment = paymentService.recordPayment(
                paymentRequest.getUserId(),
                paymentRequest.getAmount(),
                paymentRequest.getRepaymentPlanId()
        );
        return ResponseEntity.ok(payment);
    }
        

}
