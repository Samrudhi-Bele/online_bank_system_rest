package com.E_Banking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Loan {
	  @Id
	    private Long id;
	    private double amount;
	    private String purpose;
	    private Long  account_id;
	    private String status = "Pending";
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public String getPurpose() {
			return purpose;
		}
		public void setPurpose(String purpose) {
			this.purpose = purpose;
		}
		public Long  getAccount_id() {
			return account_id;
		}
		public void setAccount_id(Long account_id) {
			this.account_id = account_id;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		@Override
		public String toString() {
			return "Loan [id=" + id + ", amount=" + amount + ", purpose=" + purpose + ", account_id=" + account_id
					+ ", status=" + status + "]";
		} 
	
}
