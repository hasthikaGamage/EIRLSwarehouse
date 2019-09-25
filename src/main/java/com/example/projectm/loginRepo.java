
package com.example.projectm;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface  loginRepo extends CrudRepository<User, String> {

    List<User> findAll();   
    User findByUsername(String username);


}