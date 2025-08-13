package com.bocxy.ecom.repository;

import com.bocxy.ecom.model.BannerUploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerUploadRepository extends JpaRepository<BannerUploadEntity,Long> {
}
