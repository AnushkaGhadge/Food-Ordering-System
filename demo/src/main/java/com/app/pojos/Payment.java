package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "payment")
public class Payment {

private Integer pId;
private PaymentMode  pMode;
@JsonIgnore
private Orders pOrder;

public Payment() {
	// TODO Auto-generated constructor stub
}

public Payment(PaymentMode pMode) {
	super();
	this.pMode = pMode;
}



@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer getpId() {
	return pId;
}
public void setpId(Integer pId) {
	this.pId = pId;
}
@Enumerated(EnumType.STRING)
@Column(name = "paymentmode")
public PaymentMode getpMode() {
	return pMode;
}
public void setpMode(PaymentMode pMode) {
	this.pMode = pMode;
}

@OneToOne
@JoinColumn(name = "orderId")
public Orders getpOrder() {
	return pOrder;
}
public void setpOrder(Orders pOrder) {
	this.pOrder = pOrder;
}

@Override
public String toString() {
	return "Payment [pId=" + pId + ", pMode=" + pMode + "]";
}



}
