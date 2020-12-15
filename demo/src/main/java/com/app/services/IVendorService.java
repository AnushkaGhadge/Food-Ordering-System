package com.app.services;

import java.util.List;

import com.app.pojos.*;

public interface IVendorService {
	Product addproduct(Product p,Integer vId);
	List<Product> getprodlist(Vendor v);
	Vendor getVendorById(Integer uid);
	Product getProductById(Integer pid);
//Vendor getVendorById(Integer id);
	Product updateProduct(Product pid);
	User getUserById(Integer uid);
	User updateUser(User u);
	//String updatepassword(String newpassword);

	List<Orders> pendingOrders(Integer uid);

	Vendor getVendorByvId(Integer vid);

	
}
