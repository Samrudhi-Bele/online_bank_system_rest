package com.E_Banking.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_Banking.dao.AccountDao;
import com.E_Banking.dao.TransactionDao;
import com.E_Banking.model.Account;
import com.E_Banking.model.BankTransaction;


import jakarta.transaction.Transactional;

@Service
public class TransactionService {
	@Autowired
    private AccountDao accountDao;
	@Autowired
    private TransactionDao transactionDao;

    public void addTransaction(BankTransaction transaction) {
        transactionDao.saveTransaction(transaction);
    }

    public List<BankTransaction> getAllTransactions() {
        return transactionDao.getAllTransactions();
    }

    public List<BankTransaction> getTransactionsByAccountNo(String accountNo) {
        return transactionDao.getTransactionsByAccountNo(accountNo);
    }
    @Transactional
  
    public Map<String, Object> deposit(Long id,  double amount) {
        Map<String, Object> response = new HashMap<>();

        Account account = accountDao.getAccountById(id);
        if (account == null) {
            response.put("error", "Account not found!");
            return response;
        }

        if (amount <= 0) {
            response.put("error", "Deposit amount must be positive!");
            return response;
        }

        account.setBalance(account.getBalance() + amount);
        accountDao.updateAccount(account);

        transactionDao.saveTransaction(new BankTransaction(account.getAccount_no(), "Deposit", amount, null));

        response.put("message", "Deposit successful!");
        response.put("newBalance", account.getBalance());

        return response;
    }


    // ✅ Withdraw
    @Transactional
    public Map<String, Object> withdraw(Long id, double amount) {
        Map<String, Object> response = new HashMap<>();

        Account account = accountDao.getAccountById(id);
        if (account == null) {
            response.put("error", "Account not found!");
            return response;
        }

        if (amount <= 0) {
            response.put("error", "Withdrawal amount must be positive!");
            return response;
        }

        if (account.getBalance() < amount) {
            response.put("error", "Insufficient balance!");
            return response;
        }

        account.setBalance(account.getBalance() - amount);
        accountDao.updateAccount(account);

        transactionDao.saveTransaction(new BankTransaction(account.getAccount_no(), "Withdraw", amount, null));

        response.put("message", "Withdrawal successful!");
        response.put("newBalance", account.getBalance());

        return response;
    }

    // ✅ Transfer
 
    @Transactional
   
    public Map<String, Object> transfer( Long fromAccountId,  Long toAccountId,  double amount) {
        Map<String, Object> response = new HashMap<>();

        Account fromAccount = accountDao.getAccountById(fromAccountId);
        Account toAccount = accountDao.getAccountById(toAccountId);

        if (fromAccount == null || toAccount == null) {
            response.put("error", "One or both accounts not found!");
            return response;
        }

        if (amount <= 0) {
            response.put("error", "Transfer amount must be positive!");
            return response;
        }

        if (fromAccount.getBalance() < amount) {
            response.put("error", "Insufficient balance!");
            return response;
        }

        // Deduct amount from sender
        fromAccount.setBalance(fromAccount.getBalance() - amount);
        accountDao.updateAccount(fromAccount);

        // Add amount to receiver
        toAccount.setBalance(toAccount.getBalance() + amount);
        accountDao.updateAccount(toAccount);

        // Save transaction
        transactionDao.saveTransaction(new BankTransaction(fromAccount.getAccount_no(), "Transfer", amount, toAccount.getAccount_no()));

        response.put("message", "Transfer successful!");
        response.put("fromNewBalance", fromAccount.getBalance());
        response.put("toNewBalance", toAccount.getBalance());

        return response;
    }

}
