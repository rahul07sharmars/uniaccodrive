package com.example.demo.controller;

import com.example.demo.entity.Purchase;
import com.example.demo.entity.PurchaseType;
import com.example.demo.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<Purchase> makePurchase(
    		@RequestParam(name = "user_id") Long userId,
            @RequestParam(name = "amount") double amount,
            @RequestParam(name = "purchase_type") PurchaseType purchaseType,
            @RequestParam(name = "duration", required = false) Integer duration,
            @RequestParam(name = "interest_rate", required = false) Double interestRate
    ) {
        return ResponseEntity.ok(
                purchaseService.makePurchase(userId, amount, purchaseType, duration, interestRate)
        );
    }
}

