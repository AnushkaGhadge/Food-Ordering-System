package com.app.dao;

import java.util.List;

import com.app.pojos.DeliveryBoy;
import com.app.pojos.Orders;

public interface IDeliveryBoy {

	List<DeliveryBoy> viewAllOrderHistorty(int id);

	Orders viewAllNewOrders(Integer uid);

	Orders changeorderstatus(Integer orderid, Integer userid);


}
