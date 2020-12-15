package com.app.pojos;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "deliveryboy")
public class DeliveryBoy {
	private Integer dId;

	private DBoy dStatus; //can use Enum here 
//	private OrderStatus odStatus;

	@JsonIgnore
	private User userDeliveryBoy;
	@JsonIgnore
	private Orders odId;

	public DeliveryBoy() {
		// TODO Auto-generated constructor stub
	}

	public DeliveryBoy(DBoy dStatus) {
		super();
		this.dStatus = dStatus;
//		this.odStatus = odStatus;
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getdId() {
		return dId;
	}

	public void setdId(Integer dId) {
		this.dId = dId;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "dboystatus")
	public DBoy getdStatus() {
		return dStatus;
	}

	public void setdStatus(DBoy dStatus) {
		this.dStatus = dStatus;
	}


//	@Enumerated(EnumType.STRING)
//	@Column(name = "orderstatus")
//	public OrderStatus getOdStatus() {
//		return odStatus;
//	}
//
//	public void setOdStatus(OrderStatus odStatus) {
//		this.odStatus = odStatus;
//	}

	@OneToOne
	@JoinColumn(name = "odrId")
	public Orders getOdId() {
		return odId;
	}

	public void setOdId(Orders odId) {
		this.odId = odId;
	}

	@OneToOne
	@JoinColumn(name="udb")
	public User getUserDeliveryBoy() {
		return userDeliveryBoy;
	}

	public void setUserDeliveryBoy(User userDeliveryBoy) {
		this.userDeliveryBoy = userDeliveryBoy;
	}

	@Override
	public String toString() {
		return "DeliveryBoy [dId=" + dId + ", dStatus=" + dStatus + "]";
	}

	


}
