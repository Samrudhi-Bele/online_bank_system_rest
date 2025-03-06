package com.E_Banking.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.E_Banking.dao.AccountDao;
import com.E_Banking.model.Account;

@Service
public class AccountService {

	
	@Autowired 
	AccountDao accountDao;
	 public void addAccount(Account account) {
		 accountDao.saveAccount(account);
	    }

	    public Account getAccountById(Long id) {
	        return accountDao.getAccountById(id);
	    }

	    public List<Account> getAllAccounts() {
	        return accountDao.getAllAccounts();
	    }

	    public void updateAccount(Account account) {
	    	accountDao.updateAccount(account);
	    }

	    public void deleteAccount(Long id) {
	    	accountDao.deleteAccount(id);
	    }
	    public Map<String, Object> getBalance( Long id) {
	        Map<String, Object> response = new HashMap<>();
	        Account account = accountDao.getAccountById(id);

	        if (account == null) {
	            response.put("error", "Account not found!");
	            return response;
	        }

	        response.put("balance", account.getBalance());
	        return response;
	    }
}
