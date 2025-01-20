package com.example.demo.entity;
import lombok.Data;

import java.util.Date;

import jakarta.persistence.*;


@Entity
@Data
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private double amount;
    private Date purchaseDate;

    @Enumerated(EnumType.STRING)
    private PurchaseType purchaseType;

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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public PurchaseType getPurchaseType() {
		return purchaseType;
	}

	public void setPurchaseType(PurchaseType purchaseType) {
		this.purchaseType = purchaseType;
	}

	public Purchase(Long id, User user, double amount, Date purchaseDate, PurchaseType purchaseType) {
		super();
		this.id = id;
		this.user = user;
		this.amount = amount;
		this.purchaseDate = purchaseDate;
		this.purchaseType = purchaseType;
	}

	public Purchase() {
		super();
	}

    // Getters and Setters
    
}
