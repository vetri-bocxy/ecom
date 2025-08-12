package com.bocxy.ecom.controller;


import com.bocxy.ecom.DTO.EcomProductDTO;
import com.bocxy.ecom.apiService.EcomProductApiService;
import com.bocxy.ecom.createDTO.EcomProductCreateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class EcomProductController {

    private final EcomProductApiService apiService;

    public EcomProductController(EcomProductApiService apiService) {
        this.apiService = apiService;
    }

    @PostMapping
    public ResponseEntity<EcomProductDTO> create(@RequestBody EcomProductCreateDTO createDTO) {
        return ResponseEntity.ok(apiService.create(createDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EcomProductDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(apiService.getById(id));
    }

    @GetMapping("/getAllByUser/{userId}")
    public ResponseEntity<List<EcomProductDTO>> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(apiService.getByUserId(userId));
    }

    @GetMapping
    public ResponseEntity<List<EcomProductDTO>> getAll() {
        return ResponseEntity.ok(apiService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EcomProductDTO> update(@PathVariable Long id, @RequestBody EcomProductCreateDTO createDTO) {
        return ResponseEntity.ok(apiService.update(id, createDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        apiService.delete(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

}
