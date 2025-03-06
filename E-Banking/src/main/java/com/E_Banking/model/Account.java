package com.E_Banking.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {
	@Id
    private long id;
    private String account_holder_name;
    private String account_no;
    private double balance;
    private String phone_no;
    private int pin;
    private Date dob;
    private String adhar_card_no;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccount_holder_name() {
		return account_holder_name;
	}
	public void setAccount_holder_name(String account_holder_name) {
		this.account_holder_name = account_holder_name;
	}
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAdhar_card_no() {
		return adhar_card_no;
	}
	public void setAdhar_card_no(String adhar_card_no) {
		this.adhar_card_no = adhar_card_no;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", account_holder_name=" + account_holder_name + ", account_no=" + account_no
				+ ", balance=" + balance + ", phone_no=" + phone_no + ", pin=" + pin + ", dob=" + dob
				+ ", adhar_card_no=" + adhar_card_no + "]";
	}
   
	
}
