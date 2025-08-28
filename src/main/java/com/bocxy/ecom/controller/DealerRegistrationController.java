package com.bocxy.ecom.controller;


import com.bocxy.ecom.DTO.DealerRegistrationResponseDTO;
import com.bocxy.ecom.DTO.ResponseDTO;
import com.bocxy.ecom.Exception.UsernameAlreadyExistsException;
import com.bocxy.ecom.apiService.DealerRegistrationApiService;
import com.bocxy.ecom.createDTO.dealer.DealerRegistrationDTO;
import com.bocxy.ecom.service.DealerRegistrationService;
import com.bocxy.ecom.updateDTO.DealerRegistrationUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/dealerRegister")
public class DealerRegistrationController {



    @Autowired
    private DealerRegistrationApiService dealerRegistrationApiService;

    @Autowired
    private DealerRegistrationService dealerRegistrationService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> create(@RequestBody DealerRegistrationDTO registrationDTO) {
        try {
            DealerRegistrationResponseDTO responseDTO = dealerRegistrationApiService.create(registrationDTO);
            return ResponseEntity.ok(new ResponseDTO(200, "Success", responseDTO));
        } catch (UsernameAlreadyExistsException e) {
            return ResponseEntity.ok(new ResponseDTO(200, e.getMessage(), null)); // Returning 200 with error msg
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(500, "An unexpected error occurred", null));
        }
    }


    @PostMapping("/update")
    public ResponseEntity<ResponseDTO> create(@RequestBody DealerRegistrationUpdateDTO registrationUpdateDTO) {
        DealerRegistrationResponseDTO responseDTO = dealerRegistrationApiService.update(registrationUpdateDTO);
        return ResponseEntity.ok(new ResponseDTO(200, "Success", responseDTO));
    }


    @PostMapping("/approve")
    public ResponseEntity<ResponseDTO> approveDealers(@RequestBody List<Long> dealerIds) {
        dealerRegistrationService.approveDealers(dealerIds);
        return ResponseEntity.ok(new ResponseDTO(200, "Dealers approved and users created successfully", dealerIds));
    }


    @PostMapping("/reject/{dealerId}")
    public ResponseEntity<ResponseDTO> rejectDealer(
            @PathVariable Long dealerId,
            @RequestParam String reason) {
        dealerRegistrationService.rejectDealer(dealerId, reason);
        return ResponseEntity.ok(new ResponseDTO(200, "Dealer rejected successfully", null));
    }

    @GetMapping("/getAllDealers")
    public ResponseEntity<ResponseDTO> getAllDealers() {
        List<DealerRegistrationResponseDTO> dealerList = dealerRegistrationApiService.getAllDealerList();
        return ResponseEntity.ok(new ResponseDTO(200, "Dealers fetched successfully", dealerList));
    }

    @GetMapping("/getById")
    public ResponseEntity<ResponseDTO> getById(@RequestParam Long id){
        return ResponseEntity.ok(new ResponseDTO(200, "Dealers fetched successfully", dealerRegistrationApiService.getById(id)));
    }

    @GetMapping("/getAllBusinessNameAndGSTNumber")
    public ResponseEntity<ResponseDTO> getAllStoreNameAndGSTNumber(){
        Map<String,List<String>> result=new HashMap<>();
        result.put("businessNames",dealerRegistrationApiService.getAllBusinessName());
        result.put("GSTNumbers",dealerRegistrationApiService.getAllGSTNumber());
        return ResponseEntity.ok(new ResponseDTO(200, "Dealers fetched successfully",result));
    }

}
