package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PurchaseService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private RepaymentPlanRepository repaymentPlanRepository;

    public Purchase makePurchase(Long userId, double amount, PurchaseType purchaseType, Integer duration, Double interestRate) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getAvailableCredit() < amount) {
            throw new RuntimeException("Insufficient credit available");
        }

        user.setAvailableCredit(user.getAvailableCredit() - amount);
        userRepository.save(user);

        Purchase purchase = new Purchase();
        purchase.setUser(user);
        purchase.setAmount(amount);
        purchase.setPurchaseDate(new Date());
        purchase.setPurchaseType(purchaseType);

        purchaseRepository.save(purchase);

        if (purchaseType == PurchaseType.EMI && duration != null && interestRate != null) {
            createEMIPlan(user, amount, duration, interestRate);
        }

        return purchase;
    }

    private void createEMIPlan(User user, double amount, int duration, double interestRate) {
        double monthlyInstallment = calculateEMI(amount, duration, interestRate);

        RepaymentPlan plan = new RepaymentPlan();
        plan.setUser(user);
        plan.setTotalAmount(amount + (amount * (interestRate / 100)));
        plan.setMonthlyInstallment(monthlyInstallment);
        plan.setDurationInMonths(duration);
        plan.setInterestRate(interestRate);
        plan.setPenaltyRate(2.0); // Default penalty rate
        plan.setStartDate(new Date());

        repaymentPlanRepository.save(plan);
    }

    private double calculateEMI(double principal, int months, double rate) {
        double monthlyRate = rate / (12 * 100);
        return (principal * monthlyRate * Math.pow(1 + monthlyRate, months)) /
                (Math.pow(1 + monthlyRate, months) - 1);
    }
}

