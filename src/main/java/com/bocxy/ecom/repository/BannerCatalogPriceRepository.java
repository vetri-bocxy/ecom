package com.bocxy.ecom.repository;

import com.bocxy.ecom.model.BannerCatalogPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerCatalogPriceRepository extends JpaRepository<BannerCatalogPrice,Long> {
    BannerCatalogPrice findByCreatedById(Long id);

}
