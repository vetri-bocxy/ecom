package com.bocxy.ecom.mapper;

import com.bocxy.ecom.DTO.EcomProductDTO;
import com.bocxy.ecom.createDTO.EcomProductCreateDTO;
import com.bocxy.ecom.model.DealerRegistrationEntity;
import com.bocxy.ecom.model.EcomProduct;
import com.bocxy.ecom.model.User;
import com.bocxy.ecom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EcomProductMapper {

    @Autowired
    private UserRepository userRepository;


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
        dto.setComparedPrice(product.getComparedPrice());
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
        return dto;
    }

    public EcomProduct toEntity(EcomProductCreateDTO dto) {

        User user=userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not found " + dto.getUserId()));

        EcomProduct product = new EcomProduct();
        if(dto.getProductId()!=null){
            product.setProductId(dto.getProductId());
        }
        product.setProjectName(dto.getProjectName());
        product.setProductName(dto.getProductName());
        product.setProductCategory(dto.getProductCategory());
        product.setProductType(dto.getProductType());
        product.setProductFormulation(dto.getProductFormulation());
        product.setDiscountPrice(dto.getDiscountPrice());
        product.setComparedPrice(dto.getComparedPrice());
        product.setDescription(dto.getDescription());
        product.setGstPercentage(dto.getGstPercentage());
        product.setDetails(dto.getDetails());
        product.setHowToUse(dto.getHowToUse());
        product.setKeyBenefits(dto.getKeyBenefits());
        product.setOtherInformation(dto.getOtherInformation());
        product.setGender(dto.getGender());
        product.setProductBrand(dto.getProductBrand());
        product.setProductImageUrl(dto.getProductImageUrl());
        product.setUser(user);
        product.setStoreId(dto.getStoreId());
        product.setStatus("pending");
        return product;
    }
}
