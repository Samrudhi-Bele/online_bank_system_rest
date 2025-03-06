package com.E_Banking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.E_Banking.model.Account;
import com.E_Banking.service.AccountService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/accounts")
public class AccountController {

	
	@Autowired 
	AccountService accountService;
	
	@PostMapping("/add")
    public ResponseEntity<String> addAccount(@RequestBody Account account) {
        accountService.addAccount(account);
        return ResponseEntity.ok("Account added successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok(account);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateAccount(@RequestBody Account account) {
        accountService.updateAccount(account);
        return ResponseEntity.ok("Account updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted successfully");
    }
    @GetMapping("/balance/{id}")
    public Map<String, Object> getBalance(@PathVariable Long id) {
        return accountService.getBalance(id);
    }
}
