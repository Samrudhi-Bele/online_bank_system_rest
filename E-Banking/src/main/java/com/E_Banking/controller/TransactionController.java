package com.E_Banking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.E_Banking.model.Account;
import com.E_Banking.model.BankTransaction;
import com.E_Banking.service.AccountService;
import com.E_Banking.service.TransactionService;

import jakarta.transaction.Transactional;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/transaction")
public class TransactionController {

	    @Autowired
	    private TransactionService transactionService;
	  
	    @PostMapping("/add")
	    public String addTransaction(@RequestBody BankTransaction transaction) {
	        transactionService.addTransaction(transaction);
	        return "Transaction added successfully!";
	    }

	    // ✅ Get all transactions
	    @GetMapping("/all")
	    public List<BankTransaction> getAllTransactions() {
	        return transactionService.getAllTransactions();
	    }

	    // ✅ Get transactions by account number
	    @GetMapping("/account/{accountNo}")
	    public List<BankTransaction> getTransactionsByAccountNo(@PathVariable String accountNo) {
	        return transactionService.getTransactionsByAccountNo(accountNo);
	    }
	    // ✅ Deposit Money
	    @PostMapping("/deposit/{id}/{amount}")
	    public Map<String, Object> deposit(@PathVariable Long id, @PathVariable double amount) {
	        return transactionService.deposit(id, amount);
	    }

	    // ✅ Withdraw Money
	    @PostMapping("/withdraw/{id}/{amount}")
	    public Map<String, Object> withdraw(@PathVariable Long id, @PathVariable double amount) {
	        return transactionService.withdraw(id, amount);
	    }

	    // ✅ Transfer Money
	    @PostMapping("/transfer/{fromAccountId}/{toAccountId}/{amount}")
	    public Map<String, Object> transfer(@PathVariable Long fromAccountId, @PathVariable Long toAccountId, @PathVariable double amount) {
	        return transactionService.transfer(fromAccountId, toAccountId, amount);
	    }
}
