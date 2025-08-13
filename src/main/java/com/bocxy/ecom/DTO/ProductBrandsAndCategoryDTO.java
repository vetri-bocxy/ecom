package com.bocxy.ecom.DTO;

import lombok.Data;

import java.util.List;

@Data
public class ProductBrandsAndCategoryDTO {
    List<String> productBrand;
    List<String> productCategory;
}
