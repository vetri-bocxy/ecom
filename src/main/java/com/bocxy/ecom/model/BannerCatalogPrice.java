package com.bocxy.ecom.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Data
@Entity
@Table(name = "banner_catalog_price")
@NoArgsConstructor
@AllArgsConstructor
public class BannerCatalogPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private BigDecimal bannerTypeHomepage;
    private BigDecimal bannerTypeCategory;
    private BigDecimal bannerTypeProduct;
    private BigDecimal displayPriorityFirst;
    private BigDecimal displayPrioritySecond;
    private BigDecimal displayPriorityThird;
    private BigDecimal displayPriorityDays3;
    private BigDecimal displayPriorityDays7;
    private BigDecimal displayPriorityDays15;
    private BigDecimal displayPriorityDays30;
    private BigDecimal displayPriorityDays45;
    private BigDecimal displayPriorityDays60;
    private BigDecimal targetAudienceAllCustomers;
    private BigDecimal targetAudienceMale;
    private BigDecimal targetAudienceFemale;
    private BigDecimal targetAudienceOthers;

    @OneToOne
    @JoinColumn(name="createdById")
    private User createdBy;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public ZonedDateTime getCreatedAtIST() {
        return createdAt.atZone(ZoneId.of("UTC")).withZoneSameInstant(ZoneId.of("Asia/Kolkata"));
    }

    public ZonedDateTime getUpdatedAtIST() {
        return updatedAt.atZone(ZoneId.of("UTC")).withZoneSameInstant(ZoneId.of("Asia/Kolkata"));
    }
}