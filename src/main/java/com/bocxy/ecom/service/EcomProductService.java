package com.bocxy.ecom.service;

import com.bocxy.ecom.DTO.EcomProductDTO;
import com.bocxy.ecom.model.EcomProduct;
import com.bocxy.ecom.repository.EcomProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class EcomProductService {
    private static final Logger log = LogManager.getLogger(EcomProductService.class);


    private final EcomProductRepository repository;

    public EcomProductService(EcomProductRepository repository) {
        this.repository = repository;
    }

    public boolean existsByProductId(String productId) {
        return repository.existsByProductId(productId);
    }

    public EcomProduct save(EcomProduct product) {
        log.info("logger works!");
        return repository.save(product);
    }

    public Optional<EcomProduct> findById(Long id) {
        return repository.findById(id);
    }

    public List<EcomProduct> findAll() {
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
}
