package com.example.demo.entity;
import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;
@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Date paymentDate;
    private double amount;
	@ManyToOne
    @JoinColumn(name = "repayment_plan_id")
    private RepaymentPlan repaymentPlan;

    // Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public RepaymentPlan getRepaymentPlan() {
		return repaymentPlan;
	}

	public void setRepaymentPlan(RepaymentPlan repaymentPlan) {
		this.repaymentPlan = repaymentPlan;
	}

	public Payment(Long id, User user, Date paymentDate, double amount, RepaymentPlan repaymentPlan) {
		super();
		this.id = id;
		this.user = user;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.repaymentPlan = repaymentPlan;
	}

	public Payment() {
		super();
	}
	
	
}


