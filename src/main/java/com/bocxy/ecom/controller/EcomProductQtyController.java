package com.bocxy.ecom.controller;

import com.bocxy.ecom.DTO.EcomProductQtyResponseDTO;
import com.bocxy.ecom.DTO.ResponseDTO;
import com.bocxy.ecom.apiService.EcomProductQtyApiService;
import com.bocxy.ecom.createDTO.EcomProductQuantityDTO;
import com.bocxy.ecom.updateDTO.EcomProductQtyUpdateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products/quantity")
public class EcomProductQtyController {

    private final EcomProductQtyApiService ecomProductQtyService;

    public EcomProductQtyController(EcomProductQtyApiService ecomProductQtyService) {
        super();
        this.ecomProductQtyService = ecomProductQtyService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createQuantity(@RequestBody EcomProductQuantityDTO ecomProductQuantityDTO) {
        EcomProductQtyResponseDTO responseDTO=ecomProductQtyService.create(ecomProductQuantityDTO);
        return ResponseEntity.ok(new ResponseDTO(200,"Success",responseDTO));
    }

    @PostMapping("/updateById")
    public ResponseEntity<ResponseDTO> updateQuantity(@RequestBody EcomProductQtyUpdateDTO ecomProductQtyUpdateDTO){
        EcomProductQtyResponseDTO responseDTO=ecomProductQtyService.update(ecomProductQtyUpdateDTO);
        return ResponseEntity.ok(new ResponseDTO(200,"Success",responseDTO));
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO> getAllProductQuantity() {
        List<EcomProductQtyResponseDTO> responseDTO = ecomProductQtyService.getAllProductQuantity();
        return ResponseEntity.ok(new ResponseDTO(200, "Success", responseDTO));
    }

    @GetMapping("/getById")
    public ResponseEntity<ResponseDTO> getProductQuantityById(@RequestParam Long id){
        EcomProductQtyResponseDTO responseDTO=ecomProductQtyService.getProductQuantityById(id);
        return ResponseEntity.ok(new ResponseDTO(200,"Success",responseDTO));
    }

    @GetMapping("/getByUserId")
    public ResponseEntity<ResponseDTO> getProductQuantityByUserId(@RequestParam String id){
        List<EcomProductQtyResponseDTO> responseDTO=ecomProductQtyService.getProductQuantityByUserId(id);
        return ResponseEntity.ok(new ResponseDTO(200,"Success",responseDTO));
    }
}
