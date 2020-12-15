package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICustomerDao;
import com.app.pojos.Customer;
import com.app.pojos.OrderDetails;
import com.app.pojos.Orders;
import com.app.pojos.Payment;
import com.app.pojos.Product;
import com.app.pojos.ProductHelper;
import com.app.pojos.User;
import com.app.pojos.Vendor;


@Service
@Transactional
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomerDao cdao;
	@Override
	public List<Vendor> getallvendors() {
		return cdao.getallvendors();
	}


	@Override
	public List<Orders> orderHistoryById(User u) {
		// TODO Auto-generated method stub
		return cdao.orderHistoryById(u);
	}


	@Override
	public Product getproductbyid(Integer pid) {
		return cdao.getproductbyid(pid)  ;
	}




	@Override
	public Orders createneworder(List<ProductHelper> plist,Customer customer, Vendor vendor,Integer finaltotal) {
		// TODO Auto-generated method stub
		return cdao.createneworder(plist,customer,vendor,finaltotal);
	}


	@Override
	public Customer getCustomerBycid(Integer customerId) {
		return cdao.getCustomerBycid(customerId);
	}


	@Override
	public Customer getCustomerById(Integer userId) {
		// TODO Auto-generated method stub
		return cdao.getCustomerById(userId);
	}

//
//	@Override
//	public OrderDetails getOrderdeatils(Orders o) {
//		// TODO Auto-generated method stub
//		return cdao.getOrderdeatils(o);
//	}


	@Override
	public User addcustomer(User u) {
		// TODO Auto-generated method stub
		return cdao.addcustomer(u);
	}


	@Override
	public Payment getPayentdetails(Orders o) {
		return cdao.getPaymentdetails(o);

	}
	
	
	

}
