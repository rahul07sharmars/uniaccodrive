package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

import com.example.demo.dto.UserDto;

import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private double creditLimit;
    private double availableCredit;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	public double getAvailableCredit() {
		return availableCredit;
	}
	public void setAvailableCredit(double availableCredit) {
		this.availableCredit = availableCredit;
	}
	public User(Long id, String name, String email, String phone, double creditLimit, double availableCredit) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.creditLimit = creditLimit;
		this.availableCredit = availableCredit;
	}
	public User(String name, String email, String phone, double creditLimit, double availableCredit) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.creditLimit = creditLimit;
		this.availableCredit = availableCredit;
	}
	public User() {
		super();
	}
	public User(UserDto userdto) {
		new User(userdto.getName(),userdto.getEmail(), userdto.getPhone(), userdto.getCreditLimit(), userdto.getAvailableCredit());
	}

    // Getters and Setters
    
}
