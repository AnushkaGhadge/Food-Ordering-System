package com.app.dao;

import java.util.List;

import com.app.pojos.Customer;
import com.app.pojos.OrderDetails;
import com.app.pojos.Orders;
import com.app.pojos.Payment;
import com.app.pojos.Product;
import com.app.pojos.ProductHelper;
import com.app.pojos.User;
import com.app.pojos.Vendor;

public interface ICustomerDao {

	List<Vendor> getallvendors();

	List<Orders> orderHistoryById(User u);
	Product getproductbyid(Integer pid);
	
	Orders createneworder(List<ProductHelper> plist,Customer customer,Vendor vendor,Integer finaltotal);

	Customer getCustomerBycid(Integer customerId);
	Customer getCustomerById(Integer userId);

	Payment getPaymentdetails(Orders o);

	User addcustomer(User u);

}
