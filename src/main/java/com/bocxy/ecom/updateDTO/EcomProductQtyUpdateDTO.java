package com.bocxy.ecom.updateDTO;

import lombok.Data;

@Data
public class EcomProductQtyUpdateDTO {

    private Long id;
    private String storeId;
    private String userId;
    private Long productId;
    private int quantity;
    private int sales;
    private int available;
    private int freeQuantity;
    private int alertCount;

}
