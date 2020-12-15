package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminDao;
import com.app.dao.IUserDao;
import com.app.pojos.DeliveryBoy;
import com.app.pojos.Orders;
import com.app.pojos.User;
import com.app.pojos.Vendor;
@Service
@Transactional
public class AdminService implements IAdminService {
	@Autowired
	private IAdminDao adao;
	
	@Override
	public List<User> getAllUsers() {
		List<User> listAllUsers =  adao.listallusers();
		return listAllUsers;
	}

	@Override
	public List<Orders> viewOrderHistory() {
		List<Orders> listOrders=adao.viewAllOrderHistorty();
		//int vendor=adao.matchingVendor();
		return listOrders;
	}

//	@Override
//	public User addNewVendor(User u) {
//		User u1=adao.addVendor(u);
//		return u1;
//	}

//	@Override
//	public User addNewVendor(User u) {
//		User u1=adao.addVendor(u);
//		return u1;
//	}

//	@Override
//	public Vendor addVendor(Vendor v) {
//		Vendor v1=adao.addNewVendor(v);
//		return v1;
//	}

//	@Override
//	public Vendor addVendorv(Vendor v) {
//		Vendor v1=adao.addVendorv(v);
//		return v1;
//	}
//	@Override
//	public DeliveryBoy addNewDeliveryBoy(DeliveryBoy d) {
//		DeliveryBoy d1=adao.addDeliveryBoy(d);
//		return d1;
//	}

	@Override
	public List<DeliveryBoy> assignDelBoy() {
		List<DeliveryBoy> listDeliveryBoy=adao.viewAllDeliveryBoy();
		return listDeliveryBoy;
	}

	@Override
	public User addDeliveryBoy(User u) {
		
		User u1=adao.addDB(u);
		return u1;
	}

	@Override
	public Vendor addNewVendor(User u, String rname) {
		return adao.addVendor(u,rname);
	}

	@Override
	public DeliveryBoy assigndb(Integer orderid) {
		// TODO Auto-generated method stub
		return adao.assigndb(orderid);
	}

	@Override
	public List<Orders> listpendingorder() {
		// TODO Auto-generated method stub
		return adao.listpendingorder();
	}

	@Override
	public Vendor addimagetovendor(Vendor v) {
		// TODO Auto-generated method stub
		return adao.addimagetovendor(v);
	}

	

}
