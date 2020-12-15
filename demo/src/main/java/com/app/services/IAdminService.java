package com.app.services;

import java.util.List;

import com.app.pojos.DeliveryBoy;
import com.app.pojos.Orders;
import com.app.pojos.User;
import com.app.pojos.Vendor;

public interface IAdminService {

	List<User> getAllUsers();

	List<Orders> viewOrderHistory();

	Vendor addNewVendor(User u,String rname);

	//Vendor addVendorv(Vendor v);

	//DeliveryBoy addNewDeliveryBoy(DeliveryBoy d);

	List<DeliveryBoy> assignDelBoy();

	User addDeliveryBoy(User u);

	DeliveryBoy assigndb(Integer orderid);

	List<Orders> listpendingorder();

	Vendor addimagetovendor(Vendor v);

}
