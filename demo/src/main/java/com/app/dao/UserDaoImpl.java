package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;



@Repository
public class UserDaoImpl implements IUserDao
{

	@PersistenceContext
	private EntityManager mgr;
		
	@Override
	public User validateUser(String email, String password) {
		String jpql = "select u from User u where u.email=:em and u.password=:pass";
		return mgr.unwrap(Session.class).createQuery(jpql, User.class).setParameter("em", email)
				.setParameter("pass", password).getSingleResult();
	}
	
	@Override
	public List<User> getallUsers()
	{
	String jpql="select u from User u";	
	return mgr.unwrap(Session.class).createQuery(jpql,User.class).getResultList();
	}


	@Override
	public User updatePassword(String email,String password,String newpassword) {
	
		String jpql="select u from User u where u.email=:em and u.password=:pass";
		
		User u = mgr.unwrap(Session.class).createQuery(jpql, User.class)
		.setParameter("em",email)
		.setParameter("pass", password)
		.getSingleResult();
		
		
		u.setPassword(newpassword);
		mgr.unwrap(Session.class).update(u);

		return u;
	}

	@Override
	public User getUserById(Integer uid) {
		String jpql="select u from User u where u.id=:uid";
		return mgr.unwrap(Session.class).createQuery(jpql, User.class).setParameter("uid",uid).getSingleResult();	
	}

	
}
