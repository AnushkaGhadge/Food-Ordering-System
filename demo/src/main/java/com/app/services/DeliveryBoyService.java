package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminDao;
import com.app.dao.IDeliveryBoy;
import com.app.pojos.DeliveryBoy;
import com.app.pojos.Orders;

@Service
@Transactional
public class DeliveryBoyService implements IDeliveryBoyService
{
	@Autowired
	private IDeliveryBoy ddao;

	@Override
	public List<DeliveryBoy> viewOrderHistory(int id) 
	{
		List<DeliveryBoy> listOrders=ddao.viewAllOrderHistorty(id);
		return listOrders;
	}

	@Override
	public Orders viewNewOrders(Integer uid) 
	{
		Orders listOrders=ddao.viewAllNewOrders(uid);
		return listOrders;
	}
	@Override
	public Orders changeorderstatus(Integer orderid, Integer userid) {
		// TODO Auto-generated method stub
		return ddao.changeorderstatus(orderid, userid);
	}
//	@Override
//	public Orders listdborderbyuid(Integer userid) {
//		// TODO Auto-generated method stub
//		return ddao.listdborderbyuid(userid);
//	}
}
