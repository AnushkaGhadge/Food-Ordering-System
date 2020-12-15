package com.app.pojos;

import java.util.Arrays;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.mail.handlers.image_gif;



@Entity
@Table(name = "product")
public class Product {
private Integer pId;
private String pName;
private float pPrice;



private Image image;
private Pcategory vegnonveg;
private CuisineType cType;
//@JsonIgnore
private Vendor pVendor;

public Product() {
	// TODO Auto-generated constructor stub
}



public Product(String pName, float pPrice, Pcategory vegnonveg, CuisineType cType) {
	super();
	this.pName = pName;
	this.pPrice = pPrice;
	
	this.vegnonveg = vegnonveg;
	this.cType = cType;
}



@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer getpId() {
	return pId;
}

public void setpId(Integer pId) {
	this.pId = pId;
}

public String getpName() {
	return pName;
}

public void setpName(String pName) {
	this.pName = pName;
}

public float getpPrice() {
	return pPrice;
}

public void setpPrice(float pPrice) {
	this.pPrice = pPrice;
}



@Enumerated(EnumType.STRING)
public Pcategory getVegnonveg() {
	return vegnonveg;
}

public void setVegnonveg(Pcategory vegnonveg) {
	this.vegnonveg = vegnonveg;
}


@ManyToOne()
@JoinColumn(name = "pVendor")
public Vendor getpVendor() {
	return pVendor;
}

public void setpVendor(Vendor pVendor) {
	this.pVendor = pVendor;
}

@Lob
@OneToOne(mappedBy = "product",fetch = FetchType.EAGER,orphanRemoval = true,cascade = CascadeType.ALL)
public Image getImage() {
	return image;
}
public void setImage(Image image) {
	this.image = image;
}

//@OneToMany(mappedBy = "plist",cascade = CascadeType.ALL,orphanRemoval = true)
//public OrderDetails getpOrderDetails() {
//	return pOrderDetails;
//}
//
//public void setpOrderDetails(OrderDetails pOrderDetails) {
//	this.pOrderDetails = pOrderDetails;
//}
@Enumerated(EnumType.STRING)
public CuisineType getcType() {
	return cType;
}

public void setcType(CuisineType cType) {
	this.cType = cType;
}



public void addImage(Image a)
{
	this.image=a;
a.setProduct(this);
}
public void removeImage(Image a)
{
	this.image=null;
	a.setProduct(null);
}
@Override
public String toString() {
	return "Product [pId=" + pId + ", pName=" + pName + ", pPrice=" + pPrice 
			+ ", vegnonveg=" + vegnonveg + ", cType=" + cType + "]";
}



}
