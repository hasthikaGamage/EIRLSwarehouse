package com.example.projectm;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface deliveryRepo extends CrudRepository<delivery, String> {

    List<delivery> findAll();
    // delivery findByDeliveryId(int id);



 
    @Query("Select d from delivery d where delivery_status='delivered' ")
    List<delivery> deliveredItems();

    @Query("Select d from delivery d where delivery_id=:#{#id} ") 
    delivery findbydeliveredid(@Param("id")int id);
} 