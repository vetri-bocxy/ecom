package com.bocxy.ecom.mapper;

import com.bocxy.ecom.DTO.EcomProductDTO;
import com.bocxy.ecom.createDTO.EcomProductCreateDTO;
import com.bocxy.ecom.createDTO.EcomStatusDTO;
import com.bocxy.ecom.model.EcomProduct;
import com.bocxy.ecom.repository.EcomProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class EcomStatusMapper {

    @Autowired
    private EcomProductRepository ecomProductRepository;

    public EcomProductDTO toDTO(EcomProduct product) {
        EcomProductDTO dto = new EcomProductDTO();
        dto.setId(product.getId());
        dto.setProductId(product.getProductId());
        dto.setProjectName(product.getProjectName());
        dto.setProductName(product.getProductName());
        dto.setProductCategory(product.getProductCategory());
        dto.setProductType(product.getProductType());
        dto.setProductFormulation(product.getProductFormulation());
        dto.setDiscountPrice(product.getDiscountPrice());
        dto.setMrpPrice(product.getMrpPrice());
        dto.setDescription(product.getDescription());
        dto.setGstPercentage(product.getGstPercentage());
        dto.setDetails(product.getDetails());
        dto.setGender(product.getGender());
        dto.setProductBrand(product.getProductBrand());
        dto.setProductImageUrl(product.getProductImageUrl());
        dto.setStoreId(product.getStoreId());
        dto.setCreatedAt(product.getCreatedAtIST());
        dto.setUpdatedAt(product.getUpdatedAtIST());
        return dto;
    }

    public EcomProduct toEntityApprove(EcomStatusDTO dto) {
        EcomProduct product = ecomProductRepository.findById(dto.getId())
                .orElseThrow(()->new RuntimeException("Product Not found  "+dto.getId()));

        product.setProductId(dto.getProductId());
        product.setProjectName(dto.getProjectName());
        product.setProductName(dto.getProductName());
        product.setRejectRemarks(dto.getRejectRemarks());
        product.setId(dto.getId());
        product.setStatus(dto.getStatus());
        return product;
    }



    public EcomProduct toEntityReject(EcomStatusDTO dto) {
        EcomProduct product = ecomProductRepository.findById(dto.getId())
                .orElseThrow(()->new RuntimeException("Product Not found  "+dto.getId()));

        product.setProductId(dto.getProductId());
        product.setProjectName(dto.getProjectName());
        product.setProductName(dto.getProductName());
        product.setRejectRemarks(dto.getRejectRemarks());
        product.setId(dto.getId());
        product.setStatus(dto.getStatus());
        return product;
    }


}
