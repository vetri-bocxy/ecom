package com.bocxy.ecom.createDTO;

import lombok.Data;

@Data
public class EcomProductQuantityDTO {

    private String storeId;
    private String userId;
    private Long productId;
    private int quantity;
    private int sales;
    private int available;
    private int freeQuantity;
    private int alertCount;

}
