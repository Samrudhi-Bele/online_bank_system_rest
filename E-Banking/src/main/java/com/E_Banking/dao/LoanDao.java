package com.E_Banking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.E_Banking.model.Loan;

@Repository
public class LoanDao {
	@Autowired
    private SessionFactory sessionFactory;

    public Loan saveLoan(Loan loan) {
        try (Session session = sessionFactory.openSession()) {
        	Transaction tx=session.beginTransaction();
    		session.save(loan);
    	
    		tx.commit();
        }
        return loan;
    }

    public Loan getLoanById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Loan.class, id);
        }
    }

    public List<Loan> getAllLoans() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Loan", Loan.class).list();
        }
    }

    public void updateLoanStatus(Long id, String status) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Loan loan = session.get(Loan.class, id);
        if (loan != null) {
            loan.setStatus(status);
            session.update(loan);
        }
        tx.commit();
        session.close();
    }
    
    public String applyForLoan(Loan loan) {
        if (loan.getId() == null) {
            return "Loan ID cannot be null!";  // ✅ Validation to ensure ID is provided
        }

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
        session.save(loan);  // ✅ Save without generating ID
        tx.commit();
        session.close();
        
        return "Loan Application Submitted!";
    }


    public void deleteLoan(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Loan loan = session.get(Loan.class, id);
            if (loan != null) {
                session.remove(loan);
            }
        }
    }
}
