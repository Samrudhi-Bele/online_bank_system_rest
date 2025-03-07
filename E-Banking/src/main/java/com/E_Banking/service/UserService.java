package com.E_Banking.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.E_Banking.dao.AdminDao;
import com.E_Banking.dao.UserDao;
import com.E_Banking.model.Admin;
import com.E_Banking.model.Users;



@Service
public class UserService {
	@Autowired
	UserDao dao;
	@Autowired
	AdminDao adao;
	
	
	public Object findUserByUsername(String username) {
		Users customer = dao.getUser(username);
        if (customer != null) {
            return customer;
        }
        Admin admin = adao.getAdmin(username);
        if (admin != null) {
            return admin;
        }

        return "User not found!";
    }
	public Map<String, String> registerCustomer(@RequestBody Users customer) {
	    Map<String, String> response = new HashMap<>();

	    if (dao.getUser(customer.getUsername()) != null) {
	        response.put("message", "Customer already exists!");
	    } else {
	        dao.saveUsers(customer);
	        response.put("message", "Customer registered successfully!");
	    }

	    return response; // Spring Boot automatically converts this to JSON
	}

    // Register a new Admin
	public Map<String, String> registerAdmin(@RequestBody Admin admin) {
	    Map<String, String> response = new HashMap<>();
	    
	    if (adao.getAdmin(admin.getUsername()) != null) {
	        response.put("message", "Admin already exists!");
	    } else {
	        adao.saveAdmin(admin);
	        response.put("message", "Admin registered successfully!");
	    }
	    
	    return response; // Returns JSON automatically
	}
	
//	public void saveUsers(Users user){
//	    dao.saveUsers( user);
//		
//	}
	public List<Users> getAllUsers(){

		return dao.getAllUsers();

	}
//	public Users getUser(String username) {
//
//		return dao.getUser(username);
//	}
//	public void deleteUser(String username)
//	{
//		dao.deleteUser(username);
//	}
}
