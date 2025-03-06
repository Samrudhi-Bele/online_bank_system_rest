package com.E_Banking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.E_Banking.model.Account;

import jakarta.transaction.Transactional;

@Repository
public class AccountDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public void saveAccount(Account account) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(account);
        tx.commit();
        session.close();
    }

    public Account getAccountById(Long id) {
        Session session = sessionFactory.openSession();
        Account account = session.get(Account.class, id);
        session.close();
        return account;
    }

    public List<Account> getAllAccounts() {
        Session session = sessionFactory.openSession();
        List<Account> accounts = session.createQuery("from Account", Account.class).list();
        session.close();
        return accounts;
    }
    
    public void updateAccount(Account account) {
    	Session session = sessionFactory.openSession(); // ✅ Opens a new session
        Transaction tx = session.beginTransaction();
        
        session.update(account); // ✅ Update the existing account
        tx.commit();
        
        session.close();
    }

    public void deleteAccount(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Account account = session.get(Account.class, id);
        if (account != null) {
            session.delete(account);
        }
        tx.commit();
        session.close();
    }
	}