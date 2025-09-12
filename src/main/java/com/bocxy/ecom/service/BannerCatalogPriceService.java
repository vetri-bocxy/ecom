package com.bocxy.ecom.service;

import com.bocxy.ecom.DTO.BannerCatalogPriceDTO;
import com.bocxy.ecom.mapper.BannerCatalogPriceMapper;
import com.bocxy.ecom.model.BannerCatalogPrice;
import com.bocxy.ecom.repository.BannerCatalogPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerCatalogPriceService {

    @Autowired
    BannerCatalogPriceRepository bcpRepository;
    @Autowired
    BannerCatalogPriceMapper bcpMapper;

    public String create(BannerCatalogPrice entity) {
        bcpRepository.save(entity);
        return "Banner Catalog Created";
    }

    public BannerCatalogPriceDTO get(Long id) {
        return bcpMapper.toDTO(bcpRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Banner Catalog not found for this id "+id)));
    }

    public List<BannerCatalogPriceDTO> getAll() {
        return bcpRepository.findAll().stream().map(bcpMapper::toDTO).toList();
    }

    public String delete(Long id) {
        bcpRepository.deleteById(id);
        return "Banner Catalog Deleted";
    }

    public BannerCatalogPriceDTO getByUserId(Long id) {
        return bcpMapper.toDTO(bcpRepository.findByCreatedById(id));
    }
}
