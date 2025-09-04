package com.bocxy.ecom.DTO;

import com.bocxy.ecom.model.FileUploadEntity;
import com.bocxy.ecom.model.User;
import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;


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
    private BigDecimal adminGstAmount;
    private BigDecimal sellerPayableAmount;
    private BigDecimal bocxyDeductionAmount;
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
    private User user;
    private List<FileUploadEntity> files;
}
