package com.example.projectm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



public class return_note_model{ 

   
    private int return_noteid;

	public int getReturn_noteid() {
		return this.return_noteid;
	}

	public void setReturn_noteid(int return_noteid) {
		this.return_noteid = return_noteid;
	}


   
    private String customer_name;

	public String getCustomer_name() {
		return this.customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}


   
    private String telephone;

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


   
    private String product_name;

	public String getProduct_name() {
		return this.product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}


    
    private String description;

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


    
    private String status;

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
    }
    
    private String date;

	public String getDate() {
		return this.date;
    }
    public void setDate(String date) {
		this.date = date;
	}






}