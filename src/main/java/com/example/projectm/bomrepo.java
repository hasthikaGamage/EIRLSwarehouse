package com.example.projectm;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface bomrepo extends CrudRepository<bom, String> {

    List<bom> findAll();
    
}