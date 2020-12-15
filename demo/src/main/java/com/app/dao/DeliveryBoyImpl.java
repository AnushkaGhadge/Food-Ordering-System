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

@Repository
public class DeliveryBoyImpl implements IDeliveryBoy {
	@PersistenceContext
	private EntityManager mgr;
	
	@Override
	public List<DeliveryBoy> viewAllOrderHistorty(int uid) {
		
//		String jpql="select u from User u left outer join  on d.userDeliveryBoy.id=:id1"; //where o.oDeliveryBoy=:id1
		
		
		
		String jpql2="select d from User d where d.id=:id1";  //and d.dStatus=:sts";
		User u1=mgr.unwrap(Session.class).createQuery(jpql2, User.class).setParameter("id1",uid).getSingleResult();
		String jpql="select d from DeliveryBoy d  where d.userDeliveryBoy=:u1 and  d.dStatus=:sts"; //where o.oDeliveryBoy=:id1	
		List<DeliveryBoy> dlist=mgr.unwrap(Session.class).createQuery(jpql, DeliveryBoy.class).setParameter("sts",DBoy.NOTAVAILABLE).setParameter("u1",u1 ).getResultList();
		System.out.println(dlist);
	
//		String jpql1="select d from DeliveryBoy d  left outer join fetch d.userDeliveryBoy  where  d.userDeliveryBoy.id=:id1  and d.dStatus=:sts";
//		
//		List<DeliveryBoy> dlist=mgr.unwrap(Session.class).createQuery(jpql1, DeliveryBoy.class).setParameter("sts",DBoy.NOTAVAILABLE).setParameter("id1",uid).getResultList();
//		System.out.println(dlist);
//		
		return dlist;
	//	return mgr.unwrap(Session.class).createQuery(jpql,Orders.class).setParameter("id1", uid).getResultList();
}
	
	@Override
	public Orders viewAllNewOrders(Integer uid) {
		String jpql1="select d from DeliveryBoy d left outer join fetch d.userDeliveryBoy where d.userDeliveryBoy.id=:uid";
		DeliveryBoy d=mgr.unwrap(Session.class).createQuery(jpql1,DeliveryBoy.class).setParameter("uid", uid).getSingleResult();

		String jpql="select o from Orders o left outer  join fetch o.oDeliveryBoy where o.oDeliveryBoy.dId=:db and o.oDeliveryBoy.dStatus=:sts";
		return mgr.unwrap(Session.class).createQuery(jpql,Orders.class).setParameter("db",d.getdId()).setParameter("sts",DBoy.NOTAVAILABLE).getSingleResult();
	}

	@Override
	public Orders changeorderstatus(Integer orderid, Integer userid) {
		
		String jpql="select o from Orders o where o.id=:id and o.oStatus=:ostatus";
		Orders o = mgr.unwrap(Session.class).createQuery(jpql,Orders.class).setParameter("id", orderid).setParameter("ostatus","NOT_DELIVERED").getSingleResult();
		o.setoStatus("DELIVERED");
		mgr.unwrap(Session.class).update(o);
		
		String jpql1="select u from User u where u.id=:id";
		User u1 = mgr.unwrap(Session.class).createQuery(jpql1,User.class).setParameter("id", userid).getSingleResult();
	
		String jpql2="select db from DeliveryBoy db where db.userDeliveryBoy=:u ";
		DeliveryBoy db1 = mgr.unwrap(Session.class).createQuery(jpql2,DeliveryBoy.class).setParameter("u",u1).getSingleResult();

		db1.setdStatus(DBoy.AVAILABLE);
		db1.setOdId(null);
//
//		DeliveryBoy  db123=new DeliveryBoy();
//	    db123.setdStatus(DBoy.AVAILABLE);
//		db123.setUserDeliveryBoy(u1);
//		mgr.unwrap(Session.class).persist(db123);
//		
		
		mgr.unwrap(Session.class).update(db1);
		return o;
	}
	
//	@Override
//	public Orders listdborderbyuid(Integer userid) {
//		String jpql1="select u from User u where u.id=:id";
//		User u1 = mgr.unwrap(Session.class).createQuery(jpql1,User.class).setParameter("id", userid).getSingleResult();
//	
//		String jpql2="select db from DeliveryBoy db where db.userDeliveryBoy=:u and db.dStatus=:sts";
//		DeliveryBoy db1 = mgr.unwrap(Session.class).createQuery(jpql2,DeliveryBoy.class).setParameter("sts",DBoy.NOTAVAILABLE).setParameter("u",u1).getSingleResult();
//		
//		Orders od = db1.getOdId();
//	
//		String jpql3="select o from Orders o where o.id=:did";
//		Orders o=mgr.unwrap(Session.class).createQuery(jpql3,Orders.class).setParameter("did",od.getId()).getSingleResult();
//		
//		
//		
//		return o;
//	}
//	
//	@Override
//	public DeliveryBoy getDbById(Integer userId) {
//		String jpql="select db from DeliveryBoy db left outer  join fetch  db.userDeliveryBoy where c.userDeliveryBoy.id=:uid";
//		DeliveryBoy c=mgr.unwrap(Session.class).createQuery(jpql, DeliveryBoy.class).setParameter("uid",userId).getSingleResult();
//		return c;
//	}

	
	
}