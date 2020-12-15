package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Customer;
import com.app.pojos.User;
import com.app.services.ICustomerService;
import com.app.services.IUserService;

@RestController
@RequestMapping("/home")
@CrossOrigin
public class UserController {

	@Autowired
	private IUserService uservice;
	@Autowired
	private ICustomerService cservice;

	
	
	@GetMapping("/login")
	public String showlogin()
	{
		System.out.println("in show login form");
		return "user/login";

	}

	//	public RequestEntity<?>  postlogin(@RequestBody User u,HttpSession hs)
	//	{
	//		
	//	if(u!=null)
	//	{
	//
	//		User u1=uservice.validateUser(u.getEmail(),u.getPassword());
	//		hs.setAttribute("user_dtls",u1);
	//		if(u1.getRole().equals("ADMIN"))
	//			return ""
	//	}
	//}
	//	@PostMapping("/login")
	//	public String  afterlogin(@RequestBody User u,HttpSession hs)
	//	{
	//		
	//		User u1=uservice.validateUser(u.getEmail(),u.getPassword());
	//		if(u1!=null)
	//		{
	//			System.out.println(u1);
	//	return 	"logged in";
	//	}
	//		
	//return "login failed";
	//	}
	@PostMapping("/login")
	public ResponseEntity<?> postlogin(@RequestBody User u)
	{
		User u1=uservice.validateUser(u.getEmail(),u.getPassword());
//		u1.setuCustomer(null);
//		u1.setuDeliveryBoy(null);
//		u1.setuVendor(null);
		try {
			if(u1!=null)	
				return new ResponseEntity<User>(u1,HttpStatus.OK);	

			return new ResponseEntity<User>(u1,HttpStatus.NOT_FOUND);
		}
		catch (Exception e) {
			return new ResponseEntity<User>(u1,HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/listusers")
	public ResponseEntity<?> getUsers()
	{
		uservice.getallUsers();
					return new ResponseEntity<List<User>>(uservice.getallUsers(),HttpStatus.OK);
	 }
	
	
	@GetMapping("/getCustomerById/{cid}")
	public  ResponseEntity<?> editVendorById(@PathVariable Integer cid)
	{		

		Customer u123=cservice.getCustomerBycid(cid);
		try {
		//	Product p1=vservice.updateProduct(prod);
			return new ResponseEntity<Customer>(u123,HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	@PutMapping("/changepassword")
	public  ResponseEntity<?> changePassword(@RequestBody User u)
	{		
		User u123=uservice.updatePassword(u.getEmail(),u.getPassword(),u.getNewpassword());
		try {
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
}