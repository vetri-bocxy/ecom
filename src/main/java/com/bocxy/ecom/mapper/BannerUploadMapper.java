package com.bocxy.ecom.mapper;

import com.bocxy.ecom.DTO.BannerUploadResponseDTO;
import com.bocxy.ecom.model.BannerUploadEntity;
import org.springframework.stereotype.Component;

@Component
public class BannerUploadMapper {

    public BannerUploadResponseDTO toDTO(BannerUploadEntity entity){
        BannerUploadResponseDTO dto=new BannerUploadResponseDTO();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setUploadedAt(entity.getUploadedAt());
        dto.setStoredFileName(entity.getStoredFileName());
        dto.setOriginalFileName(entity.getOriginalFileName());
        dto.setUrl(entity.getUrl());
        return dto;
    }
}
