package com.example.projectm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "return_products", schema ="0FebQ6JxGu")
public class return_products{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "return_productsid")
    private int return_productsid;

	public int getReturn_productsid() {
		return this.return_productsid;
	}

	public void setReturn_productsid(int return_productsid) {
		this.return_productsid = return_productsid;
	}


    @Column(name = "product_name")
    private String product_name;

	public String getProduct_name() {
		return this.product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}








}