package com.bocxy.ecom.repository;

import com.bocxy.ecom.model.DealerRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealerRegistrationRepository extends JpaRepository<DealerRegistrationEntity,Long> {
    @Query(value = "SELECT d.business_name FROM dealers d",nativeQuery = true)
    List<String> findAllBusinessName();

    @Query(value = "SELECT d.gstNumber FROM DealerRegistrationEntity d")
    List<String> findAllGSTNumber();
}
