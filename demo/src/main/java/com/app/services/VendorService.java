package com.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IVendorDao;
import com.app.pojos.Orders;
import com.app.pojos.Product;
import com.app.pojos.User;
import com.app.pojos.Vendor;

@Service
@Transactional
public  class VendorService implements IVendorService
{
	@Autowired
	private IVendorDao vdao;
	@Override
	public Product addproduct(Product p,Integer vid) {
		// TODO Auto-generated method stub
		return vdao.addproduct(p, vid);
	}
	@Override
	public List<Product> getprodlist(Vendor v) {
		
		return vdao.getallprod(v);
	}
	@Override
	public Vendor getVendorById(Integer vid) {

		return vdao.VendorById(vid);
	}
	@Override
	public Product getProductById(Integer pid) {
		// TODO Auto-generated method stub
		return vdao.getProductById(pid);
	}
	@Override
	public Product updateProduct(Product p) {

		return vdao.updateProduct(p);
	}
	@Override
	public User getUserById(Integer uid) {
		return vdao.getUserById(uid);

	}
	@Override
public	User updateUser(User u) {
		return vdao.updateUser(u);
	}
//	@Override
//	public String updatepassword(String newpassword) {
//		// TODO Auto-generated method stub
//		return vdao.updatepassword(newpassword);
//	}
	@Override
	public List<Orders> pendingOrders(Integer uid) {
		
		return vdao.pendingOrders(uid);
	}
	@Override
	public Vendor getVendorByvId(Integer vid) {
		// TODO Auto-generated method stub
		return vdao.getVendorByvId(vid);
	}

}
