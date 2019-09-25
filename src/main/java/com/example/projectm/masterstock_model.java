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


public class masterstock_model {

    private int binID;

	public int getBinID() {
		return this.binID;
	}

	public void setBinID(int binID) {
		this.binID = binID;
	}

 
    private String status;
    private String suppplierName;
    private String productName;
    private int quantity;
     private String quanlity;

	public String getQuanlity() {
		return this.quanlity;
	}

	public void setQuanlity(String quanlity) {
		this.quanlity = quanlity;
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
