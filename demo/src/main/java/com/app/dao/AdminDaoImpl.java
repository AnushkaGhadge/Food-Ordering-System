package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.app.pojos.DBoy;
import com.app.pojos.DeliveryBoy;
import com.app.pojos.Orders;
import com.app.pojos.User;
import com.app.pojos.UserRole;
import com.app.pojos.Vendor;

@Repository
public class AdminDaoImpl implements IAdminDao {
	@PersistenceContext
	private EntityManager mgr;
	
	@Override
	public List<User> listallusers() {
		String jpql = "select u from User u";
		return mgr.unwrap(Session.class).createQuery(jpql, User.class).getResultList();
	}

	@Override
	public List<Orders> viewAllOrderHistorty() {
		// String jpql="select o from Orders o Left outer join fetch o.oVendor";

		String jpql = "select o from Orders o where o.oStatus=:status ";
		return mgr.unwrap(Session.class).createQuery(jpql, Orders.class).setParameter("status", "DELIVERED")
				.getResultList();

	}

	@Override
	public List<DeliveryBoy> viewAllDeliveryBoy() {

		String jpql1 = "select d from DeliveryBoy d where d.dStatus=:status";
		List<DeliveryBoy> d1 = (List<DeliveryBoy>) mgr.unwrap(Session.class).createQuery(jpql1, DeliveryBoy.class)
				.setParameter("status", DBoy.AVAILABLE).getResultList();
		System.out.println(d1);
		return d1;
	}

	@Override
	public User addDB(User u) {
		mgr.unwrap(Session.class).persist(u);
		DeliveryBoy db = new DeliveryBoy(DBoy.AVAILABLE);
		db.setUserDeliveryBoy(u);
		mgr.unwrap(Session.class).persist(db);

		return u;
	}

	@Override
	public Vendor addVendor(User u, String rname) {
		u.setRole(UserRole.VENDOR);
		mgr.unwrap(Session.class).persist(u);
		Vendor v = new Vendor();
		v.setvRestaurant(rname);
		v.setUserVendor(u);
		mgr.unwrap(Session.class).persist(v);
		return v;
	}

	@Override
	public DeliveryBoy assigndb(Integer orderid) {
		String jpql = "select o from Orders o where o.id=:id and o.oStatus=:ostatus";
		Orders o = mgr.unwrap(Session.class).createQuery(jpql, Orders.class).setParameter("id", orderid)
				.setParameter("ostatus", "NOT_DELIVERED").getSingleResult();
		String jpql1 = "select db from DeliveryBoy db where db.dStatus=:o ";
		List<DeliveryBoy> db1 = mgr.unwrap(Session.class).createQuery(jpql1, DeliveryBoy.class)
				.setParameter("o", DBoy.AVAILABLE).getResultList();
		DeliveryBoy first_db = db1.get(0);

		first_db.setOdId(o);
		first_db.setdStatus(DBoy.NOTAVAILABLE);
		mgr.unwrap(Session.class).persist(first_db);
		return first_db;
	}

	@Override
	public List<Orders> listpendingorder() {
		String jpql = "select o from Orders o where o.oStatus=:status ";
		return mgr.unwrap(Session.class).createQuery(jpql, Orders.class).setParameter("status", "NOT_DELIVERED")
				.getResultList();
	}

	@Override
	public Vendor addimagetovendor(Vendor v) {
		
		mgr.unwrap(Session.class).update(v);
		return v;
	}

}