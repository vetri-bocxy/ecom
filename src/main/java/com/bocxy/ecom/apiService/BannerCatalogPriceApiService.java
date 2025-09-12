package com.bocxy.ecom.apiService;

import com.bocxy.ecom.DTO.BannerCatalogPriceDTO;
import com.bocxy.ecom.createDTO.BannerCatalogPriceCreateDTO;
import com.bocxy.ecom.mapper.BannerCatalogPriceMapper;
import com.bocxy.ecom.service.BannerCatalogPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerCatalogPriceApiService {
    @Autowired
    BannerCatalogPriceService bcpService;
    @Autowired
    BannerCatalogPriceMapper bcpMapper;

    public String create(BannerCatalogPriceCreateDTO dto) {
        return bcpService.create(bcpMapper.toEntity(dto));
    }

    public BannerCatalogPriceDTO get(Long id) {
        return bcpService.get(id);
    }

    public List<BannerCatalogPriceDTO> getAll() {
        return bcpService.getAll();
    }

    public String delete(Long id) {
        return bcpService.delete(id);
    }

    public BannerCatalogPriceDTO getByUserId(Long id) {
        return bcpService.getByUserId(id);
    }
}
