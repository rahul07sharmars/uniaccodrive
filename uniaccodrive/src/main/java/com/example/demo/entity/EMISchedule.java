package com.example.demo.entity;
import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Data
public class EMISchedule {
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public RepaymentPlan getRepaymentPlan() {
		return repaymentPlan;
	}
	public void setRepaymentPlan(RepaymentPlan repaymentPlan) {
		this.repaymentPlan = repaymentPlan;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "repayment_plan_id", nullable = false)
    private RepaymentPlan repaymentPlan;

    private Date dueDate;
    private double amount;
    private boolean isPaid;
	public EMISchedule(Long id, RepaymentPlan repaymentPlan, Date dueDate, double amount, boolean isPaid) {
		super();
		this.id = id;
		this.repaymentPlan = repaymentPlan;
		this.dueDate = dueDate;
		this.amount = amount;
		this.isPaid = isPaid;
	}
	public EMISchedule() {
		super();
	}

    
    // Getters and Setters
}

