package com.bocxy.ecom.apiService;


import com.bocxy.ecom.DTO.EcomProductDTO;
import com.bocxy.ecom.DTO.EcomProductStatusWiseDto;
import com.bocxy.ecom.DTO.ProductBrandsAndCategoriesDTO;
import com.bocxy.ecom.DTO.ProductCountDTO;
import com.bocxy.ecom.mapper.EcomProductMapper;
import com.bocxy.ecom.model.EcomProduct;
import com.bocxy.ecom.model.EcomProductQuantity;
import com.bocxy.ecom.service.EcomProductService;
import com.bocxy.ecom.updateDTO.EcomProductUpdateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.bocxy.ecom.createDTO.EcomProductCreateDTO;
import org.springframework.web.bind.annotation.RequestParam;

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
        if (createDTO.getProductId() != null) {
            if (productService.existsByProductId(createDTO.getProductId())) {
                throw new RuntimeException("Product with this ID already exists");
            }
        }
        EcomProduct saved = productService.save(productMapper.toEntity(createDTO));

        EcomProductQuantity qtyEntity = new EcomProductQuantity();
        qtyEntity.setQuantity(createDTO.getTotalQuantity());
        qtyEntity.setEcomProduct(saved);
        qtyEntity.setAvailable(createDTO.getTotalQuantity());
        if (createDTO.getStoreId() != null && !createDTO.getStoreId().isEmpty()) {
            qtyEntity.setStoreId(createDTO.getStoreId());
        }
        productService.saveQty(qtyEntity);

        return productMapper.toDTO(saved);
    }

    public EcomProductDTO getById(Long id) {
        return productService.findById(id)
                .map(productMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<EcomProductDTO> getAll() {
        return productService.getAll().stream()
                .map(productMapper::toDTO)
                .toList();
    }

    public EcomProductDTO update(EcomProductUpdateDTO dto) {
        return productMapper.toDTO(productService.update(productMapper.toEntity(dto)));
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

    public EcomProductStatusWiseDto getAllByUserIdAndProjectName(Long id, String projectName) {
        EcomProductStatusWiseDto dto = new EcomProductStatusWiseDto();
        dto.setPending(productService.getAllByUserIdAndProjectNameAndStatus(id, projectName, "pending")
                .stream().map(productMapper::toDTO).toList());
        dto.setApproved(productService.getAllByUserIdAndProjectNameAndStatus(id, projectName, "approved")
                .stream().map(productMapper::toDTO).toList());
        dto.setRejected(productService.getAllByUserIdAndProjectNameAndStatus(id, projectName, "rejected")
                .stream().map(productMapper::toDTO).toList());

        return dto;
    }

    public ProductBrandsAndCategoriesDTO getAllProductBrandsAndCategories() {
        ProductBrandsAndCategoriesDTO dto = new ProductBrandsAndCategoriesDTO();
        dto.setProductCategory(productService.getDistinctProductCategories());
        dto.setProductBrand(productService.getDistinctProductBrand());
        return dto;
    }


    public List<EcomProductDTO> getAllByProjectName(String projectName, String storeId) {
        return productService.getAllByProjectName(projectName, storeId)
                .stream()
                .map(productMapper::toDTO)
                .toList();
    }

    public EcomProductStatusWiseDto getEcomProductStatusWise() {
        EcomProductStatusWiseDto dto = new EcomProductStatusWiseDto();
        dto.setPending(productService.getByEcomProductStatus("pending").stream().map(productMapper::toDTO).toList());
        dto.setApproved(productService.getByEcomProductStatus("approved").stream().map(productMapper::toDTO).toList());
        dto.setRejected(productService.getByEcomProductStatus("rejected").stream().map(productMapper::toDTO).toList());
        return dto;

    }

    public ProductCountDTO getAllDealerProductCountAndMonth(Long userId) {
        return productService.getAllDealerProductCountAndMonth(userId);
    }

    public List<String> getAllProductCategory() {
        return productService.getAllProductCategory();
    }

    public ProductCountDTO getAllPartnerProductCountAndMonth(String storeId, String projectName) {
        return productService.getAllPartnerProductCountAndMonth(storeId, projectName);
    }

    public List<EcomProductDTO> getTodayUpdatedProducts() {
        return productService.getTodayUpdatedProducts().stream().map(productMapper::toDTO).toList();
    }
}
