package com.app.dao;

import java.util.List;

import com.app.pojos.DeliveryBoy;
import com.app.pojos.Orders;
import com.app.pojos.User;
import com.app.pojos.Vendor;

public interface IAdminDao {

	List<User> listallusers();

	List<Orders> viewAllOrderHistorty();

	Vendor addVendor(User u, String rname);

//	Vendor addVendorv(Vendor v);

	//DeliveryBoy addDeliveryBoy(DeliveryBoy d);

	List<DeliveryBoy> viewAllDeliveryBoy();

	User addDB(User u);

	DeliveryBoy assigndb(Integer orderid);

	
	List<Orders> listpendingorder();

	Vendor addimagetovendor(Vendor v);

//	int matchingVendor();
//
}
