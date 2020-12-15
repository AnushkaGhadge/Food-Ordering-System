package com.app.dao;

import java.util.List;

import com.app.pojos.*;


public interface IVendorDao {

	Product addproduct(Product p,Integer vid);
List<Product> getallprod(Vendor  v);
Vendor VendorById(Integer uid);
Product getProductById(Integer pid);
Product updateProduct(Product pid);
User getUserById(Integer uid);
User updateUser(User u);
//String updatepassword(String newpassword);

List<Orders> pendingOrders(Integer uid);
 Vendor getVendorByvId(Integer vid);

}
