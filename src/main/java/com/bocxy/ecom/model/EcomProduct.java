package com.bocxy.ecom.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @Column(unique = true, nullable = true)
    private String productId;
    @Column(nullable = false)
    private String projectName;
    @NotNull
    @Size(max = 100)
    private String productName;

    @Column(name = "product_category", nullable = false)
    private String productCategory;

    @Column(name = "product_type", nullable = false)
    private String productType;

    @Column(name = "product_formulation", nullable = false)
    private String productFormulation;


    @NotNull
    private BigDecimal discountPrice;

    @Column(name="how_to_use")
    private String howToUse;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    private BigDecimal comparedPrice;

    @Column(length = 1000)
    private String description;

    private String gstPercentage;


    @Column(length = 1000)
    private String details;


    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "product_brand", nullable = false)
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
