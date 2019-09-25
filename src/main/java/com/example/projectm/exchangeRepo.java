package com.example.projectm;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface exchangeRepo extends CrudRepository<exchange, String> {

    List<exchange> findAll();
    



 
   
} 