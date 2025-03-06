package com.E_Banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_Banking.dao.LoanDao;
import com.E_Banking.model.Loan;

@Service
public class LoanService {
	 @Autowired
	    private LoanDao loanRepository;

	    public Loan applyForLoan(Loan loan) {
	        return loanRepository.saveLoan(loan);
	    }

	    public List<Loan> getAllLoans() {
	        return loanRepository.getAllLoans();
	    }

	    public Loan getLoanById(Long id) {
	        return loanRepository.getLoanById(id);
	    }

	    public boolean updateStatus(Long id, String status) {
	        Loan loan = loanRepository.getLoanById(id);
	        if (loan != null) {
	        	loanRepository.updateLoanStatus(id, status);
	            return true;
	        }
	        return false;
	    }

	    public void deleteLoan(Long id) {
	        loanRepository.deleteLoan(id);
	    }
	    
}
