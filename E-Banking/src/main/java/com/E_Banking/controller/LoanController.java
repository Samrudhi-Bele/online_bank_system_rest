package com.E_Banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.E_Banking.model.Loan;
import com.E_Banking.service.LoanService;

@RestController
@RequestMapping("/loans")
@CrossOrigin(origins ="http://localhost:4200") // Allow frontend access
public class LoanController {
	 @Autowired
	    private LoanService loanService;

	    // Apply for a loan
	    @PostMapping("/apply")
	    public Loan applyForLoan(@RequestBody Loan loan) {
	        return loanService.applyForLoan(loan);
	    }

	    // Get all loans
	    @GetMapping
	    public List<Loan> getAllLoans() {
	        return loanService.getAllLoans();
	    }

	    // Get loan by ID
	    @GetMapping("/{id}")
	    public Loan getLoanById(@PathVariable Long id) {
	        return loanService.getLoanById(id);
	    }

	    // Update loan details
	    @PutMapping("/{id}/{status}")
	    public String updateLoanStatus(@PathVariable Long id, @PathVariable String status) {
	        boolean updated = loanService.updateStatus(id, status);
	        if (updated) {
	            return "Loan status updated to " + status;
	        } else {
	            return "Loan not found";
	        }
	    }
	    // Delete loan by ID
	    @DeleteMapping("/delete/{id}")
	    public String deleteLoan(@PathVariable Long id) {
	        loanService.deleteLoan(id);
	        return "Loan with ID " + id + " deleted successfully!";
	    }
}
