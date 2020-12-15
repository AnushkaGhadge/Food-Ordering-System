package com.app.pojos;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customer")
public class Customer {
public Customer() {
super();
}
private Integer cId;
private User userCustomer;
@JsonIgnore
private List<Orders> cOrders;  //one to many
private Feedback cFb;        //one to one

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer getcId() {
	return cId;
}
public void setcId(Integer cId) {
	this.cId = cId;
}
@OneToMany(mappedBy = "oCustomer",cascade = CascadeType.ALL,orphanRemoval = true)
public List<Orders> getcOrders() {
	return cOrders;
}
public void setcOrders(List<Orders> cOrders) {
	this.cOrders = cOrders;
}

@OneToOne(mappedBy = "fCust",cascade = CascadeType.ALL,orphanRemoval = true)
public Feedback getcFb() {
	return cFb;
}
public void setcFb(Feedback cFb) {
	this.cFb = cFb;
}
@OneToOne
@JoinColumn(name="uc")
public User getUserCustomer() {
	return userCustomer;
}
public void setUserCustomer(User userCustomer) {
	this.userCustomer = userCustomer;
}
@Override
public String toString() {
	return "Customer [cId=" + cId + "]";
}
}



