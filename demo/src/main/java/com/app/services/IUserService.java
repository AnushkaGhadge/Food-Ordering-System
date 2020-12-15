package com.app.services;

import java.util.List;

import com.app.pojos.User;
import com.app.pojos.Vendor;

public interface IUserService {
	 List<User> getallUsers();

	User validateUser(String email, String password);

	Vendor getVendorById(Integer id);

	User updatePassword(String email,String password,String newpassword);

	User getUserById(Integer uid);

	
}
