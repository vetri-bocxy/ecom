package com.bocxy.ecom.repository;

import com.bocxy.ecom.DTO.EcomProductDTO;
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

    @Query("SELECT DISTINCT p.productCategory FROM EcomProduct p WHERE p.status = :status")
    List<String> findDistinctProductCategoriesAndStatus(String status);

    @Query("SELECT DISTINCT p.productBrand FROM EcomProduct p WHERE p.status = :status")
    List<String> findDistinctProductBrandsAndStatus(String status);


    @Query("SELECT e FROM EcomProduct e WHERE e.projectName = :projectName AND e.storeId=:storeId")
    List<EcomProduct> findByProjectName(String projectName, String storeId);

    List<EcomProduct> findByUserIdAndProjectNameAndStatus(Long id, String projectName, String status);

//    String findByUserIdAndMonthYearAndProjectName(String userId, String monthAndYear, String projectName);

//    Long countByUserId(Long userId);

    @Query(value = "SELECT COUNT(*) " +
            "FROM ecom_product " +
            "WHERE (:userId IS NULL OR user_id = :userId)",
            nativeQuery = true)
    long findProductCount(@Param("userId") Long userId);

     long countByStatusAndUserId(String status,Long userId);

    @Query(value = "SELECT COUNT(*) FROM ecom_product " +
            "WHERE DATE_FORMAT(created_at, '%Y-%m') = DATE_FORMAT(CURDATE(), '%Y-%m') " +
            "AND (:userId IS NULL OR user_id = :userId)",
            nativeQuery = true)
    long findProductCountByMonthAndUser(@Param("userId") Long userId);

    @Query(value = "SELECT COUNT(*) FROM ecom_product " +
            "WHERE DATE_FORMAT(created_at, '%Y-%m') = DATE_FORMAT(CURDATE(), '%Y-%m') " +
            "AND (:userId IS NULL OR user_id = :userId)"+
            "AND status=:status",
            nativeQuery = true)
    long findProductCountByMonthAndUserAndStatus(@Param("userId") Long userId,String status);
}
