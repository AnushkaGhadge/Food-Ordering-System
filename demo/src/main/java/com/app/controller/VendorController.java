package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

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

import com.app.pojos.CuisineType;
import com.app.pojos.Image;
import com.app.pojos.Orders;
import com.app.pojos.Pcategory;
import com.app.pojos.Product;
import com.app.pojos.User;
import com.app.pojos.Vendor;
import com.app.services.IUserService;
import com.app.services.IVendorService;

@RestController
@RequestMapping("/vendor")
@CrossOrigin
public class VendorController {

	@Autowired
	private IVendorService vservice;

	@Autowired
	private IUserService uservice;

	@PostConstruct
	public void init() {
		System.out.println("inside vendor controller");
	}

//	@PostMapping(consumes= {"multipart/form-data"})
//	public  ResponseEntity<?> addproduct(@RequestParam String pName, 
//			@RequestParam float pPrice,@RequestParam byte[] image, 
//			@RequestParam Pcategory vegnonveg, @RequestParam CuisineType cType,
//			@RequestParam Integer vId)
////	{
////		try {
//System.out.println("image sop"+ image);
//			Product p=new Product(pName, pPrice, null, vegnonveg, cType);
//			
//			vservice.addproduct(p,vId);
//			
//			return new ResponseEntity<Void>(HttpStatus.OK);
//
//		} catch (RuntimeException e) {
//			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		}
//	}

	@PostMapping(consumes = { "multipart/form-data" })
	public ResponseEntity<?> addProduct(@RequestParam String pName, @RequestParam float pPrice,
			@RequestParam MultipartFile image, @RequestParam Pcategory vegnonveg, @RequestParam CuisineType cType,
			@RequestParam Integer vId) throws IOException {

		System.out.println("in add product dtls " + pName);

		Product p = new Product(pName, pPrice, vegnonveg, cType);
		Image i = new Image();
		i.setImage(image.getBytes());
		try {

			if (image != null) {
				System.out.println(image.getOriginalFilename());
				p.addImage(i);
				Product p1 = vservice.addproduct(p, vId);
				return new ResponseEntity<Product>(p1, HttpStatus.CREATED);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}
	



	@GetMapping("/showallproducts/{uid}")
	public ResponseEntity<?> listallproducts(@PathVariable Integer uid) {

		Vendor v = vservice.getVendorById(uid);

		Integer vid = v.getvId();
		System.out.println("inside list all products");
		try {
			List<Product> plist = vservice.getprodlist(v);
			System.out.println(plist);
			return new ResponseEntity<List<Product>>(plist, HttpStatus.OK);

		} catch (RuntimeException e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		// vservice.getprodlist();
		// return new
		// ResponseEntity<List<Product>>(vservice.getprodlist(v),HttpStatus.OK);
	}

	@GetMapping("/showallproductsbyvid/{vid}")
	public ResponseEntity<?> listallproductsvid(@PathVariable Integer vid) {
		Vendor v = vservice.getVendorByvId(vid);
		System.out.println(v);
		System.out.println("inside list all products");
		try {
			List<Product> plist = vservice.getprodlist(v);
			System.out.println(plist);
			return new ResponseEntity<List<Product>>(plist, HttpStatus.OK);

		} catch (RuntimeException e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
		// vservice.getprodlist();
		// return new
		// ResponseEntity<List<Product>>(vservice.getprodlist(v),HttpStatus.OK);
	}

	@GetMapping("/editproduct/{pid}")
	public ResponseEntity<?> getProductById(@PathVariable Integer pid) {
		System.out.println("inside list all products");
		try {
			Product p = vservice.getProductById(pid);
			return new ResponseEntity<Product>(p, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/editproduct")
	public ResponseEntity<?> updateProduct(@RequestBody Product prod) {
		System.out.println(prod);

		System.out.println("inside udpate product");
		try {
			Product p1 = vservice.updateProduct(prod);
			return new ResponseEntity<Product>(p1, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getVendorById/{uid}")
	public ResponseEntity<?> editVendorById(@PathVariable Integer uid) {

		User u123 = vservice.getUserById(uid);
		try {
			// Product p1=vservice.updateProduct(prod);
			return new ResponseEntity<User>(u123, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/editvendor")
	public ResponseEntity<?> editVendor(@RequestBody User u) {
		Vendor v = vservice.getVendorById(u.getId());
		User u123 = vservice.updateUser(u);
		try {
			return new ResponseEntity<User>(u123, HttpStatus.OK);
		} catch (RuntimeException e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/pendingorders/{uid}")
	public ResponseEntity<?> pendingOrders(@PathVariable Integer uid) {
		System.out.println("inside pending orders");
		List<Orders> pendingorders = vservice.pendingOrders(uid);

		return new ResponseEntity<List<Orders>>(pendingorders, HttpStatus.OK);
//		
//		try {
//			return new ResponseEntity<List<Orders>>(pendingorders,HttpStatus.OK);
//		} catch (RuntimeException e) {
//			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
//		}

	}

}
