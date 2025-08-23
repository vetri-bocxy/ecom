package com.bocxy.ecom.DTO;

import lombok.Data;

@Data
public class ProductCountDTO {
    private String allProducts;
    private String allApprovedProducts;
    private String allRejectedProducts;
    private String allPendingProducts;

    private String thisMonthProducts;
    private String thisMonthApprovedProducts;
    private String thisMonthRejectedProducts;
    private String thisMonthPendingProducts;
}
