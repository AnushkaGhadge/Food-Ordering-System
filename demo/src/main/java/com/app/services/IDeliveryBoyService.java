package com.app.services;

import java.util.List;

import com.app.pojos.DeliveryBoy;
import com.app.pojos.Orders;

public interface IDeliveryBoyService {

	List<DeliveryBoy> viewOrderHistory(int id);

	Orders viewNewOrders(Integer uid);

	Orders changeorderstatus(Integer orderid, Integer userid);

//	Orders listdborderbyuid(Integer userid);

}
