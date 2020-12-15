package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String street;
	private String city;
	private String area;
	private String state;
	
	private int pinCode;
	
public Address() {
	// TODO Auto-generated constructor stub
}


	public Address(String street, String city, String area, String state, int pinCode) {
	super();
	this.street = street;
	this.city = city;
	this.area = area;
	this.state = state;
	this.pinCode = pinCode;
}


	@Column(nullable = false)
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	@Column(nullable = false)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(nullable = false)
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Column(nullable = false)
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	@Column(nullable = false)
	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", area=" + area + ", state=" + state + ", pinCode="
				+ pinCode + "]";
	}
	
	
}
