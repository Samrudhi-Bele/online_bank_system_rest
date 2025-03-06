package com.E_Banking.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.E_Banking.dao.LoginDao;
import com.E_Banking.model.Admin;
import com.E_Banking.model.Users;

@Service
public class LoginService {
    
    @Autowired
    private LoginDao dao;
    public Map<String, Object> loginUser(String username, String password) {
        Map<String, Object> response = new HashMap<>();

        // Check in Customer Table
        Users customer = dao.getCustomerByUserName(username);
        if (customer != null && customer.getPassword().equals(password)) {
            response.put("success", true);
            response.put("role", "customer");
            response.put("message", "Customer login successful.");
            response.put("user", customer);
            return response;
        }

        // Check in Admin Table
        Admin admin = dao.getAdminByUserName(username);
        if (admin != null && admin.getPassword().equals(password)) {
            response.put("success", true);
            response.put("role", "admin");
            response.put("message", "Admin login successful.");
            response.put("user", admin);
            return response;
        }

        response.put("success", false);
        response.put("message", "Invalid credentials.");
        return response;
    }
}

//    public boolean login(Users user) {
////        String dbPassword = dao.getPassword(user.getUsername());
////
////        if (dbPassword != null && dbPassword.equals(user.getPassword())) {
////            return true;
////        } else {
////            return false;
////        }
////    }
//}
