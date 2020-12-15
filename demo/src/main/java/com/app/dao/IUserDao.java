package com.app.dao;

import java.util.List;

import com.app.pojos.User;


public interface IUserDao {

	 User validateUser(String email,String password);
	 List<User> getallUsers();
		User updatePassword(String email,String password,String newpassword);
		User getUserById(Integer uid);
}
