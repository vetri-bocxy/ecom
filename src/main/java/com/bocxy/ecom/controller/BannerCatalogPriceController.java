package com.bocxy.ecom.controller;

import com.bocxy.ecom.DTO.ResponseDTO;
import com.bocxy.ecom.apiService.BannerCatalogPriceApiService;
import com.bocxy.ecom.createDTO.BannerCatalogPriceCreateDTO;
import com.bocxy.ecom.updateDTO.BannerCatalogPriceUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bannerCatalogs")
public class BannerCatalogPriceController {
    @Autowired
    BannerCatalogPriceApiService bcpApiService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> create(@RequestBody BannerCatalogPriceCreateDTO dto){
        return ResponseEntity.ok(new ResponseDTO(200,"Success",bcpApiService.create(dto)));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> get(@PathVariable Long id){
        return ResponseEntity.ok(new ResponseDTO(200,"Success",bcpApiService.get(id)));
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO> getAll(){
        return ResponseEntity.ok(new ResponseDTO(200,"Success",bcpApiService.getAll()));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable Long id, @RequestBody BannerCatalogPriceUpdateDTO dto){
        dto.setId(id);
        return ResponseEntity.ok(new ResponseDTO(200,"Success",bcpApiService.update(dto)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(new ResponseDTO(200,"Success",bcpApiService.delete(id)));
    }

    @GetMapping("/getByUserId/{id}")
    public ResponseEntity<ResponseDTO> getByUserId(@PathVariable Long id){
        return ResponseEntity.ok(new ResponseDTO(200,"Success",bcpApiService.getByUserId(id)));
    }

}
