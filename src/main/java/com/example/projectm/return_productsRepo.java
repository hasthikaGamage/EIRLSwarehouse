package com.example.projectm;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface  return_productsRepo extends CrudRepository<return_products, String> {

    List<return_products> findAll();

}