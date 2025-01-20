package com.example.demo.service;
import com.example.demo.entity.*;
import com.example.demo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RepaymentPlanRepository repaymentPlanRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private EMIScheduleRepository emiScheduleRepository;

    // Record a payment
    public Payment recordPayment(Long userId, double amount, Long repaymentPlanId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Update available credit
        user.setAvailableCredit(user.getAvailableCredit() + amount);
        userRepository.save(user);

        // Record payment
        Payment payment = new Payment();
        payment.setUser(user);
        payment.setAmount(amount);
        payment.setPaymentDate(new Date());

        if (repaymentPlanId != null) {
            RepaymentPlan repaymentPlan = repaymentPlanRepository.findById(repaymentPlanId)
                    .orElseThrow(() -> new RuntimeException("Repayment plan not found"));
            payment.setRepaymentPlan(repaymentPlan);

            // Update EMI schedules
            List<EMISchedule> emiSchedules = emiScheduleRepository
                    .findByRepaymentPlanAndIsPaidFalseOrderByDueDateAsc(repaymentPlan);

            for (EMISchedule emi : emiSchedules) {
                if (amount <= 0) break;

                if (amount >= emi.getAmount()) {
                    emi.setPaid(true);
                    amount -= emi.getAmount();
                } else {
                    emi.setAmount(emi.getAmount() - amount);
                    amount = 0;
                }
                emiScheduleRepository.save(emi);
            }
        }

        return paymentRepository.save(payment);
    }
}
