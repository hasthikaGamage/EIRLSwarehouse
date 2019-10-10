package com.example.projectm;

import javax.persistence.*;
import java.util.Set; 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "msr")
public class masterstock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="binID")
    private int binID;

	public int getBinID() {
		return this.binID;
	}

	public void setBinID(int binID) {
		this.binID = binID;
	}

 
	@Column(name="status")
    private String status;
	@Column(name="suppplierName")
    private String suppplierName;   
	@Column(name="productName")
    private String productName;
    @Column(name="quantity")
    private int quantity;
    @Column(name="quality")
    private String quality;

    public String getQuality() {
        return this.quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
        
	


    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSuppplierName() {
        return suppplierName;
    }

    public void setSuppplierName(String suppplierName) {
        this.suppplierName = suppplierName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
