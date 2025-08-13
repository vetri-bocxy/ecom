package com.bocxy.ecom.service;

import com.bocxy.ecom.model.EcomProduct;
import com.bocxy.ecom.model.EcomProductQuantity;
import com.bocxy.ecom.repository.EcomProductQuantityRepository;
import com.bocxy.ecom.repository.EcomProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class EcomProductService {

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

    public List<EcomProduct> getAllByUserIdAndProjectName(Long id, String projectName) {
        return repository.findByUserIdAndProjectName(id,projectName);

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
}
