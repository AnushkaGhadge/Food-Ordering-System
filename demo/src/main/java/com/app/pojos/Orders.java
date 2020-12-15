package com.app.pojos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "orders")
public class Orders {

	private Integer id;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "IST")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date orderDate;
	@JsonFormat(pattern = "HH:mm",timezone = "IST")
	@DateTimeFormat(pattern = "HH:mm ")
	private Date orderTime;
	private String oStatus;
	private Vendor oVendor; //manytoOne
	//@JsonIgnore	
	private Customer oCustomer;//manytoone
	private DeliveryBoy oDeliveryBoy;//one to one
	private Payment oPayment;//one to one
	@JsonIgnore
	private List<OrderDetails> oDetails;//one to many
	private Double orderTotal;
	public Orders() {
		// TODO Auto-generated constructor stub
	}
	public Orders(Date orderDate, Date orderTime, String oStatus, Double orderTotal) {
		super();
		this.orderDate = orderDate;
		this.orderTime = orderTime;
		this.oStatus = oStatus;
		this.orderTotal = orderTotal;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "orderdate")
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getoStatus() {
		return oStatus;
	}

	public void setoStatus(String oStatus) {
		this.oStatus = oStatus;
	}

	@ManyToOne
	@JoinColumn(name = "vendorId")
	public Vendor getoVendor() {
		return oVendor;
	}

	public void setoVendor(Vendor oVendor) {
		this.oVendor = oVendor;
	}

	@ManyToOne
	@JoinColumn(name = "customerId")
	public Customer getoCustomer() {
		return oCustomer;
	}

	public void setoCustomer(Customer oCustomer) {
		this.oCustomer = oCustomer;
	}
	@OneToOne(mappedBy ="odId",cascade = CascadeType.ALL,orphanRemoval = true)
	public DeliveryBoy getoDeliveryBoy() {
		return oDeliveryBoy;
	}

	public void setoDeliveryBoy(DeliveryBoy oDeliveryBoy) {
		this.oDeliveryBoy = oDeliveryBoy;
	}

	@OneToOne(mappedBy = "pOrder",cascade = CascadeType.ALL,orphanRemoval = true)
	public Payment getoPayment() {
		return oPayment;
	}
	public void setoPayment(Payment oPayment) {
		this.oPayment = oPayment;
	}
	@OneToMany(mappedBy = "orderId",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<OrderDetails> getoDetails() {
		return oDetails;
	}
	public void setoDetails(List<OrderDetails> oDetails) {
		this.oDetails = oDetails;
	}
	

	public Double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ordertime")
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
//	public void addorderdetails(OrderDetails odls) {	
//		oDetails.add(odls);
//		odls.setoId(this);
//		
//	}
	public void addorderdetails(List <OrderDetails> odls) {	
		oDetails=odls;
		for (OrderDetails orderDetails : odls) {
		orderDetails.setoId(this);
		}
	}
	
	
	@Override
	public String toString() {
		return "Orders [id=" + id + ", orderDate=" + orderDate + ", orderTime=" + orderTime + ", oStatus=" + oStatus
				+ ", orderTotal=" + orderTotal + "]";
	}	
}
