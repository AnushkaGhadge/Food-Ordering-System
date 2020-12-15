package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.DeliveryBoy;
import com.app.pojos.Orders;
import com.app.services.IDeliveryBoyService;

@RestController
@RequestMapping("/deliveryboy")
@CrossOrigin

public class DeliveryBoyController {
	@Autowired
	private IDeliveryBoyService dservice;

	@GetMapping("/deliveryhistory/{uid}")
	public ResponseEntity<?> listOrders(@PathVariable Integer uid) {
		List<DeliveryBoy> listOrders = dservice.viewOrderHistory(uid);
		System.out.println(listOrders);
		if (listOrders.size() != 0)
			return new ResponseEntity<List<DeliveryBoy>>(listOrders, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/neworders/{uid}")
	public ResponseEntity<?> newOrders(@PathVariable Integer uid) {
		Orders listOrders = dservice.viewNewOrders(uid);
		System.out.println(listOrders);
		if (listOrders != null)
			return new ResponseEntity<Orders>(listOrders, HttpStatus.OK);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("/changestatus/{orderid}/{userid}")
	public ResponseEntity<?> changeorderstatus(@PathVariable Integer orderid, @PathVariable Integer userid) {
		Orders o = dservice.changeorderstatus(orderid, userid);
		return new ResponseEntity<Orders>(o, HttpStatus.OK);
	}

}