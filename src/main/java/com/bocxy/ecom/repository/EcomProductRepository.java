package com.bocxy.ecom.repository;

import com.bocxy.ecom.model.EcomProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EcomProductRepository extends JpaRepository<EcomProduct,Long> {

    Optional<EcomProduct> findByProductId(String productId);

    boolean existsByProductId(String productId);

    List<EcomProduct> findByStatus(String status);


    @Query("SELECT s FROM EcomProduct s WHERE s.user.id IN :id")
    List<EcomProduct> findByUserId(@Param("id") Long id);

    @Query("SELECT e FROM EcomProduct e WHERE e.user.id = :id AND e.projectName = :projectName")
    List<EcomProduct> findByUserIdAndProjectName(Long id, String projectName);

}
