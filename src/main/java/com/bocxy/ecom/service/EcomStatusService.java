package com.bocxy.ecom.service;


import com.bocxy.ecom.DTO.EcomProductDTO;
import com.bocxy.ecom.DTO.EcomProductStatusWiseDto;
import com.bocxy.ecom.model.EcomProduct;
import com.bocxy.ecom.repository.EcomProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EcomStatusService {

    @Autowired
    private EcomProductRepository repository;

    public EcomProduct save(EcomProduct product) {
        return repository.save(product);
    }

    public List<EcomProduct> getAll() {
        return repository.findAll();
    }

    public List<EcomProduct> getByStatus(String status) {
        return repository.findByStatus(status);
    }
}
