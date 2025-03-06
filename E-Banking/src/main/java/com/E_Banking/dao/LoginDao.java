package com.E_Banking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.E_Banking.model.Admin;
import com.E_Banking.model.Users;

@Repository
public class LoginDao {
    
    @Autowired
    private SessionFactory sessionFactory;
    public Users getCustomerByUserName(String username) {
        try (Session session = sessionFactory.openSession()) {
            List<Users> customers = session.createQuery("FROM Users WHERE username = :username", Users.class)
                                              .setParameter("username", username)
                                              .list();
            return customers.isEmpty() ? null : customers.get(0);
        }
    }

    // Check in Admin Table
    public Admin getAdminByUserName(String username) {
        try (Session session = sessionFactory.openSession()) {
            List<Admin> admins = session.createQuery("FROM Admin WHERE username = :username", Admin.class)
                                        .setParameter("username", username)
                                        .list();
            return admins.isEmpty() ? null : admins.get(0);
        }
    }

//    public String getPassword(String username) {
//        try (Session session = sessionFactory.openSession()) {
//            Users userFromDB = session.get(Users.class, username);
//            
//            if (userFromDB != null) {
//                return userFromDB.getPassword(); // Return password if user exists
//            }
//            return null; // Return null if user is not found
//        }
//    }
}
