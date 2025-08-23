package com.bocxy.ecom.service;

import com.bocxy.ecom.DTO.EcomProductDTO;
import com.bocxy.ecom.DTO.ProductCountDTO;
import com.bocxy.ecom.mapper.EcomProductMapper;
import com.bocxy.ecom.model.EcomProduct;
import com.bocxy.ecom.model.EcomProductQuantity;
import com.bocxy.ecom.repository.EcomProductQuantityRepository;
import com.bocxy.ecom.repository.EcomProductRepository;
import com.bocxy.ecom.updateDTO.EcomProductUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class EcomProductService {
    @Autowired
    EcomProductMapper productMapper;

    private final EcomProductRepository repository;

    private final EcomProductQuantityRepository quantityRepository;

    public EcomProductService(EcomProductRepository repository,EcomProductQuantityRepository quantityRepository) {
        this.repository = repository;
        this.quantityRepository=quantityRepository;
    }

    public boolean existsByProductId(String productId) {
        return repository.existsByProductId(productId);
    }

    public EcomProduct save(EcomProduct product) {
        return repository.save(product);
    }

    public Optional<EcomProduct> findById(Long id) {
        return repository.findById(id);
    }

    public List<EcomProduct> getAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Optional<List<EcomProduct>> getAllByUserId(Long userId) {
        List<EcomProduct> products = repository.findByUserId(userId);
        return products.isEmpty() ? Optional.empty() : Optional.of(products);
    }

    public List<EcomProduct> getAllByUserIdAndProjectNameAndStatus(Long id, String projectName,String status) {
        return repository.findByUserIdAndProjectNameAndStatus(id,projectName,status);

    }

    public List<String> getDistinctProductCategories() {
        return repository.findDistinctProductCategoriesAndStatus("approved");
    }

    public List<String> getDistinctProductBrand() {
        return repository.findDistinctProductBrandsAndStatus("approved");
    }

    public List<EcomProduct> getAllByProjectName(String projectName,String storeId) {
        return repository.findByProjectName(projectName,storeId);
    }

    public void saveQty(EcomProductQuantity qtyEntity) {
        quantityRepository.save(qtyEntity);
    }

    public List<EcomProduct> getByEcomProductStatus(String status) {
        return repository.findByStatus(status);
    }

    public EcomProduct update(EcomProduct entity) {
        return repository.save(entity);
    }

    public ProductCountDTO getAllDealerProductCountAndMonth(Long userId) {
        ProductCountDTO dto=new ProductCountDTO();
        dto.setAllProducts(String.valueOf(repository.findProductCount(userId)));
        dto.setAllApprovedProducts(String.valueOf(repository.countByStatusAndUserId("approved",userId)));
        dto.setAllPendingProducts(String.valueOf(repository.countByStatusAndUserId("pending",userId)));
        dto.setAllRejectedProducts(String.valueOf(repository.countByStatusAndUserId("rejected",userId)));

        dto.setThisMonthProducts(String.valueOf(repository.findProductCountByMonthAndUser(userId)));
        dto.setThisMonthApprovedProducts(String.valueOf(repository.findProductCountByMonthAndUserAndStatus(userId,"approved")));
        dto.setThisMonthPendingProducts(String.valueOf(repository.findProductCountByMonthAndUserAndStatus(userId,"pending")));
        dto.setThisMonthRejectedProducts(String.valueOf(repository.findProductCountByMonthAndUserAndStatus(userId,"rejected")));

        return dto;
    }
}
