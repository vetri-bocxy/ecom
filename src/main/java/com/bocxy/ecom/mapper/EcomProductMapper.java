package com.bocxy.ecom.mapper;

import com.bocxy.ecom.DTO.EcomProductDTO;
import com.bocxy.ecom.createDTO.EcomProductCreateDTO;
import com.bocxy.ecom.model.EcomProduct;
import com.bocxy.ecom.repository.EcomProductRepository;
import com.bocxy.ecom.repository.UserRepository;
import com.bocxy.ecom.updateDTO.EcomProductUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EcomProductMapper {

    @Autowired
    UserRepository userRepository;
    @Autowired
    EcomProductRepository productRepository;


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
        dto.setSellerPrice(product.getSellerPrice());
        dto.setPlatformPrice(product.getPlatformPrice());
        dto.setAdminDiscountPrice(product.getAdminDiscountPrice());
        dto.setAdminDiscount(product.getAdminDiscount());
        dto.setAvailableQuantity(product.getAvailableQuantity());
        dto.setTotalQuantity(product.getTotalQuantity());
        dto.setMrpPrice(product.getMrpPrice());
        dto.setDescription(product.getDescription());
        dto.setGstPercentage(product.getGstPercentage());
        dto.setDetails(product.getDetails());
        dto.setGender(product.getGender());
        dto.setHowToUse(product.getHowToUse());
        dto.setKeyBenefits(product.getKeyBenefits());
        dto.setOtherInformation(product.getOtherInformation());
        dto.setProductBrand(product.getProductBrand());
        dto.setProductImageUrl(product.getProductImageUrl());
        dto.setStoreId(product.getStoreId());
        dto.setCreatedAt(product.getCreatedAtIST());
        dto.setUpdatedAt(product.getUpdatedAtIST());
        dto.setStatus(product.getStatus());
        return dto;
    }

    public EcomProduct toEntity(EcomProductCreateDTO dto) {

        EcomProduct product = new EcomProduct();

        // Set productId if present
        if (dto.getProductId() != null) {
            product.setProductId(dto.getProductId());
        }

        // Map all fields
        product.setProjectName(dto.getProjectName());
        product.setProductName(dto.getProductName());
        product.setProductCategory(dto.getProductCategory());
        product.setProductType(dto.getProductType());
        product.setProductFormulation(dto.getProductFormulation());
        product.setDiscountPrice(dto.getDiscountPrice());
        product.setSellerPrice(dto.getSellerPrice());
        product.setPlatformPrice(dto.getPlatformPrice());
        product.setAdminDiscountPrice(dto.getAdminDiscountPrice());
        product.setAdminDiscount(dto.getAdminDiscount());
        product.setAvailableQuantity(dto.getAvailableQuantity());
        product.setTotalQuantity(dto.getTotalQuantity());
        product.setMrpPrice(dto.getMrpPrice());
        product.setDescription(dto.getDescription());
        product.setGstPercentage("18");
        product.setDetails(dto.getDetails());
        product.setHowToUse(dto.getHowToUse());
        product.setKeyBenefits(dto.getKeyBenefits());
        product.setOtherInformation(dto.getOtherInformation());
        product.setGender(dto.getGender());
        product.setProductBrand(dto.getProductBrand());
        product.setProductImageUrl(dto.getProductImageUrl());
        product.setStoreId(dto.getStoreId());
        product.setStatus("pending");

        // Only fetch and set user if userId is provided
        if (dto.getUserId() != null) {
            userRepository.findById(dto.getUserId())
                    .ifPresent(product::setUser);
        }

        return product;
    }

    public EcomProduct toEntity(EcomProductUpdateDTO dto) {
        EcomProduct product=productRepository.findById(dto.getId())
                .orElseThrow(()->new RuntimeException("Product not found for this id "+dto.getId()));


        product.setProjectName(dto.getProjectName());
        product.setProductName(dto.getProductName());
        product.setProductCategory(dto.getProductCategory());
        product.setProductType(dto.getProductType());
        product.setProductFormulation(dto.getProductFormulation());
        product.setDiscountPrice(dto.getDiscountPrice());
        product.setSellerPrice(dto.getSellerPrice());
        product.setPlatformPrice(dto.getPlatformPrice());
        product.setAdminDiscountPrice(dto.getAdminDiscountPrice());
        product.setAdminDiscount(dto.getAdminDiscount());
        product.setAvailableQuantity(dto.getAvailableQuantity());
        product.setTotalQuantity(dto.getTotalQuantity());
        product.setMrpPrice(dto.getMrpPrice());
        product.setDescription(dto.getDescription());
        product.setGstPercentage(dto.getGstPercentage());
        product.setDetails(dto.getDetails());
        product.setHowToUse(dto.getHowToUse());
        product.setKeyBenefits(dto.getKeyBenefits());
        product.setOtherInformation(dto.getOtherInformation());
        product.setGender(dto.getGender());
        product.setProductBrand(dto.getProductBrand());
        product.setProductImageUrl(dto.getProductImageUrl());
        product.setStoreId(dto.getStoreId());
        product.setStatus("pending");

        // Only fetch and set user if userId is provided
        if (dto.getUserId() != null) {
            userRepository.findById(dto.getUserId())
                    .ifPresent(product::setUser);
        }

        return product;
    }

}
