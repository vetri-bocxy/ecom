package com.bocxy.ecom.createDTO;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class EcomProductCreateDTO {

    private String productId;
    private String projectName;
    private String productName;
    private String productCategory;
    private String productType;
    private String productFormulation;
    private BigDecimal discountPrice;
    private BigDecimal sellerPrice;
    private BigDecimal platformPrice;
    private BigDecimal adminDiscountPrice;
    private int adminDiscount;
    private BigDecimal mrpPrice;
    private String howToUse;
    private String description;
    private String gstPercentage;
    private String details;
    private String gender;
    private String productBrand;
    private String productImageUrl;
    private String storeId;
    private String status;
    private String rejectRemarks;
    private String brandId;
    private String franchiseId;
    private String keyBenefits;
    private String otherInformation;
    private Long userId;
    private int totalQuantity;
}
