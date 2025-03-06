package com.E_Banking.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "banktransaction")
public class BankTransaction {
@Id
private long id;
private String account_no;
private String transaction_type; // Removed ENUM, using String instead
private double amount;
private LocalDateTime timestamp ;
private String to_account_no;

public BankTransaction() {
}
public BankTransaction(String account_no, String transaction_type, double amount, String to_account_no) {
    this.account_no = account_no;
    this.transaction_type = transaction_type;
    this.amount = amount;
    this.to_account_no = to_account_no;
    this.timestamp = LocalDateTime.now(); // ✅ Set timestamp automatically
}

public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getAccount_no() {
	return account_no;
}
public void setAccount_no(String account_no) {
	this.account_no = account_no;
}
public String getTransaction_type() {
	return transaction_type;
}
public void setTransaction_type(String transaction_type) {
	this.transaction_type = transaction_type;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public LocalDateTime getTimestamp() {
	return timestamp;
}
public void setTimestamp(LocalDateTime  timestamp) {
	this.timestamp = timestamp;
}
public String getTo_account_no() {
	return to_account_no;
}
public void setTo_account_no(String to_account_no) {
	this.to_account_no = to_account_no;
}
@Override
public String toString() {
	return "Transaction [id=" + id + ", account_no=" + account_no + ", transaction_type=" + transaction_type
			+ ", amount=" + amount + ", timestamp=" + timestamp + ", to_account_no=" + to_account_no + "]";
}

}
