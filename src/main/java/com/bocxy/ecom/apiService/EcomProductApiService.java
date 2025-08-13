package com.bocxy.ecom.apiService;


import com.bocxy.ecom.DTO.EcomProductDTO;
import com.bocxy.ecom.DTO.ProductBrandsAndCategoriesDTO;
import com.bocxy.ecom.mapper.EcomProductMapper;
import com.bocxy.ecom.model.EcomProduct;
import com.bocxy.ecom.service.EcomProductService;
import org.springframework.stereotype.Service;
import com.bocxy.ecom.createDTO.EcomProductCreateDTO;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EcomProductApiService {

    private final EcomProductService productService;
    private final EcomProductMapper productMapper;

    public EcomProductApiService(EcomProductService productService, EcomProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    public EcomProductDTO create(EcomProductCreateDTO createDTO) {
        System.out.println(createDTO.getProductId());
        if(createDTO.getProductId()!=null){
            if (productService.existsByProductId(createDTO.getProductId())) {
                throw new RuntimeException("Product with this ID already exists");
            }
        }

        EcomProduct saved = productService.save(productMapper.toEntity(createDTO));
        return productMapper.toDTO(saved);
    }

    public EcomProductDTO getById(Long id) {
        return productService.findById(id)
                .map(productMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<EcomProductDTO> getAll() {
        return productService.findAll().stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EcomProductDTO update(Long id, EcomProductCreateDTO createDTO) {
        EcomProduct existing = productService.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        EcomProduct updated = productMapper.toEntity(createDTO);
        updated.setId(existing.getId());
        return productMapper.toDTO(productService.save(updated));
    }

    public void delete(Long id) {
        productService.deleteById(id);
    }

    public List<EcomProductDTO> getByUserId(Long userId) {
        return productService.getAllByUserId(userId)
                .map(list -> list.stream()
                        .map(productMapper::toDTO)
                        .collect(Collectors.toList()))
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<EcomProductDTO> getAll(Long id, String projectName) {
        return productService.getAllByUserIdAndProjectName(id,projectName)
                .stream()
                .map(productMapper::toDTO)
                .toList();
    }

    public ProductBrandsAndCategoriesDTO getAllProductBrandsAndCategories() {
        ProductBrandsAndCategoriesDTO dto=new ProductBrandsAndCategoriesDTO();
        dto.setProductCategory(productService.getDistinctProductCategories());
        dto.setProductBrand(productService.getDistinctProductBrand());
        return dto;
    }


}
