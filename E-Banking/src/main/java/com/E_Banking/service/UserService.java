package com.E_Banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public String registerCustomer(Users customer) {
        if (dao.getUser(customer.getUsername()) != null) {
            return "Customer already exists!";
        }
        dao.saveUsers(customer);
        return "Customer registered successfully!";
    }

    // Register a new Admin
    public String registerAdmin(Admin admin) {
        if (adao.getAdmin(admin.getUsername()) != null) {
            return "Admin already exists!";
        }
        adao.saveAdmin(admin);
        return "Admin registered successfully!";
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
