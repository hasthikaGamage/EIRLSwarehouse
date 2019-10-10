package com.example.projectm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "delivery", schema ="0FebQ6JxGu")
public class delivery{


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "deliveryTable_id")
    private int deliveryTable_id;


	public int getDeliveryTable_id() {
		return this.deliveryTable_id;
	}

	public void setDeliveryTable_id(int deliveryTable_id) {
		this.deliveryTable_id = deliveryTable_id;
	}


	
    @Column(name = "user_id")
    private int delivery_id;

	public int getuser_id() {
		return this.delivery_id;
	}

	public void setuser_id(int delivery_id) {
		this.delivery_id = delivery_id;
	}

	


    @Column(name = "address")
    private String address;

	public String getaddress() {
		return this.address;
	}

	public void setaddress(String address) {
		this.address = address;
	}
 


	@Column(name = "delivery_status")
	private String delivery_status;

	public String getDelivery_status() {
		return this.delivery_status;
	}

	public void setDelivery_status(String delivery_status) {
		this.delivery_status = delivery_status;
	}
    
}