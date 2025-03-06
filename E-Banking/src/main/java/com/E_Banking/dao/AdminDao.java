package com.E_Banking.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.E_Banking.model.Admin;


@Repository
public class AdminDao {
	@Autowired
	SessionFactory factory;
	
	public void saveAdmin(Admin admin){
		//user.setUsername(user.getUsername().trim());
		Session session =factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(admin);
	
		tx.commit();
		System.out.println(admin);
		}
	
	public List<Admin> getAllAdmin(){
		Session session =factory.openSession();
		Query query=session.createQuery("from Admin");
		return query.list();
		}
	public Admin getAdmin(String username) {
		Session session =factory.openSession();
		Query <Admin> query=session.createQuery("from Admin where username=:username");
		query.setParameter("username",username);
		List<Admin> admins = query.list();
	    
	    return admins.isEmpty() ? null : admins.get(0);
		}
	

	public  void deleteAdmin(String username)
	{
		

		Session session=factory.openSession();
		
		Query<Admin> query=session.createQuery("delete from Admin where username=:username");
		
		query.setParameter("username",username);
		
		Transaction tx=session.beginTransaction();
		
			query.executeUpdate();
		
		tx.commit();
		
		
	}
}
