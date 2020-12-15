package com.app.pojos;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "users")
public class User {

	private Integer id;
	private String name;
	private String email;
	private String phoneNo;
	private String password,newpassword;
	private UserRole role;
	//@Embedded
	private Address address;
@JsonIgnore
	private Vendor uVendor;
@JsonIgnore
private Customer uCustomer;
@JsonIgnore	
private DeliveryBoy uDeliveryBoy;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length = 100 ,nullable = false)

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(unique = true,nullable = false)	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Column(unique = true,nullable = false)
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	@Column(nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "user_role",nullable = false)
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}

	
	
	
	
	@Embedded
	public Address getAddress() {
		return address;
	}

	
	public void setAddress(Address address) {
		this.address = address;
	}

	@OneToOne(mappedBy = "userVendor",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
	public Vendor getuVendor() {
		return uVendor;
	}
	public void setuVendor(Vendor uVendor) {
		this.uVendor = uVendor;
	}
	
	@OneToOne(mappedBy = "userCustomer",cascade = CascadeType.ALL,orphanRemoval = true)
	public Customer getuCustomer() {
		return uCustomer;
	}
	public void setuCustomer(Customer uCustomer) {
		this.uCustomer = uCustomer;
	}
	
	@OneToOne(mappedBy = "userDeliveryBoy",cascade = CascadeType.ALL,orphanRemoval = true)
	public DeliveryBoy getuDeliveryBoy() {
		return uDeliveryBoy;
	}
	public void setuDeliveryBoy(DeliveryBoy uDeliveryBoy) {
		this.uDeliveryBoy = uDeliveryBoy;
	}
	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + ", role="
				+ role + "]";
	}
	@Transient
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}



}
