package com.E_Banking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.E_Banking.model.Admin;
import com.E_Banking.model.Users;
import com.E_Banking.service.UserService;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	UserService service;
	
	@GetMapping("/find/{username}")
    public Object findUserByUsername(@PathVariable String username) {
        return service.findUserByUsername(username);
    }

    // Register a new customer
    @PostMapping("/register/customer")
    public Map<String, String> registerCustomer(@RequestBody Users customer) {
        return service.registerCustomer(customer);
    }

    // Register a new admin
    @PostMapping("/register/admin")
    public Map<String, String> registerAdmin(@RequestBody Admin admin) {
        return service.registerAdmin(admin);
    }
//	@RequestMapping("saveUser")
//	public void  saveUsers(@RequestBody Users user){
//	 service.saveUsers( user);
//		
//	}
//	
	@GetMapping("getAllUsers")
	public List<Users>getAllUsers(){
		return service.getAllUsers();

	}
//	@RequestMapping("getUser/{username}")
//	public Users getUser(@PathVariable String username) {
//
//		System.out.println(username);
//		return service.getUser(username);
//	}
//	@DeleteMapping("deleteUser/{username}")
//	public ResponseEntity<Boolean> deleteUser(@PathVariable String username)
//	{
//		service.deleteUser(username);
//		
//		ResponseEntity<Boolean> responseEntity=new ResponseEntity<Boolean>(true,HttpStatus.OK);
//		
//		return responseEntity;
//		
//	}
}
