package com.bocxy.ecom.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EcomProductQtyResponseDTO {

    private Long id;
    private int quantity;
    private int sales;
    private int available;
    private int freeQuantity;
    private int alertCount;
    private Long productId;      // Only ID, not full entity
    private String productName;  // Optional if you want to show name
    private String storeId;
    private String userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
