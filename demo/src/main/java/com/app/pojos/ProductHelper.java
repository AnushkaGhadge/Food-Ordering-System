package com.app.pojos;

public class ProductHelper {

	private Integer pId;
	private float pPrice;
private Integer pqty;

public ProductHelper() {
	// TODO Auto-generated constructor stub
}

public ProductHelper(Integer pId, float pPrice, Integer pqty) {
	super();
	this.pId = pId;
	this.pPrice = pPrice;
	this.pqty = pqty;
}

public Integer getpId() {
	return pId;
}

public void setpId(Integer pId) {
	this.pId = pId;
}

public float getpPrice() {
	return pPrice;
}

public void setpPrice(float pPrice) {
	this.pPrice = pPrice;
}

public Integer getPqty() {
	return pqty;
}

public void setPqty(Integer pqty) {
	this.pqty = pqty;
}

@Override
public String toString() {
	return "ProductHelper [pId=" + pId + ", pPrice=" + pPrice + ", pqty=" + pqty + "]";
}

	

}
