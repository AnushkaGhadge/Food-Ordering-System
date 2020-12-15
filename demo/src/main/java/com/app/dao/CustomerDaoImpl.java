package com.app.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.app.pojos.Customer;
import com.app.pojos.OrderDetails;
import com.app.pojos.Orders;
import com.app.pojos.Payment;
import com.app.pojos.PaymentMode;
import com.app.pojos.Product;
import com.app.pojos.ProductHelper;
import com.app.pojos.User;
import com.app.pojos.UserRole;
import com.app.pojos.Vendor;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

	@PersistenceContext
	private EntityManager mgr;

	@Override
	public List<Vendor> getallvendors() {

		String jpql = "select v from Vendor v";
		return mgr.unwrap(Session.class).createQuery(jpql, Vendor.class).getResultList();
	}

	@Override
	public List<Orders> orderHistoryById(User u) {

		String jpql1 = "select c from Customer c left outer join fetch c.userCustomer where c.userCustomer.id=:us";
		Customer c = mgr.unwrap(Session.class).createQuery(jpql1, Customer.class).setParameter("us", u.getId())
				.getSingleResult();

		/// u.getuCustomer().getcOrders();
		Integer u1 = u.getId();
		String jpql = "select o from Orders o left outer join fetch o.oCustomer where o.oCustomer=:cs";
		return mgr.unwrap(Session.class).createQuery(jpql, Orders.class).setParameter("cs", c).getResultList();
	}

	@Override
	public Product getproductbyid(Integer pid) {
		String jpql = "select p from Product p where p.pId=:pid";
		return mgr.unwrap(Session.class).createQuery(jpql, Product.class).setParameter("pid", pid).getSingleResult();

	}

//	@Override
//	public Orders createneworder(Product p, Integer qty, Customer customer, Vendor vendor) {
//		Double ordertotal = (double) p.getpPrice() * (double) qty;
//		Date d = new Date();
//		Orders o = new Orders(new Date(d.getTime()), new Date(d.getTime()), "NOT_DELIVERED", ordertotal);
//		List<OrderDetails> odtls = new ArrayList<>();
//		OrderDetails orderdetails = new OrderDetails(qty);
//		orderdetails.setoId(o);
//		orderdetails.setPorder(p);
//		odtls.add(orderdetails);
//		o.setoCustomer(customer);
//		o.setoVendor(vendor);
//		o.setoDetails(odtls);
//		mgr.unwrap(Session.class).persist(o);
//		o.addorderdetails(orderdetails);
//		mgr.unwrap(Session.class).persist(orderdetails);
//		o.setOrderDate(o.getOrderDate());
//		return o;
//
//	}
	@Override
	public Orders createneworder(List<ProductHelper> plist, Customer customer, Vendor vendor,Integer finaltotal) {
	System.out.println("inside new order method");
		Double ordertotal = (double) finaltotal;
		Date d = new Date();
	
		//create new order
		Orders o = new Orders(new Date(d.getTime()), new Date(d.getTime()), "NOT_DELIVERED", ordertotal);
	
		List<OrderDetails> odtls = new ArrayList<>();
		for (ProductHelper ph1: plist) {
			OrderDetails orderdetails = new OrderDetails();
			System.out.println(ph1);
			orderdetails.setPqty(ph1.getPqty());
			orderdetails.setoId(o);
			Product p1=new Product(null,ph1.getpPrice(),null,null);
			p1.setpId(ph1.getpId());
			orderdetails.setPorder(p1);	
			odtls.add(orderdetails);
		}
		o.setoCustomer(customer);
		o.setoVendor(vendor);
		o.setoDetails(odtls);//list of order details
		
		mgr.unwrap(Session.class).persist(o);
		//add list of orders
		o.addorderdetails(odtls);

		for (OrderDetails orderDetail: odtls) {
			mgr.unwrap(Session.class).persist(orderDetail);
		}
		return o;

	}

	@Override
	public Customer getCustomerBycid(Integer customerId) {

		String jpql = "select c from Customer c  where c.cId=:cid";
		return mgr.unwrap(Session.class).createQuery(jpql, Customer.class).setParameter("cid", customerId)
				.getSingleResult();
	}

	@Override
	public Customer getCustomerById(Integer userId) {
		String jpql = "select c from Customer c left outer  join fetch  c.userCustomer where c.userCustomer.id=:uid";
		Customer c = mgr.unwrap(Session.class).createQuery(jpql, Customer.class).setParameter("uid", userId)
				.getSingleResult();
		return c;
	}
//apaymentdetails
//	@Override
//	public OrderDetails getOrderdeatils(Orders o) {
//	
//		String jpql = "select odt from OrderDetails odt where odt.oId=:o";
//		OrderDetails odtls = mgr.unwrap(Session.class).createQuery(jpql, OrderDetails.class).setParameter("o", o)
//				.getSingleResult();
//
//		
//		
//		return odtls;
//	}

	@Override
	public Payment getPaymentdetails(Orders o) {
		Payment pmt=new Payment(PaymentMode.COD);
		pmt.setpOrder(o);
		o.setoPayment(pmt);
		mgr.unwrap(Session.class).persist(pmt);
	return pmt;
	}
	@Override
	public User addcustomer(User u) {
		u.setRole(UserRole.CUSTOMER);
		mgr.unwrap(Session.class).persist(u);
		Customer v = new Customer();
		v.setUserCustomer(u);
		mgr.unwrap(Session.class).persist(v);
		return u;

	}



	
}
