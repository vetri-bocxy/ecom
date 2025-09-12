package com.bocxy.ecom.createDTO;


import org.springframework.web.multipart.MultipartFile;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@Data
public class MultiProductCreateDTO {

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
    private String howToUse;
    private String description;
    private String gstPercentage;
    private String details;
    private String gender;
    private String productBrand;
    private String productImageUrl;
    private String storeId;
    private String rejectRemarks;
    private String brandId;
    private String franchiseId;
    private String keyBenefits;
    private String otherInformation;
    private Long userId;

//    private MultipartFile productImage;
    private List<MultipartFile> productImage;
//    private MultipartFile documentationFile;
}
