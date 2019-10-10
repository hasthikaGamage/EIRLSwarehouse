
package com.example.projectm;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface  masterStockRepo extends CrudRepository<masterstock, String> {

    List<masterstock> findAll();
    masterstock findByProductName(String productname);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE masterstock m SET m.quantity= :#{#quantity}, m.quality=:#{#quality}  where m.productName=:#{#prodName}")
    void updateQuantity(@Param("prodName") String productName,@Param("quantity") int quantity, @Param("quality") String quanlity) ;

    List<masterstock> findByQuality(String quality);

}