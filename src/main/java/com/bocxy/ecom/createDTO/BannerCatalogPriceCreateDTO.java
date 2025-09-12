package com.bocxy.ecom.createDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BannerCatalogPriceCreateDTO {

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


    private Long createdById;

}
