package com.E_Banking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.E_Banking.model.Users;


@Repository
public class UserDao {

	@Autowired
	SessionFactory factory;
	
	public void saveUsers(Users user){
		//user.setUsername(user.getUsername().trim());
		Session session =factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(user);
	
		tx.commit();
		System.out.println(user);
		}
	
	public List<Users> getAllUsers(){
		Session session =factory.openSession();
		Query query=session.createQuery("from Users");
		return query.list();
		}
	public Users getUser(String username) {
		Session session =factory.openSession();
		Query <Users> query=session.createQuery("from Users where username=:username");
		query.setParameter("username",username);
		List<Users> users = query.list();
	    
	    return users.isEmpty() ? null : users.get(0);
		}
	

	public  void deleteUser(String username)
	{
		

		Session session=factory.openSession();
		
		Query<Users> query=session.createQuery("delete from Users where username=:username");
		
		query.setParameter("username",username);
		
		Transaction tx=session.beginTransaction();
		
			query.executeUpdate();
		
		tx.commit();
		
		
	}
}
