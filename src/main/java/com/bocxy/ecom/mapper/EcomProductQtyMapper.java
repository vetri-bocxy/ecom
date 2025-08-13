package com.bocxy.ecom.mapper;

import com.bocxy.ecom.DTO.EcomProductQtyResponseDTO;
import com.bocxy.ecom.createDTO.EcomProductQuantityDTO;
import com.bocxy.ecom.model.EcomProduct;
import com.bocxy.ecom.model.EcomProductQuantity;
import com.bocxy.ecom.repository.EcomProductQuantityRepository;
import com.bocxy.ecom.repository.EcomProductRepository;
import com.bocxy.ecom.updateDTO.EcomProductQtyUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EcomProductQtyMapper {

    @Autowired
    private EcomProductRepository ecomProductRepository;

    @Autowired
    private EcomProductQuantityRepository ecomProductQuantityRepository;

    public EcomProductQtyResponseDTO toDTO(EcomProductQuantity entity) {
        EcomProductQtyResponseDTO dto = new EcomProductQtyResponseDTO();
        dto.setProductId(entity.getEcomProduct() != null ? entity.getEcomProduct().getId() : null);
        dto.setAvailable(entity.getAvailable());
        dto.setSales(entity.getSales());
        dto.setAlertCount(entity.getAlertCount());
        dto.setStoreId(entity.getStoreId());
        dto.setQuantity(entity.getQuantity());
        dto.setFreeQuantity(entity.getFreeQuantity());
        dto.setProductName(entity.getEcomProduct().getProductName());
        dto.setUserId(entity.getUserId());
        return dto;
    }

    public EcomProductQuantity toEntity(EcomProductQuantityDTO dto) {

        EcomProduct product=ecomProductRepository.findById(dto.getProductId())
                .orElseThrow(()->new RuntimeException("Product Not found "+dto.getProductId()));

        EcomProductQuantity entity = new EcomProductQuantity();
        entity.setAvailable(dto.getAvailable());
        entity.setSales(dto.getSales());
        entity.setAlertCount(dto.getAlertCount());
        entity.setStoreId(dto.getStoreId());
        entity.setQuantity(dto.getQuantity());
        entity.setFreeQuantity(dto.getFreeQuantity());
        entity.setUserId(dto.getUserId());
        entity.setEcomProduct(product);

        return entity;
    }

    public EcomProductQuantity toEntity(EcomProductQtyUpdateDTO dto) {

        EcomProduct product=ecomProductRepository.findById(dto.getProductId())
                .orElseThrow(()->new RuntimeException("Product Not found "+dto.getProductId()));

        EcomProductQuantity entity = ecomProductQuantityRepository.findById(dto.getId())
                .orElseThrow(()->new RuntimeException("Product quantity not found "+dto.getId()));

        entity.setAvailable(dto.getAvailable());
        entity.setSales(dto.getSales());
        entity.setAlertCount(dto.getAlertCount());
        entity.setStoreId(dto.getStoreId());
        entity.setQuantity(dto.getQuantity());
        entity.setFreeQuantity(dto.getFreeQuantity());
        entity.setUserId(dto.getUserId());
        entity.setEcomProduct(product);

        return entity;
    }
}
