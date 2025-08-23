package com.bocxy.ecom.controller;


import com.bocxy.ecom.DTO.EcomProductDTO;
import com.bocxy.ecom.DTO.EcomProductStatusWiseDto;
import com.bocxy.ecom.DTO.ProductBrandsAndCategoriesDTO;
import com.bocxy.ecom.DTO.ProductCountDTO;
import com.bocxy.ecom.apiService.EcomProductApiService;
import com.bocxy.ecom.createDTO.EcomProductCreateDTO;
import com.bocxy.ecom.updateDTO.EcomProductUpdateDTO;
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
    @PostMapping("/create")
    public ResponseEntity<EcomProductDTO> create1(@RequestBody EcomProductCreateDTO createDTO) {
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

    @GetMapping("/getAll")
    public ResponseEntity<List<EcomProductDTO>> getAll() {
        return ResponseEntity.ok(apiService.getAll());
    }

    @PutMapping("/update")
    public ResponseEntity<EcomProductDTO> update(@RequestBody EcomProductUpdateDTO updateDTO) {
        return ResponseEntity.ok(apiService.update(updateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        apiService.delete(id);
        return ResponseEntity.ok("Product deleted successfully");
    }

    @GetMapping("/getAllByUserIdAndProjectName")
    public ResponseEntity<EcomProductStatusWiseDto> getByUserId(@RequestParam Long id,@RequestParam String projectName) {
        return ResponseEntity.ok(apiService.getAllByUserIdAndProjectName(id,projectName));
    }

    @GetMapping("/getAllByProjectName")
    public ResponseEntity<List<EcomProductDTO>> getAllByProjectName(@RequestParam String projectName,@RequestParam String storeId) {
        return ResponseEntity.ok(apiService.getAllByProjectName(projectName,storeId));
    }

    @GetMapping("/getAllProductBrandsAndCategories")
    public ResponseEntity<ProductBrandsAndCategoriesDTO> getAllBrandsAndCategories(){
        return ResponseEntity.ok(apiService.getAllProductBrandsAndCategories());
    }

    @GetMapping("getEcomProductStatusWise")
    public ResponseEntity<EcomProductStatusWiseDto> getEcomProductStatusWise() {
        return ResponseEntity.ok(apiService.getEcomProductStatusWise());
    }

    @GetMapping("getAllDealerProductCountAndMonth")
    public ResponseEntity<ProductCountDTO> getAllDealerProductCountAndMonth(@RequestParam(required = false) Long userId) {
        return ResponseEntity.ok(apiService.getAllDealerProductCountAndMonth(userId));
    }
}
