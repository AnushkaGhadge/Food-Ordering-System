package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.User;
import com.app.pojos.UserRole;
import com.app.pojos.Vendor;

@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	private IUserDao udao;
	
	@Override
	public User validateUser(String email, String password) {

		User u=udao.validateUser(email, password);

		return u;
	}

	@Override
	public List<User> getallUsers() {

		List<User> userlist = udao.getallUsers();
		return userlist;
	}

	@Override
	public Vendor getVendorById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public User getUserById(Integer uid) {
		return udao.getUserById(uid);

	}

	@Override
	public User updatePassword(String email, String password, String newpassword) {

		return udao.updatePassword(email,password,newpassword);
	}
	
}
