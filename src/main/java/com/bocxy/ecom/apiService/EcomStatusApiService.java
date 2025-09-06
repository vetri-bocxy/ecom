package com.bocxy.ecom.apiService;


import com.bocxy.ecom.DTO.EcomProductDTO;
import com.bocxy.ecom.DTO.EcomProductStatusWiseDto;
import com.bocxy.ecom.createDTO.EcomStatusDTO;
import com.bocxy.ecom.mapper.EcomProductMapper;
import com.bocxy.ecom.mapper.EcomStatusMapper;
import com.bocxy.ecom.model.EcomProduct;
import com.bocxy.ecom.service.EcomProductService;
import com.bocxy.ecom.service.EcomStatusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EcomStatusApiService {

    private final EcomStatusService ecomStatusService;
    private final EcomStatusMapper ecomStatusMapper;
    private final EcomProductService productService;
    private final EcomProductMapper productMapper;

    public EcomStatusApiService(EcomStatusService ecomStatusService, EcomStatusMapper ecomStatusMapper, EcomProductService productService, EcomProductMapper productMapper) {
        this.ecomStatusService = ecomStatusService;
        this.ecomStatusMapper = ecomStatusMapper;
        this.productService = productService;
        this.productMapper = productMapper;
    }


    public EcomProduct approveProduct(EcomStatusDTO dto) {
        EcomProduct product = ecomStatusMapper.toEntityApprove(dto);
        return ecomStatusService.save(product);
    }

    public EcomProduct rejectProduct(EcomStatusDTO dto) {
        EcomProduct product = ecomStatusMapper.toEntityReject(dto);
        return ecomStatusService.save(product);
    }

    public List<EcomProduct> getAll() {
        return ecomStatusService.getAll();
    }

//    public List<EcomProduct> getApproved() {
//        return ecomStatusService.getByStatus("approved");
//    }

    public List<EcomProduct> getRejected() {
        return ecomStatusService.getByStatus("reject");
    }

    public List<EcomProduct> getPending() {
        return ecomStatusService.getByStatus("pending");
    }

    public List<EcomProductDTO> getApproved() {
        return productService.getByStatus("approved").stream()
                .map(productMapper::toDTO)
                .toList();
    }
}
