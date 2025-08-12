package com.bocxy.ecom.repository;

import com.bocxy.ecom.model.EcomProductQuantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EcomProductQuantityRepository extends JpaRepository<EcomProductQuantity,Long> {


    @Query("SELECT s FROM EcomProductQuantity s WHERE userId IN :id")
    List<EcomProductQuantity> findByUserId(String id);
}
