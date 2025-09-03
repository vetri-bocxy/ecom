package com.bocxy.ecom.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;


@Data
@Entity
@Table(name = "ecom_product")
public class EcomProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private String projectName;
    private String productName;
    @Column(name = "product_category")
    private String productCategory;
    @Column(name = "product_type")
    private String productType;
    @Column(name = "product_formulation")
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
    @Column(name="how_to_use")
    private String howToUse;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private BigDecimal mrpPrice;
    @Column(length = 1000)
    private String description;
    private String gstPercentage;
    @Column(length = 1000)
    private String details;
    @Column(name = "gender")
    private String gender;
    @Column(name = "product_brand")
    private String productBrand;
    private String productImageUrl;
    private String storeId;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @UpdateTimestamp
    private LocalDateTime statusAt;
    @Column(name="status")
    private String status;
    @Column(name="reject_remarks")
    private String rejectRemarks;
    @Column(name="brand_id")
    private String brandId;
    @Column(name="franchise_id")
    private String franchiseId;
    @Column(name="key_benefits")
    private String keyBenefits;
    @Column(name="other_information")
    private String otherInformation;
    public ZonedDateTime getCreatedAtIST() {
        return createdAt.atZone(ZoneId.of("UTC")).withZoneSameInstant(ZoneId.of("Asia/Kolkata"));
    }

    public ZonedDateTime getUpdatedAtIST() {
        return updatedAt.atZone(ZoneId.of("UTC")).withZoneSameInstant(ZoneId.of("Asia/Kolkata"));
    }
}
