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
@Table(name = "bom")
public class bom {

    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bomid")
    private int bomid;

	public int getBomid() {
		return this.bomid;
	}

	public void setBomid(int bomid) {
		this.bomid = bomid;
	}

    @Column(name="createdDate")
    private String createdDate;
    @Column(name="updatedDate")
    private String updatedDate;
    @Column(name="status")
    private String status;


	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    @Column(name="orderItemid")
    private int orderItemid;



    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public int getOrderItemid() {
        return orderItemid;
    }

    public void setOrderItemid(int orderItemid) {
        this.orderItemid = orderItemid;
    }
}