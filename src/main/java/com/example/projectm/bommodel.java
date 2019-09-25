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
 

public class bommodel {

    private int bomid;
    private String createdDate;
    private String updatedDate;
    private String status;
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