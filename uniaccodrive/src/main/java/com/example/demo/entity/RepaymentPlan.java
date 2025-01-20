package com.example.demo.entity;
import lombok.Data;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Data
public class RepaymentPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private double totalAmount;
    private double monthlyInstallment;
    private int durationInMonths;
    private double interestRate;
    private double penaltyRate;
    private Date startDate;

    @OneToMany(mappedBy = "repaymentPlan", cascade = CascadeType.ALL)
    private List<EMISchedule> emiSchedules;

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

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getMonthlyInstallment() {
		return monthlyInstallment;
	}

	public void setMonthlyInstallment(double monthlyInstallment) {
		this.monthlyInstallment = monthlyInstallment;
	}

	public int getDurationInMonths() {
		return durationInMonths;
	}

	public void setDurationInMonths(int durationInMonths) {
		this.durationInMonths = durationInMonths;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getPenaltyRate() {
		return penaltyRate;
	}

	public void setPenaltyRate(double penaltyRate) {
		this.penaltyRate = penaltyRate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public List<EMISchedule> getEmiSchedules() {
		return emiSchedules;
	}

	public void setEmiSchedules(List<EMISchedule> emiSchedules) {
		this.emiSchedules = emiSchedules;
	}

	public RepaymentPlan(Long id, User user, double totalAmount, double monthlyInstallment, int durationInMonths,
			double interestRate, double penaltyRate, Date startDate, List<EMISchedule> emiSchedules) {
		super();
		this.id = id;
		this.user = user;
		this.totalAmount = totalAmount;
		this.monthlyInstallment = monthlyInstallment;
		this.durationInMonths = durationInMonths;
		this.interestRate = interestRate;
		this.penaltyRate = penaltyRate;
		this.startDate = startDate;
		this.emiSchedules = emiSchedules;
	}

	public RepaymentPlan() {
		super();
	}

    // Getters and Setters
    
}

