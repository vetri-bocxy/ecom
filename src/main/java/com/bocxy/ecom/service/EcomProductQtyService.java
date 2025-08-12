package com.bocxy.ecom.service;


import com.bocxy.ecom.model.EcomProductQuantity;
import com.bocxy.ecom.repository.EcomProductQuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EcomProductQtyService {

    @Autowired
    private EcomProductQuantityRepository ecomProductQuantityRepository;

    public EcomProductQuantity create(EcomProductQuantity entity) {
       return ecomProductQuantityRepository.save(entity);
    }

    public List<EcomProductQuantity> getAll() {
        return ecomProductQuantityRepository.findAll();
    }

    public EcomProductQuantity update(EcomProductQuantity entity) {
        return ecomProductQuantityRepository.save(entity);
    }

    public Optional<EcomProductQuantity> getById(Long id) {
        return ecomProductQuantityRepository.findById(id);
    }

    public Optional<List<EcomProductQuantity>> getAllByUserId(String userId) {
        List<EcomProductQuantity> products = ecomProductQuantityRepository.findByUserId(userId);
        return products.isEmpty() ? Optional.empty() : Optional.of(products);
    }
}
