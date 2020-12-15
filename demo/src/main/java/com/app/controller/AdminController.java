package com.app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.DeliveryBoy;
import com.app.pojos.Orders;
import com.app.pojos.User;
import com.app.pojos.Vendor;
import com.app.services.IAdminService;
import com.app.services.IVendorService;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController 
{
	@Autowired
	private IAdminService aservice;
	
	@Autowired
	private IVendorService vservice;
	
	@GetMapping("/list")
	public ResponseEntity<List<User>> listOfUsers()
	{
		List<User> listAllUsers=aservice.getAllUsers();
		System.out.println(listAllUsers);
		if(listAllUsers.size()!=0)
			return new ResponseEntity<List<User>>(listAllUsers, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/viewhistory")
	public ResponseEntity<List<Orders>> viewhistory()
	{
		List<Orders> listOrders =aservice.viewOrderHistory();
		System.out.println(listOrders);
		if(listOrders.size()!=0)
			return new ResponseEntity<List<Orders>>(listOrders, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@GetMapping("/listpendingorder")
	public ResponseEntity<List<Orders>> listOrders()
	{
		List<Orders> listOrders =aservice.listpendingorder();
		System.out.println(listOrders);
		if(listOrders.size()!=0)
			return new ResponseEntity<List<Orders>>(listOrders, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
//	@PostMapping("/addvendor/{rname}")
//	public ResponseEntity<?> addVendor(@RequestBody User u,@PathVariable String rname)
//	{
//		System.out.println(u);
//	Vendor v1=aservice.addNewVendor(u,rname);
//		if(v1!=null)
//			return new ResponseEntity<Vendor>(v1,HttpStatus.OK);
//		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	}
//	
	@PostMapping("/addvendor/{rname}")
	public ResponseEntity<?> addVendor(@RequestBody User u,@PathVariable String rname)
	{
		System.out.println(u);
	Vendor v1=aservice.addNewVendor(u,rname);
		if(v1!=null)
			return new ResponseEntity<Vendor>(v1,HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	@PostMapping(consumes = { "multipart/form-data" })
	public ResponseEntity<?> addimage(@RequestParam MultipartFile image, @RequestParam Integer vId) throws IOException {
			
		
			try {

				System.out.println(image);
				System.out.println(vId);
			if (image != null) {
				Vendor v=vservice.getVendorByvId(vId);	
				v.setImage(image.getBytes());
				Vendor  v1= aservice.addimagetovendor(v);
				return new ResponseEntity<Vendor>(v1, HttpStatus.CREATED);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}
	
	
	
	
	@PostMapping("/adddeliveryboy")
	public ResponseEntity<?> addDB(@RequestBody User u)
	{
		System.out.println(u);
		User user=aservice.addDeliveryBoy(u);
		if(user!=null)
			return new ResponseEntity<User>(user,HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}


	@GetMapping("/assigndb/{orderid}")
	public ResponseEntity<?> assignDB(@PathVariable Integer orderid)
	{
		DeliveryBoy deliveryBoy=aservice.assigndb(orderid);
		try {
			if(deliveryBoy!=null)
				return new ResponseEntity<DeliveryBoy>(deliveryBoy,HttpStatus.OK);

			Integer i = 0;
			if(deliveryBoy==null)
				return new ResponseEntity<Integer>(i,HttpStatus.OK);
	
		
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
}

