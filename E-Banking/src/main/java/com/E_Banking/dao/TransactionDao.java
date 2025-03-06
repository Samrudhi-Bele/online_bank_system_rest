package com.E_Banking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.E_Banking.model.BankTransaction;
import org.hibernate.Transaction;

import jakarta.persistence.EntityTransaction;

@Repository
public class TransactionDao {

	@Autowired
    private SessionFactory sessionFactory;

	public void saveTransaction(BankTransaction transaction) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
        session.save(transaction);
        
        tx.commit(); // ✅ Corrected Transaction Commit
        session.close();
    }

    public List<BankTransaction> getAllTransactions() {
    	Session session = sessionFactory.openSession(); 
        return session.createQuery("FROM BankTransaction", BankTransaction.class).list();
    }

    public List<BankTransaction> getTransactionsByAccountNo(String accountNo) {
    	Session session = sessionFactory.openSession(); 
        return session.createQuery("FROM BankTransaction WHERE account_no = :accountNo", BankTransaction.class)
                      .setParameter("accountNo", accountNo)
                      .list();
    }
	
}
