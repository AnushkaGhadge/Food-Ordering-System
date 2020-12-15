package com.app.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Customer;
import com.app.pojos.OrderDetails;
import com.app.pojos.Orders;
import com.app.pojos.Payment;
import com.app.pojos.Product;
import com.app.pojos.ProductHelper;
import com.app.pojos.User;
import com.app.pojos.Vendor;
import com.app.services.ICustomerService;
import com.app.services.IVendorService;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController 
{
	
	@Autowired
	  private ICustomerService cservice;
	@Autowired
	  private  IVendorService vservice;

	@GetMapping("/showallvendors")
	public  ResponseEntity<?> getallVendors()
	{
		System.out.println("inside list all products");
		try {
    List<Vendor> vlist=cservice.getallvendors();
			return new ResponseEntity<List<Vendor>>(vlist,HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/orderhistoryById/{uid}")
	public  ResponseEntity<?> getOrderHistoryById(@PathVariable Integer uid)
	{
		System.out.println("inside order history");
		try {
			
			User u=vservice.getUserById(uid);
			
    List<Orders> olist=cservice.orderHistoryById(u);
    
			return new ResponseEntity<List<Orders>>(olist,HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getproductbyid/{pid}")
	public  ResponseEntity<?> getproductbyid(@PathVariable Integer pid)
	{
		System.out.println("inside order history");
		try {
			
			Product p=cservice.getproductbyid(pid);
			
    
			return new ResponseEntity<Product>(p,HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	//cart for 1 product
//	@PostMapping("/addorder/{userId}/{vendorId}/{qty}")
//	public  ResponseEntity<?> addorder(@RequestBody Product p,@PathVariable Integer userId,@PathVariable Integer  vendorId,@PathVariable Integer qty)
//	{
//	try {	
//		
//		System.out.println(p.getpId());
//		System.out.println(p.getpPrice());
//		System.out.println("/"+userId +"/"+vendorId+"/"+qty);
//		Vendor v=vservice.getVendorByvId(vendorId);
//		System.out.println(v);
//		Customer c=cservice.getCustomerById(userId);
//		Orders o=cservice.createneworder(p,qty,c,v);
//		System.out.println(o);
//		return new ResponseEntity<Orders>(o,HttpStatus.OK);
//		} catch (RuntimeException e) {
//			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		}
//		
//	}
//	
	///cart for list of products
	@PostMapping("/addorder/{userId}/{vendorId}/{finaltotal}")
	public  ResponseEntity<?> addorder(@RequestBody List<ProductHelper> plist,@PathVariable Integer userId,@PathVariable Integer  vendorId,@PathVariable Integer finaltotal)
	{
	try {	
		
		for (ProductHelper productHelper : plist) {
System.out.println(productHelper);			
		}
		System.out.println("/"+userId +"/"+vendorId);
		Vendor v=vservice.getVendorByvId(vendorId);
		Customer c=cservice.getCustomerById(userId);
	
		Orders o=cservice.createneworder(plist,c,v,finaltotal);
		System.out.println(o);
		return new ResponseEntity<Orders>(o,HttpStatus.OK);
//		return null;
		} catch (RuntimeException e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		
	}
//	@PostMapping("/paymentdetails")
//	public  ResponseEntity<?> orderdetails(@RequestBody Orders o)
//	{
//	try {	
//	System.out.println("inside payment details");
//		OrderDetails odtls=cservice.getOrderdeatils(o);
//		System.out.println(odtls);
//		return new ResponseEntity<OrderDetails>(odtls,HttpStatus.OK);
//		} catch (RuntimeException e) {
//			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		}
//	}
//	
	
	
	@PostMapping("/paymentdetails")
	public  ResponseEntity<?> orderdetails(@RequestBody Orders o)
	{
	try {	
	System.out.println("inside payment details");
		Payment pmt=cservice.getPayentdetails(o);
		System.out.println(pmt);
		return new ResponseEntity<Payment>(pmt,HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/registercustomer")
	public  ResponseEntity<?> addcustomer(@RequestBody User c)
	{
	try {	
	System.out.println("inside order details");
		
		User c1=cservice.addcustomer(c);
		
		
		System.out.println(c1);
		
		return new ResponseEntity<User>(c1,HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}	
	
	
}
