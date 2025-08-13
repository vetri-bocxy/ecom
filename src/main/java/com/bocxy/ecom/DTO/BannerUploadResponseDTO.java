package com.bocxy.ecom.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BannerUploadResponseDTO {
    private Long id;
    private String originalFileName;
    private String storedFileName;
    private String url;
    private Long mid;
    private String description;
    private LocalDateTime uploadedAt;
}
