package com.bocxy.ecom.mapper;

import com.bocxy.ecom.DTO.BannerCatalogPriceDTO;
import com.bocxy.ecom.createDTO.BannerCatalogPriceCreateDTO;
import com.bocxy.ecom.model.BannerCatalogPrice;
import com.bocxy.ecom.model.User;
import com.bocxy.ecom.repository.BannerCatalogPriceRepository;
import com.bocxy.ecom.repository.UserRepository;
import com.bocxy.ecom.updateDTO.BannerCatalogPriceUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BannerCatalogPriceMapper {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BannerCatalogPriceRepository bannerCatalogPriceRepository;

    public BannerCatalogPrice toEntity(BannerCatalogPriceCreateDTO dto){
        BannerCatalogPrice entity=new BannerCatalogPrice();
        entity.setBannerTypeHomepage(dto.getBannerTypeHomepage());
        entity.setBannerTypeCategory(dto.getBannerTypeCategory());
        entity.setBannerTypeProduct(dto.getBannerTypeProduct());
        entity.setDisplayPriorityFirst(dto.getDisplayPriorityFirst());
        entity.setDisplayPrioritySecond(dto.getDisplayPrioritySecond());
        entity.setDisplayPriorityThird(dto.getDisplayPriorityThird());
        entity.setDisplayPriorityDays3(dto.getDisplayPriorityDays3());
        entity.setDisplayPriorityDays7(dto.getDisplayPriorityDays7());
        entity.setDisplayPriorityDays15(dto.getDisplayPriorityDays7());
        entity.setDisplayPriorityDays30(dto.getDisplayPriorityDays15());
        entity.setDisplayPriorityDays45(dto.getDisplayPriorityDays30());
        entity.setDisplayPriorityDays60(dto.getDisplayPriorityDays60());
        entity.setTargetAudienceAllCustomers(dto.getTargetAudienceAllCustomers());
        entity.setTargetAudienceMale(dto.getTargetAudienceMale());
        entity.setTargetAudienceFemale(dto.getTargetAudienceFemale());
        entity.setTargetAudienceOthers(dto.getTargetAudienceOthers());
        User createdUser=userRepository.findById(dto.getCreatedById())
                .orElseThrow(()->new RuntimeException("Created User Not Found For This Id "+dto.getCreatedById()));
        entity.setCreatedBy(createdUser);

        return entity;
    }

    public BannerCatalogPrice toEntity(Long id,BannerCatalogPriceUpdateDTO dto){
        BannerCatalogPrice entity=bannerCatalogPriceRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Banner Catalog is not found for this id "+id));

        entity.setBannerTypeHomepage(dto.getBannerTypeHomepage());
        entity.setBannerTypeCategory(dto.getBannerTypeCategory());
        entity.setBannerTypeProduct(dto.getBannerTypeProduct());
        entity.setDisplayPriorityFirst(dto.getDisplayPriorityFirst());
        entity.setDisplayPrioritySecond(dto.getDisplayPrioritySecond());
        entity.setDisplayPriorityThird(dto.getDisplayPriorityThird());
        entity.setDisplayPriorityDays3(dto.getDisplayPriorityDays3());
        entity.setDisplayPriorityDays7(dto.getDisplayPriorityDays7());
        entity.setDisplayPriorityDays15(dto.getDisplayPriorityDays7());
        entity.setDisplayPriorityDays30(dto.getDisplayPriorityDays15());
        entity.setDisplayPriorityDays45(dto.getDisplayPriorityDays30());
        entity.setDisplayPriorityDays60(dto.getDisplayPriorityDays60());
        entity.setTargetAudienceAllCustomers(dto.getTargetAudienceAllCustomers());
        entity.setTargetAudienceMale(dto.getTargetAudienceMale());
        entity.setTargetAudienceFemale(dto.getTargetAudienceFemale());
        entity.setTargetAudienceOthers(dto.getTargetAudienceOthers());
        User createdUser=userRepository.findById(dto.getCreatedById())
                .orElseThrow(()->new RuntimeException("Created User Not Found For This Id "+dto.getCreatedById()));
        entity.setCreatedBy(createdUser);

        return entity;
    }

    public BannerCatalogPriceDTO toDTO(BannerCatalogPrice entity){
        BannerCatalogPriceDTO dto=new BannerCatalogPriceDTO();

        dto.setId(entity.getId());
        dto.setBannerTypeHomepage(entity.getBannerTypeHomepage());
        dto.setBannerTypeCategory(entity.getBannerTypeCategory());
        dto.setBannerTypeProduct(entity.getBannerTypeProduct());
        dto.setDisplayPriorityFirst(entity.getDisplayPriorityFirst());
        dto.setDisplayPrioritySecond(entity.getDisplayPrioritySecond());
        dto.setDisplayPriorityThird(entity.getDisplayPriorityThird());
        dto.setDisplayPriorityDays3(entity.getDisplayPriorityDays3());
        dto.setDisplayPriorityDays7(entity.getDisplayPriorityDays7());
        dto.setDisplayPriorityDays15(entity.getDisplayPriorityDays7());
        dto.setDisplayPriorityDays30(entity.getDisplayPriorityDays15());
        dto.setDisplayPriorityDays45(entity.getDisplayPriorityDays30());
        dto.setDisplayPriorityDays60(entity.getDisplayPriorityDays60());
        dto.setTargetAudienceAllCustomers(entity.getTargetAudienceAllCustomers());
        dto.setTargetAudienceMale(entity.getTargetAudienceMale());
        dto.setTargetAudienceFemale(entity.getTargetAudienceFemale());
        dto.setTargetAudienceOthers(entity.getTargetAudienceOthers());
        dto.setCreatedById(entity.getCreatedBy().getId());
        dto.setCreatedAt(entity.getCreatedAtIST().toLocalDateTime());
        dto.setUpdatedAt(entity.getUpdatedAtIST().toLocalDateTime());

        return dto;
    }

}
