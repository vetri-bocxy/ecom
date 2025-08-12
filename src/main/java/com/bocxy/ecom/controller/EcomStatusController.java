package com.bocxy.ecom.controller;

import com.bocxy.ecom.createDTO.EcomStatusDTO;
import com.bocxy.ecom.model.EcomProduct;
import com.bocxy.ecom.apiService.EcomStatusApiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class EcomStatusController {

    private final EcomStatusApiService ecomStatusApiService;

    public EcomStatusController(EcomStatusApiService ecomStatusApiService) {
        this.ecomStatusApiService = ecomStatusApiService;
    }

    @PostMapping("/approved")
    public ResponseEntity<EcomProduct> approveProduct(@RequestBody EcomStatusDTO dto) {
        return ResponseEntity.ok(ecomStatusApiService.approveProduct(dto));
    }

    @PostMapping("/reject")
    public ResponseEntity<EcomProduct> rejectProduct(@RequestBody EcomStatusDTO dto) {
        return ResponseEntity.ok(ecomStatusApiService.rejectProduct(dto));
    }

    @GetMapping("/approved")
    public ResponseEntity<List<EcomProduct>> getApproved() {
        return ResponseEntity.ok(ecomStatusApiService.getApproved());
    }


    @GetMapping("/rejected")
    public ResponseEntity<List<EcomProduct>> getRejected() {
        return ResponseEntity.ok(ecomStatusApiService.getRejected());
    }

    @GetMapping("/pending")
    public ResponseEntity<List<EcomProduct>> getPending() {
        return ResponseEntity.ok(ecomStatusApiService.getPending());
    }

}
