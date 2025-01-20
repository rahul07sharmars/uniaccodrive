package com.example.demo.dto;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

import com.example.demo.entity.User;

import lombok.Data;

@Data
public class UserDto {
    private String name;
    private String email;
    private String phone;
    private double creditLimit;
    private double availableCredit;
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
	public UserDto(String name, String email, String phone, double creditLimit, double availableCredit) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.creditLimit = creditLimit;
		this.availableCredit = availableCredit;
	}
	public UserDto() {
		super();
	}
//	User createUser(UserDto userdto) {
//		User newuser=new User(userdto);
//	}
//	public UserDto(User user) {
//		super();
//        temp.setAvailableCredit(user.getAvailableCredit());
//        temp.setCreditLimit(user.getCreditLimit());
//        temp.setEmail(user.getEmail());
//        temp.setName(user.getName());
//        temp.setPhone(user.getPhone());
//		
//	}
    // Getters and Setters
    
}
