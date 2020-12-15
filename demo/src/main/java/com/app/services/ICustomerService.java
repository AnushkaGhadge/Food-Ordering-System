package com.app.services;

import java.util.List;

import com.app.pojos.*;

public interface ICustomerService {

	
	List<Vendor> getallvendors();

	List<Orders> orderHistoryById(User u);

	Product getproductbyid(Integer pid);


	Orders createneworder(List<ProductHelper> plist, Customer customer, Vendor vendor,Integer finaltotal);

	Customer getCustomerBycid(Integer customerId);

	Customer getCustomerById(Integer userId);

	Payment getPayentdetails(Orders o);
	
	User addcustomer(User u);

}
