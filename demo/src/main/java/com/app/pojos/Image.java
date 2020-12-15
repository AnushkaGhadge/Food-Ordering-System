package com.app.pojos;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Image")
public class Image {
	
	
		private Integer imageID;
		private byte[] image;
		private Product product;
		public Image() {
			// TODO Auto-generated constructor stub
		}
		
		public Image(byte[] image) {
			super();
			this.image = image;
		}


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "ImageId")
		public Integer getImageID() {
			return imageID;
		}
		
		public void setImageID(Integer imageID) {
			this.imageID = imageID;
		}
		
		@Lob
		@Column(name = "Image")
		public byte[] getImage() {
			return image;
		}
		public void setImage(byte[] image) {
			this.image = image;
		}
		@OneToOne
		@JsonIgnore
		@JoinColumn(name="pId")
		public Product getProduct() {
			return product;
		}
		public void setProduct(Product product) {
			this.product = product;
		}

//		@OneToOne
//		@JsonIgnore
//		@JoinColumn(name="pId")
//		public Product getProduct() {
//			return product;
//		}
//		public void setProduct(Product product) {
//			this.product = product;
//		}
		
	
}
