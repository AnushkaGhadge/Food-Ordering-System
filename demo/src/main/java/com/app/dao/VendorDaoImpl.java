package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.app.pojos.Orders;
import com.app.pojos.Product;
import com.app.pojos.User;
import com.app.pojos.Vendor;

@Repository
public class VendorDaoImpl implements IVendorDao {
	@PersistenceContext
	private EntityManager mgr;
		@Override
	public Product addproduct(Product p,Integer uid) {
		String jpql="select v from Vendor v left outer  join fetch  v.userVendor where v.userVendor.id=:uid";

		//p.setImage(image);	
		
		//	select p from Payment p  left outer join fetch p.user where p.user.id=:id"
		Vendor v=mgr.unwrap(Session.class).createQuery(jpql, Vendor.class).setParameter("uid",uid).getSingleResult();
		String success="";
		try {
			if(v!=null)
			{	System.out.println(v);
			p.setpVendor(v);
			mgr.unwrap(Session.class).persist(p);
			success="product added successfully";
			return p;
			}
		} catch (Exception e) {
			e.printStackTrace();
			success ="failed";
			return null;
		}
		success ="failed";
		return null;
	}

	@Override
	public List<Product> getallprod(Vendor v) {

		String jpql1="select p from Product p where p.pVendor=:vendor";	
		List<Product> plist1= mgr.unwrap(Session.class).createQuery(jpql1,Product.class).setParameter("vendor",v).getResultList();
		System.out.println(plist1);
		return plist1;
	}
	@Override
	public Vendor VendorById(Integer uid) {

		String jpql="select v from Vendor v left outer  join fetch  v.userVendor where v.userVendor.id=:uid";
		Vendor v=mgr.unwrap(Session.class).createQuery(jpql, Vendor.class).setParameter("uid",uid).getSingleResult();
		return v;
	}

	@Override
	public Product getProductById(Integer pid) {
		String jpql="select p from Product p where p.pId=:id";

		Product p=mgr.unwrap(Session.class).createQuery(jpql, Product.class).setParameter("id",pid).getSingleResult();

		return p;
	}

	@Override
	public Product updateProduct(Product p) {

		mgr.unwrap(Session.class).update(p);
		return p;
	}

	@Override
	public User getUserById(Integer uid) {
		String jpql="select u from User u where u.id=:uid";
		return mgr.unwrap(Session.class).createQuery(jpql, User.class).setParameter("uid",uid).getSingleResult();	
	}

	@Override
	public User updateUser(User u) {

		mgr.unwrap(Session.class).update(u);
		return u;
	}

	//	@Override
	//	public String updatepassword(String newpassword)
	//	{
	//		String jpql="select u from User u where u.password=:password1";
	//		 mgr.unwrap(Session.class).createQuery(jpql, User.class).setParameter("password1",newpassword).getSingleResult();	
	//		
	//		return null;
	//		
	//	}

	@Override
	public List<Orders> pendingOrders(Integer uid) {
		System.out.println("inside pending orders dao");
		String jpql1="select v from Vendor v left outer  join fetch  v.userVendor where v.userVendor.id=:uid";

		Vendor v1=mgr.unwrap(Session.class).createQuery(jpql1, Vendor.class).setParameter("uid",uid).getSingleResult();
		System.out.println(v1);
		String jpql="select o from Orders o where o.oStatus=:status and o.oVendor=:v ";
	///	String jpql="select o from Orders o where o.oStatus=:status ";
		return mgr.unwrap(Session.class).createQuery(jpql, Orders.class).setParameter("status","NOT_DELIVERED").setParameter("v", v1).getResultList();	
	}

	@Override
	public Vendor getVendorByvId(Integer vid) {
		String jpql="select v from Vendor v  where v.vId=:vid";
		return mgr.unwrap(Session.class).createQuery(jpql, Vendor.class).setParameter("vid",vid).getSingleResult();
	}
}
