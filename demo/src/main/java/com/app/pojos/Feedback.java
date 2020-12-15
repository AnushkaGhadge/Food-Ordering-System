package com.app.pojos;

import javax.persistence.*;

import org.hibernate.validator.constraints.Range;


@Entity
@Table(name = "vendorfeedback")
public class Feedback {

	private Integer fId;
	private String fDesc;
	private int fRestRating;//frestaurant rating
	private Vendor fVendor;
	private Customer fCust;
	public Feedback() {
		// TODO Auto-generated constructor stub
	}
	public Feedback(String fDesc, int fRestRating) {
		super();
		this.fDesc = fDesc;
		this.fRestRating = fRestRating;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getfId() {
		return fId;
	}
	public void setfId(Integer fId) {
		this.fId = fId;
	}
	
	public String getfDesc() {
		return fDesc;
	}
	public void setfDesc(String fDesc) {
		this.fDesc = fDesc;
	}
	
	@Range(min = 1,max =5)
	public int getfRestRating() {
		return fRestRating;
	}
	public void setfRestRating(int fRestRating) {
		this.fRestRating = fRestRating;
	}
	
	@ManyToOne
	@JoinColumn(name = "fvendor")
	public Vendor getfVendor() {
		return fVendor;
	}
	public void setfVendor(Vendor fVendor) {
		this.fVendor = fVendor;
	}
	
	@OneToOne
	@JoinColumn(name = "fcust")
	public Customer getfCust() {
		return fCust;
	}
	public void setfCust(Customer fCust) {
		this.fCust = fCust;
	}
	
}
