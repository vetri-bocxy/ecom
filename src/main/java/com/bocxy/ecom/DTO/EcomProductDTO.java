package com.bocxy.ecom.DTO;

import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;


@Data
public class EcomProductDTO {

    private Long id;
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
    private int totalQuantity;
    private int availableQuantity;
    private BigDecimal mrpPrice;
    private String description;
    private String gstPercentage;
    private String details;
    private String gender;
    private String productBrand;
    private String productImageUrl;
    private String storeId;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private String keyBenefits;
    private String otherInformation;
    private String howToUse;
    private String status;
}
